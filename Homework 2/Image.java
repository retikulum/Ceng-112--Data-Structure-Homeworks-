public class Image{
	//Define our variables.
	private byte[] data;
	private int wide;
	private int high;
	//Create constuctor
	public Image(int width , int height){
		data = new byte[width * height];
		wide = width;
		high = height;
		for(int i = 0 ; i < data.length;i++){
			data[i] = 0;
		}
	}
	//Create set pixel method and decleare index of array with given byte.
	public void setPixel(int x, int y, byte intensity){
		data[y * wide + x] = intensity;
	}
	//Write my array in text
	//Also write .pgm format specialties
	//P2 - width and height 
	
	public void savePGM(String filename){
		Out temp = new Out(filename);
		temp.print("P2\n # deneme.pgm\n"+ wide + " " + high+"\n"+ "255\n");
		for(int i = 0 ; i < data.length;i++){
			if(i % wide == 0 && i != 0 )
				temp.print("\n");
			int z = 255;

			temp.print(((byte)data[i])&255);
			temp.print(" ");
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

		while(!temp.isEmpty()){
			int number = temp.readInt();
			data[index] = (byte) number;
			index += 1;
		}
	}


} 