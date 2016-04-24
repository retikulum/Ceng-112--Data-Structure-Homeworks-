public class RPNCalcA {
    public static final int NT_ADD = 0;
    public static final int NT_SUB = 1;
    public static final int NT_MUL = 2;
    public static final int NT_DIV = 3;
    public static final int NT_NUMBER = 4;

    public static class Node {
        int type;
        int value;

        Node left;
        Node right;
    };
    //This is my code !!!!!!
    public class NodeVisitor{
        private Node n;
        public void visit(Node n){
            StdOut.printf("%d",n.value);
        }
    }
    public static void traverse(NodeVisitor prefix,NodeVisitor infix, NodeVisitor postfix){
        if(prefix != null)
            prefix.visit(prefix);
        if(infix != null)
            infix.visit(infix);
        if(postfix != null)
            postfix.visit(postfix);
    }

    public static void main(String[] args) {
        StdOut.printf("Reverse Polish Calculator. Enter empty line to quit\n");
        StdOut.printf("> ");
        while (StdIn.hasNextLine()) {
            if (processLine(StdIn.readLine()))
                break;
            StdOut.printf("> ");
        }

        StdOut.printf("\n");
    }
    private static boolean processLine(String line) {
        Stack<Node> s = new Stack<Node>(4);

        if (line.isEmpty())
            return true;
        
        String[] tokens = line.split("\\s+");
        for (String tokenText: tokens) {
                Node node = parseToken(tokenText);
                switch (node.type) {
                case NT_ADD:
                case NT_SUB:
                case NT_MUL:
                case NT_DIV:
                        if (s.size() < 2)
                            throw new RuntimeException("Error in parse tree!");

                        node.right = s.pop();
                        node.left = s.pop();
                        s.push(node);
                        break;
                case NT_NUMBER: s.push(node); break;
                }
        }

        Node parseTree = s.pop();
        if (!s.isEmpty())
            throw new RuntimeException("Error in parse tree!");

        printTreeInfix(parseTree);
        StdOut.printf(" = %d\n", evalTree(parseTree));

        return false;
    }

    public static Node parseToken(String tokenText) {
        Node n = new Node();
        n.left = null;
        n.right = null;

        if (tokenText.equals("+")) {
                n.type = NT_ADD;
        } else if (tokenText.equals("-")) {
                n.type = NT_SUB;
        } else if (tokenText.equals("*")) {
                n.type = NT_MUL;
        } else if (tokenText.equals("/")) {
                n.type = NT_DIV;
        } else {
                n.type = NT_NUMBER;
                n.value = Integer.parseInt(tokenText);
        }

        return n;
    }

    public static int evalTree(Node tree) {
        if (tree.type == NT_NUMBER)
                return tree.value;

        int leftValue = evalTree(tree.left);
        int rightValue = evalTree(tree.right);

        switch (tree.type) {
        case NT_ADD: return leftValue + rightValue;
        case NT_SUB: return leftValue - rightValue;
        case NT_MUL: return leftValue * rightValue;
        case NT_DIV: return leftValue / rightValue;
        default:
            throw new RuntimeException("Error in parse tree!");
        }
    }

    public static void printTreeInfix(NodeVisitor tree) {
        if (tree.type == NT_NUMBER) {
                StdOut.printf("%d", tree.value);
                return;
        }
        traverse(tree.left,tree,tree.right);
        StdOut.printf("(");
        //printTreeInfix(tree.left);
        StdOut.printf(")");

        switch (tree.type) {
        case NT_ADD: StdOut.printf("+"); break;
        case NT_SUB: StdOut.printf("-"); break;
        case NT_MUL: StdOut.printf("*"); break;
        case NT_DIV: StdOut.printf("/"); break;
        default:
            throw new RuntimeException("Error in parse tree!");
        }

        StdOut.printf("(");
        printTreeInfix(tree.right);
        StdOut.printf(")");
    }
}