package ie.gmit.dip;

import java.util.Scanner;

public class Menu {
	
	
	
	




	private String menuText = null; //An instance variable
	private Scanner s = new Scanner(System.in);//scanner to get user input
	public RailFence rf = new RailFence();//calling railfence methods
	private boolean keepRunning = true;// keep menu running if true
	
	
	
	public Menu() throws Exception {
		super();
		this.buildMenu();// calls build menu method
	
		System.out.println(menuText);// show menu text
		this.getUserOption();// calls the user option method
	}
		private void getUserOption() throws Exception{
			while (keepRunning){// when the menu is running
				int option = s.nextInt();
				
				if (option == 1) {
					rf.getText();// calls the method to get text from user
				} else if (option == 2){
					rf.getFile();// calls the method to get file from user
				} else if (option == 3){
					rf.getImage();//calls method to get imagee from user
				} else if (option == 4){
					System.out.println("Bye!");
					keepRunning = false;// stops menu runnning
				} else {
					System.out.println("Enter a value [1-3]>");
				}
			}
			
		}
		
		
		
		
		
		private void buildMenu(){// builds the menu
			StringBuffer sb = new StringBuffer(); 
			sb.append("-------------------------------\n");
			sb.append("\tWelcome to the\n \tRail Fence Cipher\n");
			sb.append("-------------------------------\n");
			
			sb.append("1. Encrypt by text\n");
			sb.append("2. Encrypt by file\n");
			sb.append("3. Encrypt by image\n");
			sb.append("4. Exit\n\n");
			sb.append("Enter Option [1-3]>");
			menuText = sb.toString();
		}
		
	}


