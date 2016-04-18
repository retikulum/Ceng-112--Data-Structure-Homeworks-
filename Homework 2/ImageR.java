public class ImageR{
	//Create 2d array
	private byte[][] data;
	private int wide;
	private int high;
	//Create the image but we 
	public ImageR(int width , int height){
		data = new byte[height][width];
		wide = width;
		high = height;
		for(int y = 0 ; y < high ; y++){
			for(int x = 0 ; x < wide;x++ ){
				data[y][x] = 0;
			}
		}
	}
	//Set pixels for formula
	public void setPixel(int x, int y,byte intensity){
		data[y][x] = intensity;
	}
	//Write my array in text
	//Also write .pgm format specialties
	//P2 - width and height 
	
	public void savePGM(String filename){
		Out temp = new Out(filename);
		temp.print("P2\n # deneme.pgm\n"+ wide + " " + high+"\n"+ "255\n");
		for(int y = 0; y < high ; y++){
			for(int x = 0 ; x < wide ; x++){
				temp.print(((byte)data[y][x]) & 255);
				temp.print(" ");
			}

		}
		temp.close();
		}
	//This function takes array on text
	//Take first 4 parametres as string
	//And take each value
	public void loadPGM(String filename){
		In temp = new In(filename);
		int index = 0;
		String first = temp.readLine();
		String second = temp.readLine();
		String third = temp.readLine();
		String fourth = temp.readLine();
		for(int y = 0; y < high ; y++){
			for(int x = 0 ; x < wide ; x++){
				int i = temp.readInt();
				data[y][x] = (byte) i;
			}
		}
	}
	
}