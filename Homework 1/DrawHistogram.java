public class DrawHistogram {
    public static int[] makeHistogram(double [] numbers, int N, double l, double r) {
        int[] h = new int[N];

        double step = (r-l) / N; // size of a histogram bin
        for (int i = 0; i < numbers.length; ++i) {
            int b = (int)Math.floor((numbers[i] - l) / step); // numbers between [l,l+step) --> 0, [l+step, l+2*step) --> 1, ...
            if (b >= 0 && b < N)
                h[b] += 1;
        }

        return h;
    }
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // Number of histogram bins
        double l = Double.parseDouble(args[1]); // Lower limit of histogram range
        double r = Double.parseDouble(args[2]); // Highest limit of histogram range

        double [] numbers = StdIn.readAllDoubles();
        int [] histogram = makeHistogram(numbers, N, l, r);

        // Print out histogram bins for debugging
        for (int i = 0; i < histogram.length; i += 1) {
            StdOut.printf("%d ", histogram[i]);
        }
        StdOut.println();

        int maxBin = StdStats.max(histogram);
        StdDraw.setXscale(0, maxBin);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < histogram.length; i += 1) {
            double y = i+0.5;
            double x = histogram[i]/2.0;
            double rh = 0.48;
            double rw = histogram[i]/2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        
            
        
    }
}
