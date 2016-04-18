public class AutoCapitalitazion{
		public static void autoCapitalization(){
		String value = StdIn.readAll();
		char[] text = value.toCharArray();
		text[0] = Character.toUpperCase(text[0]);
		for(int i = 0 ; i < text.length ; i++){
			if(text[i] == '.' || text[i] == '!' || text[i] == '?' || text[i] == ':'){
				try{
					text[i+2] = Character.toUpperCase(text[i+2]);
				}
				finally{
					continue;
				}
		}
			}
		String correctText = String.valueOf(text);
		StdOut.println(correctText);
	}
	public static void main(String[] args) {
		autoCapitalization();
	}
}