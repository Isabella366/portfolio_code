import java.util.Scanner;

public class Assignment_pat1 {

	public static void main(String[] args) {
		//Set up Scanner
				Scanner input = new Scanner (System.in);

			
				
				//Set up Arrays
				String[] title = new String[20];
				String[] author = new String[20];
				String[] publisher = new String[20];
				float[] price = new float[20];
				int[] pages = new int[20];
				long[] ISBN = new long[20];

				
				//Set up variables
				int counter = 0;
				int book_total = 0;
				float cost_total = 0;
				float max_cost = 0;
				float min_cost= max_cost;
				int max_pages = 0;
				int min_pages = max_pages;
				String longest_book= null;
				String shortest_book= null;
				float average_cost = 0;
				String end = "nomore";
				String temp;

				
				// For loop to accept input from the user and store it in relevant array. 
					
				for(counter =0; counter < 20; counter ++) {
					System.out.println("Please enter the title of the book or type nomore to stop entering information: ");
					title[counter] = input.nextLine();
						if(title[counter].equals(end)) {
							break;
						}
					
					System.out.println("Please enter the author of the book: ");
					author[counter] = input.nextLine();
					
					System.out.println("Please enter the publisher of the book: ");
					publisher[counter] = input.nextLine();
					
					System.out.println("Please enter the price of the book to two decimal place and with no currency symbol: ");
					temp = input.nextLine(); // Use temp to deal with the keyboard buffer issues. 
					price[counter] = Float.parseFloat(temp);
					
					System.out.println("Please enter the number of pages: ");
					temp = input.nextLine();
					pages[counter] = Integer.parseInt(temp);
					
					System.out.println("Please enter the ISBN: ");
					temp = input.nextLine();
					ISBN[counter] = Long.parseLong(temp);				
				}
				
				
				//Print out the result headers
				System.out.println(String.format("%-20s", "Title")+
						String.format("%-20s","Author")+
						String.format("%-20s", "Publisher")+
						String.format("%-20s","Price")+
						String.format("%-20s", "Pages")+
						String.format("%-20s", "ISBN"));
						
				
				//Draw a dashed line under the result headers
				System.out.println(String.format("%-20s", "=====")+ 
						String.format("%-20s", "======")+
						String.format("%-20s", "=========")+
						String.format("%-20s", "======")+
						String.format("%-20s", "=====")+
						String.format("%-20s", "====="));
				
				//For loop to print the output from Arrays
				for(counter = 0; counter < 20; counter++) {
					//Stops if the current title is equal to nomore
					if(title[counter].equals(end)) {
					break;
				
				}
					//Prints the output and formats the money. 
					System.out.println(String.format("%-20s", title[counter])+
							String.format("%-20s", author[counter])+
							String.format("%-20s", publisher[counter])+
							String.format("%-20s", String.format("%6.2f",price[counter]))+
							String.format("%-20s", pages[counter])+
							String.format("%-20s", ISBN[counter]));					
				}
				
				
				//Calculates running totals
				
				
				//total number of books
				for(counter=0;counter<20;counter++) {
					if (title[counter] != null){
						book_total++;
					}
					else {
						break;
					}
				}

				
				//total cost of books
				for(counter = 0;counter< 20;counter++) {
					cost_total = cost_total + price[counter];
				}
				
				//Maximum cost of a book
				for(counter = 0; counter<20;counter++) {
					if(price[counter]> max_cost) {
						max_cost = price[counter];
					}					
				}
				
				//Minimum cost of a book
				for(counter=0; counter<20;counter++) {
					if(price[counter]==0.0) { // stops it from overwriting with a 'null' zero
						break;
					}
					else if(price[counter]< max_cost) {
						min_cost=price[counter];
					}
				}
					
				//Longest book
				for(counter=0; counter<20;counter++) {
					if(pages[counter]> max_pages) {
						max_pages =pages[counter];
						longest_book = title[counter];
					}
				}
				
				//Shortest book
				for(counter=0; counter<20;counter++) {
					if(pages[counter]==0.0) {
						break;
				}
					else if(pages[counter]<max_pages) {
						min_pages = pages[counter];
						shortest_book=title[counter];
					}
				}

				//Average cost
				average_cost = cost_total/book_total;
				
				
				// Prints running totals
				System.out.println(""); //Blank line to give it a bit of space.
				System.out.println("Totals");
				System.out.println("--------------------------");
				System.out.println("Total number of books: "+ book_total);
				System.out.println("Total cost of books: £" + String.format("%6.2f",cost_total));
				System.out.println("Maximum cost of a book: £"+ String.format("%6.2f", max_cost));
				System.out.println("Minimum cost of a book: £"+ String.format("%6.2f",min_cost));
				System.out.println("'"+longest_book + "' has the highest number of pages: "+ max_pages);
				System.out.println("'"+shortest_book+ "' has the lowest number of pages: "+ min_pages);
				System.out.println("Average cost of a book: £" + String.format("%6.2f", average_cost));
				
				input.close();

								
				}
				
				
	}



 


