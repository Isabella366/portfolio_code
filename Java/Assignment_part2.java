import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
public class Assignment_part2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		
		String Line;
		String filename;
		String[] Title = new String[20];
		String[] Author = new String[20];
		String[] Publisher = new String[20];
		float[] Price = new float[20];
		int[] Pages = new int[20];
		long[] ISBN = new long[20];
		int counter =0;
		int step =0;
		int invalid_step=0;
		String[] invalid_delimter = new String[20];

		String[] invalid_title = new String[20];
		String[] invalid_author = new String[20];
		String[] invalid_publisher = new String[20];
		float[] invalid_price = new float[20];
		int[] invalid_pages = new int[20];
		long[] invalid_ISBN = new long[20];
		
		
		String answer;
		String user_author;
		
		System.out.println("Please save the file in folder Example code and then type the file name here including extension:");
		filename = input.nextLine();
		File fileobject = new File ("\\C:\\Users\\isabe\\Documents\\Fundamentals of Computer Programming\\Example code\\"+filename);
		
		try {
			Scanner fileReader = new Scanner(fileobject);//creates scanner to handle file
			while(fileReader.hasNext())
					{
					try {
						
					for(counter=0,step=0;counter<20;counter++) {
						Line = fileReader.nextLine();
						String[] Split_line = Line.split("-");
						try {
						Title[counter]=Split_line[step].trim();
						step++;
						Author[counter]= Split_line[step].trim();
						step++;
						Publisher[counter]=Split_line[step].trim();
						step++;
						try {
						Price[counter]= Float.parseFloat(Split_line[step]);
						step++;
						}
						catch(NumberFormatException exception) {
							Price[counter] = 0;//Set to zero, so it can be tested for later and id'ed as a type error.
							
						}
						try {
						Pages[counter]= Integer.parseInt(Split_line[step].trim());
						step++;
						}
						catch(NumberFormatException exception) {
							Pages[counter] = 0;
						}
						
						try {
						ISBN[counter]= Long.parseLong(Split_line[step].trim());
						step=0;
						}
						catch(NumberFormatException exception) {
							ISBN[counter] = 0;
							step=0;
						}
						}
						catch(ArrayIndexOutOfBoundsException exception) {
							invalid_delimter[counter] = Line;
							step=0;
						}
						
						
						
					}
					}
					catch(NoSuchElementException exception) {
						
					}
					
					for(counter=0;counter<20;counter++) {
						
						if(Title[counter]== null) {
							break;
						}
						else if (Title[counter].equals("")) {
							invalid_title[counter]=Title[counter];
							
							invalid_author[counter] = Author[counter];
							
							invalid_publisher[counter] = Publisher[counter];
							
							invalid_price[counter] = Price[counter];
							
							invalid_pages[counter] = Pages[counter];
							
							invalid_ISBN[counter] = ISBN[counter];
						
						}
						else if(Author[counter].equals("")) {
							invalid_title[counter]=Title[counter];
							
							invalid_author[counter] = Author[counter];
							
							invalid_publisher[counter] = Publisher[counter];
							
							invalid_price[counter] = Price[counter];
							
							invalid_pages[counter] = Pages[counter];
							
							invalid_ISBN[counter] = ISBN[counter];
							
						}
						else if(Publisher[counter].equals("")) {
							invalid_title[counter]=Title[counter];
							
							invalid_author[counter] = Author[counter];
							
							invalid_publisher[counter] = Publisher[counter];
							
							invalid_price[counter] = Price[counter];
							
							invalid_pages[counter] = Pages[counter];
							
							invalid_ISBN[counter] = ISBN[counter];
						}
						else if(Price[counter]== 0) {
							invalid_title[counter]=Title[counter];
							
							invalid_author[counter] = Author[counter];
							
							invalid_publisher[counter] = Publisher[counter];
							
							invalid_price[counter] = Price[counter];
							
							invalid_pages[counter] = Pages[counter];
							
							invalid_ISBN[counter] = ISBN[counter];
							
						}
						else if(Pages[counter]==0) {
							invalid_title[counter]=Title[counter];
							
							invalid_author[counter] = Author[counter];
							
							invalid_publisher[counter] = Publisher[counter];
							
							invalid_price[counter] = Price[counter];
							
							invalid_pages[counter] = Pages[counter];
							
							invalid_ISBN[counter] = ISBN[counter];
						}
						else if(ISBN[counter]==0) {
							invalid_title[counter]=Title[counter];
							
							invalid_author[counter] = Author[counter];
							
							invalid_publisher[counter] = Publisher[counter];
							
							invalid_price[counter] = Price[counter];
							
							invalid_pages[counter] = Pages[counter];
							
							invalid_ISBN[counter] = ISBN[counter];
						}
						else {
							System.out.println(String.format("%-15s", "Title: ") + String.format("%-15s", Title[counter]));
							System.out.println("");
							System.out.println(String.format("%-15s", "Author: ")+ String.format("%-15s", Author[counter]));
							System.out.println("");
							System.out.println(String.format("%-15s", "Publisher: ")+ String.format("%-15s", Publisher[counter]));
							System.out.println("");
							System.out.println(String.format("%-15s", "Price: ")+  String.format("%-15s","£"+ String.format("%6.2f",Price[counter])));
							System.out.println("");
							System.out.println(String.format("%-15s", "Pages: ")+ String.format("%-15s", Pages[counter]));
							System.out.println("");
							System.out.println(String.format("%-15s", "ISBN: ")+ String.format("%-15s", ISBN[counter]));
							System.out.println("---------------------------");
							
						}
						
					}
					System.out.println(" ");
					System.out.println("The following lines have errors:");
					
					for(counter=0, step=0;counter<20;counter++) {
						
						try {
						
						if(invalid_title[counter].equals("")) {
							System.out.println("");
							System.out.print(invalid_title[counter] + " " + invalid_author[counter] + " " + invalid_publisher[counter] + " " + invalid_price[counter] + " " + invalid_pages[counter] +" " + invalid_ISBN[counter] + " ");
							System.out.print(" Missing Title!");
							step++;
						}
						else if(invalid_author[counter].equals("")) {
							System.out.println("");
							System.out.print(invalid_title[counter] + " " + invalid_author[counter] + " " + invalid_publisher[counter] + " " + invalid_price[counter] + " " + invalid_pages[counter] +" " + invalid_ISBN[counter] + " ");
							System.out.print(" Missing Author!");
							step++;
						}
						else if(invalid_publisher[counter].equals("")) {
							System.out.println("");
							System.out.print(invalid_title[counter] + " " + invalid_author[counter] + " " + invalid_publisher[counter] + " " + invalid_price[counter] + " " + invalid_pages[counter] +" " + invalid_ISBN[counter] + " ");
							System.out.print(" Missing Publisher!");
							step++;
						}
						else if(invalid_price[counter]==0) {
							System.out.println("");
							System.out.print(invalid_title[counter] + " " + invalid_author[counter] + " " + invalid_publisher[counter] + " " + invalid_price[counter] + " " + invalid_pages[counter] +" " + invalid_ISBN[counter] + " ");
							System.out.print(" Original Price is not a numeric value!");
							step++;
						}
						else if(invalid_pages[counter]==0) {
							System.out.println("");
							System.out.print(invalid_title[counter] + " " + invalid_author[counter] + " " + invalid_publisher[counter] + " " + invalid_price[counter] + " " + invalid_pages[counter] +" " + invalid_ISBN[counter] + " ");
							System.out.print(" Original Pages is not a numeric value!");
							step++;
						}
						else if(invalid_ISBN[counter]==0) {
							System.out.println("");
							System.out.print(invalid_title[counter] + " " + invalid_author[counter] + " " + invalid_publisher[counter] + " " + invalid_price[counter] + " " + invalid_pages[counter] +" " + invalid_ISBN[counter] + " ");
							System.out.print(" Original ISBN is not a numeric value! It may be missing or contain non-numeric values. ");
							step++;
						}
						}
						catch(NullPointerException exception) {
							
						}
						
						
						
					}
					
					
					for(counter=0, invalid_step=0;counter<20;counter++) {
						try {
							if(invalid_delimter[counter] != null) {
							System.out.println("");
							System.out.print(invalid_delimter[counter]+ " Invalid or missing delimiter!");
							invalid_step++;
							}
						}
						
						catch(NullPointerException exception) {
							
						}
					}
					System.out.println("");
					System.out.println("");
					System.out.println("There are " + (step + invalid_step) + " invalid entrys, please correct the errors given.");
					
					
					// Author Search 
					System.out.println("");
					System.out.println("");
					System.out.println("Would you like to search for an author? y/n");
					answer=input.nextLine();
					if (answer.equals("y")|| answer.equals("Y")) {
						System.out.println("Please enter the author you would like to search for:");
						user_author = input.nextLine();
						user_author = user_author.toLowerCase();
						System.out.println("The following entrys where found for author " + user_author);
						System.out.println("");
						for(counter=0;counter<20;counter++) {
							try {
							if (Author[counter].toLowerCase().contains(user_author)) {
								System.out.println(Title[counter]+ " " + Author[counter]+ " " + Publisher[counter]+ " " + Price[counter]+ " " + Pages[counter]+ " "+ ISBN[counter]);
							}
							}
							catch(NullPointerException exception) {
								
							}
						}
					}
					else {
						break;
					}
						
					
					}
			fileReader.close();
			input.close();
		}
		
		catch(FileNotFoundException e)
		{
		System.out.println("File does not exist");
	}

	}
}
