public class ImageTesterR{
	public static void main(String[] args) {
		//Take command lines arguments
		int w = Integer.parseInt(args[0]);
		int h = Integer.parseInt(args[1]);
		int size = Integer.parseInt(args[2]);
		//Create new image with the number of command line arguments(width - height)
		ImageR checkerboard = new ImageR(w,h);
		//This is where we create checkerboard
		//I create it with help of modulo.
		for(int y = 0 ; y < h ; y ++){
			for(int x = 0; x < w ; x ++){
				if(y % (size*2) < size){
					if(x % (size*2) >= size)
						checkerboard.setPixel(x,y,(byte)255);
				}
				else{
					if(x % (size*2) < size){
						checkerboard.setPixel(x,y,(byte)255);
					}
				}

			}
		}
		//Save the image
		checkerboard.savePGM("checkerboard.pgm");

		}

	}
