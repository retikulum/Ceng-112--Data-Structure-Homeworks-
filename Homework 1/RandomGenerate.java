public class RandomGenerate{
	public static void main(String[] args) {
		double[] array = new double[1000];
		for(int i = 0 ; i < array.length;i++){
			array[i] = StdRandom.gaussian(70.0,15.0);
		}
		for(double value : array){
			StdOut.println(value);
		}

	}
}