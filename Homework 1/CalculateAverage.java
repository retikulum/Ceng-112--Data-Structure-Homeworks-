public class CalculateAverage{
	public static void calculateAverage() {

		double[] grades = StdIn.readAllDoubles();
		double total = 0.0 ; 
		double[] average = new double[(grades.length)/3];
		int indexCounter = 0 ;
		for(int i = 0 ; i < grades.length ; i++){
			if(i % 3 == 0){
				total += 0.2 * grades[i];
			}
			else if(i % 3 == 2){
				total += 0.4 * grades[i];
				average[indexCounter] = total;
				indexCounter++;
				total = 0;
			}
			else
				total += grades[i] * 0.4;
		}
		for(double value : average){
			StdOut.println(value);
		}
	}


	

	public static void main(String[] args) {
		calculateAverage();
	}

}