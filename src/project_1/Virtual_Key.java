package project_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Virtual_Key {
	public String filename;
	public String dirPath;
	public List fileList;

	

	@SuppressWarnings("resource")
	public void creatingfiles(String dirPath)throws FileAdditionException {
		
		System.out.println("Enter file names to store (press enter after each name):");
        List<File> fileList = new ArrayList<>();
        while (true) {
        	Scanner input = new Scanner(System.in);
            String fileName = input.nextLine();
            if (fileName.isEmpty()) {
                break;
            }
            File file = new File(dirPath + "/" + fileName);
            try {
                file.createNewFile();
                fileList.add(file);
            } catch (Exception e) {
            	throw new FileAdditionException("Unable to create file: " +fileName + e.getMessage());
            }
        }
        fileList.sort((f1, f2) -> f1.getName().compareTo(f2.getName()));
        
        System.out.println("list of files newly added:");
        for (File file : fileList) {
            System.out.println(file.getName());
        } 

}
	 public void deleteafile(String dirPath) {
			System.out.println("Enter file names to Delete (press enter after each name):");
			 while (true) {
	        	Scanner input = new Scanner(System.in);
	            String fileName = input.nextLine();
	            if (fileName.isEmpty()) {
	                break;
	            }
	            File file = new File(dirPath + "/" + fileName);
	            if (file.exists()) {
	                // try to delete the file
	                if (file.delete()) {
	                    System.out.println("File deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete the file.");
	                }
	            } else {
	                System.out.println("File does not exist.");
	            }
	        }
			
	 }
	 public void showFiles(String dirPath) {
		 
		 File directory = new File(dirPath);

	        File[] files = directory.listFiles();
	        Arrays.sort(files);
	        if (files != null) {
	            for (File file : files) {
	                if (file.isFile()) {
	                    System.out.println(file.getName());
	                }
	            }
	        }
	        System.out.println("Empty");
	 }
	
	 public class FileAdditionException extends Exception {
		    public FileAdditionException(String message) {
		        super(message);
		    }
		}

}
