package ie.gmit.dip;
import java.io.*;
import java.util.Scanner;

public class RailFence {
	
	public String getText() throws Exception {//Method to get text from user
		Scanner s = new Scanner(System.in);//Scanner to get user input
		String plainText;
		int key;
		
		 System.out.println("Please Enter Plaintext");
		 plainText=s.nextLine();
		 plainText=plainText.toUpperCase().trim();//convert plainText to upper case
		 
		 System.out.println("Please Enter Key Length");
		 key=s.nextInt();
		 doEncryption(key, plainText);// send plaintext to encrypt method
		return null;
	}
	
	public String getFile()throws Exception{
		System.out.println("You have picked insert file");
		Scanner s = new Scanner(System.in);
		int key;
		String path;
		System.out.println("Please Enter the path of file");// Gets location of the file
		path=s.nextLine();
		System.out.println("Please Enter Key Length");
		key=s.nextInt();
		
		
		FileReader file = new FileReader(path);//reads in the file in characters
		BufferedReader br = new BufferedReader(file);// read the characters on the file reader
		String plainText = "";
		String text = br.readLine();// makes a string from the buffered reader
		if(text != null){
			plainText+=text;
			text = br.readLine();
			
		}
		br.close();
		System.out.println("The following was read from file:\n\n"+plainText);
		doEncryption(key, plainText);// sends to the encryption method
		
		return plainText;
		
		
		
	}
	
	public String doEncryption(int key,String plainText) throws Exception{
			RailFence rf = new RailFence();
			int y = 0;
			int z = 1;
			char array[][]= new char [key][plainText.length()];// cretes a char array 
				 for (int i = 0; i < array.length; i++) {
					 for (int j = 0; j < array[i].length; j++) {
						
					}	
				}
				 for (int i = 0; i < plainText.length(); i++) {   // Rail fence up and down through array
					
					 if((z % 2)!=0){
							try {// try/catch to catch exceptions
								array[y][i]= plainText.charAt(i);// puts out characters at point in array
							} catch (Exception e) {
								
								e.printStackTrace();
							}
							if( y ==(key - 1)){//makes it go up through array
								z = 2;
								y = (key - 2);
							}else
								y++;
						}else if ((z % 2)== 0){//makes it go down through the array
							
							array[y][i] = plainText.charAt(i);
							if (y == 0){
								z = 1;
								y = 1;
							}else
								y--;
							
						}
					}

		 System.out.println();
			 for (int i = 0; i < array.length; i++) {
				for (int u = 0; u < array[i].length; u++) {
					System.out.print(array[i][u] + " ");// prints out the characters in the array
					
				}
				System.out.println();
			}
		 
		 StringBuffer cipherText = new StringBuffer();// creates ciphertext which characters can be manipulated
		 for(char [] i : array){// creats a char array
			 for (int j = 0; j < i.length; j++) {// loops down through matric row by row
				 if (i[j] !=0){
					 cipherText.append(i[j]);// appeands characters if not =0
				 }
			 }	 
		}
		 cipherText.toString();//creats a string cypertext
			System.out.println("\nEncrypted Text:\n" + cipherText );// prints out ciphertext


				doDecryption(cipherText, key);//send cypertext to decrypt method
				
				return null;
		 }
			
		 
		 
		 

	
	public String doDecryption(StringBuffer cipherText,int key) throws Exception{
		char array[][]= new char [key][cipherText.length()];// create empty matrix
		 for (int row = 0; row < array.length; row++) {
			 for (int col = 0; col < array[row].length; col++) {
				
			 }
		 }
		 
		 int next=0;
		 int c=1;
		 int a=0, b=0;
		 int init =(2*key)-2;
		 a = init -2;
		 b = 2;
		 for (int i = 0; i < array.length; i++) {
	            c = 0;
	            for (int u = i; u < array[i].length;) {//loop over row by row
	                if (next != cipherText.length()) {
	                    if (i == 0 || i == key - 1) {
	                        array[i][u] = cipherText.charAt(next);//puts next character  in matrix
	                        u+=init;
	                    } else {
	                        array[i][u] = cipherText.charAt(next);
	                        if (c % 2 == 0)
	                            u+=a;
	                        else if (c % 2 == 1)
	                            u+=b;
	                        c++;
	                    }
	                    next++;
	                } else
	                    break;

	            }
	            if (i != 0 && i != key - 1) {
	                a = a - 2;
	                b = b + 2;
	            }
	        }

	        System.out.println("\n\nDecrypting..list into table");
		 for (int i = 0; i < array.length; i++) {
			for (int u = 0; u < array[i].length; u++) {
				System.out.print(array[i][u] + " ");//shows decryption matrix
				
			}
			System.out.println();
			
		 }
		
		 StringBuffer decryptedText = new StringBuffer(); 
		 for(int i=0; i<array[0].length; i++){//loops over column by column
		     for(int j=0; j< array.length; j++){
		         if(array[j][i]!=0)
		             decryptedText.append(array[j][i]);// appends characters if not =0
		
		 }
		 }
		 decryptedText.toString();//creates a string from the characters
			System.out.println("\nDecrypted Text:\n" + decryptedText );
			return null;
		}

		
	
	
	public void fileWriter(StringBuffer cipherText ,StringBuffer decryptedText) throws Exception {
		RailFence rf = new RailFence();
		String text;
		File newFile = new File("C:/Users/blazee/Desktop/newFile.txt");//creates a new file and shows location
		if (newFile.exists()){//checks if exists
		System.out.println("\nError: The file already exists");
			
		} else {
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				FileWriter fileW = new FileWriter(newFile);
				BufferedWriter bw = new BufferedWriter(fileW);
				
				
				bw.write("");//writes parameters to file
				bw.flush();
				bw.close();
				System.out.println("\n File written");
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			
		}
		
			
		
	}

	public void getImage() throws IOException {
		System.out.println("You have picked image");
		Scanner s = new Scanner(System.in);
		int key;
		String path;
		System.out.println("Please Enter the path of the image");
		path=s.nextLine();
		System.out.println("Please Enter Key Length");
		key=s.nextInt();
		String fileName = "out.bin";
		try {
			FileOutputStream fileOs = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fileOs);
			os.writeInt(2048);
		} catch (Exception e) {
			
		
		System.out.println("Done Writing.....Now Reading");
		
		FileInputStream fileIs = new FileInputStream(fileName);
		ObjectInputStream is = new ObjectInputStream(fileIs);
		int x = is.readInt();
		System.out.println(x);
}
		return;
}
	
}

