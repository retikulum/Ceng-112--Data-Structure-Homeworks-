public class RPNCalcB {
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
        /*if (tree.type == NT_NUMBER)
                return tree.value;

        int leftValue = evalTree(tree.left);
        int rightValue = evalTree(tree.right);*/
        Node hold  = tree;
        while(hold.left != null){
            hold = hold.left;
        }
        int leftValue = hold.value;
        Node hold1 = tree;
        while(hold1.right != null){
            hold1 = hold1.right;
        }
        int rightValue = hold.value;

        switch (tree.type) {
        case NT_ADD: return leftValue + rightValue;
        case NT_SUB: return leftValue - rightValue;
        case NT_MUL: return leftValue * rightValue;
        case NT_DIV: return leftValue / rightValue;
        default:
            throw new RuntimeException("Error in parse tree!");
        }
    }

    public static void printTreeInfix(Node tree) {
        if (tree.type == NT_NUMBER) {
                StdOut.printf("%d", tree.value);
                return;
        }
        Node hold = tree;
        while(hold.type != NT_NUMBER){
            hold = hold.left;
        }
        StdOut.printf("(");
        StdOut.printf("%d",hold.value);
        StdOut.printf(")");

        switch (tree.type) {
        case NT_ADD: StdOut.printf("+"); break;
        case NT_SUB: StdOut.printf("-"); break;
        case NT_MUL: StdOut.printf("*"); break;
        case NT_DIV: StdOut.printf("/"); break;
        default:
            throw new RuntimeException("Error in parse tree!");
        }
        Node hold1 = tree;
        while(hold1.type != NT_NUMBER){
            hold1 = hold1.right;
        }
        StdOut.printf("(");
        StdOut.printf("%d",hold1.value);
        StdOut.printf(")");
    }
}
