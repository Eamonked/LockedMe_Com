package project_1;

import java.io.File;
import java.util.Scanner;

import project_1.Virtual_Key.FileAdditionException;

public class mainwindow {
	
	public static void main(String[] args) throws FileAdditionException {
		System.out.println("Welcome to the Company Lockers Pvt LTD Management");
		Virtual_Key virtualkey = new Virtual_Key();
		
	 	System.out.print("Enter the directory path to create: ");
		 Scanner input = new Scanner(System.in);		
	     String dirPath = input.nextLine();
	        
	      File dir = new File(dirPath);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        
	   
	    // Add options to select.    
		
		
	
		int choice = 0;
		while(choice !=4) {
		

		//Scanner scanner = new Scanner(System.in);

		        System.out.println("Choose an option:");
		        System.out.println("1. Creating Files");
		        System.out.println("2. Delete a file");
		        System.out.println("3. Show all files");
		        System.out.println("4. Exit");

		        choice = input.nextInt();

		        switch (choice) {
		            case 1:
		                System.out.println("You chose To create files.");
		                virtualkey.creatingfiles(dirPath);
		                break;
		            case 2:
		                System.out.println("You chose To delete files.");
		                virtualkey.deleteafile(dirPath);
		                break;
		            case 3:
		                System.out.println("You chose Show all files.");
		                virtualkey.showFiles(dirPath);
		                
		                break;
		            
		            case 4:
		            	System.exit(choice);
		            default:
		                System.out.println("Invalid choice.");
		        }

		       }
		 input.close();

	}

}