import java.io.*;
import java.util.*;

public class Test{
  private final static String FILE = "library.csv";
  private final static String DELIM = "----------------\n";
  private static Scanner c = new Scanner(System.in);

  public static void main(String[] args) throws IOException{
    Scanner fr = new Scanner(new File(FILE));

    //build arraylist to store information from text file
    String line = "";
    ArrayList<Book> li = new ArrayList<Book>();
    while(fr.hasNext()){
      line=fr.nextLine();
      String[] temp = line.split(",");
      Book b = new Book(temp[0],temp[1],temp[2]);
      li.add(b);
    }
    fr.close();
    //say hello and start
    System.out.println(DELIM);
    System.out.println("Welcome to your library\n");
    choice(li);
  }//end main

  public static void choice(ArrayList<Book> li){
    int choice = 0;

    System.out.println(DELIM);
    System.out.println("Options:");
    System.out.println("1.  View your books");
    System.out.println("2.  Search library");
    System.out.println("3.  Add a book to the library");
    System.out.println("4.  Delete a book from the library");
    System.out.println("5.  Quit");
    System.out.println("Your choice: ");
    try {
      choice=Integer.parseInt(c.next());
    }
    catch (NumberFormatException e){
      System.out.println("Invalid option, please make another selection.");
      choice(li);
    }

    switch(choice){
      case 1:
        viewBooks(li);
        break;
      case 2:
        searchBooks(li);
        break;
      case 3:
        addBook(li);
        break;
      case 4:
        deleteBook(li);
        break;
      case 5:
        try{
          quitTest(li);
        }
        catch (IOException e){
          System.out.println("Cannot save to file. Returning to main options...\n");
          choice(li);
        }
        break;
      default:
        System.out.println("Option not found. Returning to main options...\n");
        choice(li);
        break;
    }//end switch
  }//end choice

  public static void viewBooks(ArrayList<Book> li){
    System.out.println("\n"+DELIM);
    System.out.println("You have these items in your library:");
    Collections.sort(li);
    for(Book b:li){
      System.out.println("\t"+b.toString());
    }
    System.out.println(DELIM);
    System.out.println("Returning to main options...\n");
    choice(li);
  }//end viewBooks

  public static void searchBooks(ArrayList<Book> li){
    int option = 0;
    String ln = "";
    System.out.println(DELIM);
    System.out.println("Search by: ");
    System.out.println("1. Title");
    System.out.println("2. Author's first name");
    System.out.println("3. Author's last name");
    System.out.println("Your choice: ");
    try {
      option = Integer.parseInt(c.next());
    }
    catch (NumberFormatException ex){
      System.out.println("Invalid option.");
      searchBooks(li);
    }
    c.nextLine();//clear console buffer to read next strings including spaces!
    switch(option){
      case 1://search by title
        System.out.println("Enter the title of the book: ");
        ln = c.nextLine();
        System.out.println(DELIM);
        System.out.println("Your search results:");
        for(int i=0;i<li.size();i++){
          if(li.get(i).getTitle().equals(ln)){
            System.out.println("\t"+li.get(i).toString());
          }
        }
        break;
      case 2://search by authorFName
        System.out.println("Enter first name of author to search by: ");
        ln = c.next();
        System.out.println(DELIM);
        System.out.println("Your search results:");
        for(int i=0;i<li.size();i++){
          if(li.get(i).getFirstName().equals(ln))
            System.out.println("\t"+li.get(i).toString());
        }
        break;
      case 3://search by authorLName
        System.out.println("Enter last name of author to search by: ");
        ln = c.next();
        System.out.println(DELIM);
        System.out.println("Your search results:");
        for(int i=0;i<li.size();i++){
          if(li.get(i).getLastName().equals(ln))
            System.out.println("\t"+li.get(i).toString());
        }
        break;
      default:
        System.out.println("Option not found. Returning to main options...\n");
    }
    System.out.println(DELIM);
    System.out.println("Returning to main options...\n");
    choice(li);
  }//end searchBooks

  public static void addBook(ArrayList<Book> li){
    Book b = new Book();
    c.nextLine();//again start with fresh console buffer
    System.out.println("Enter title of new book: ");
    b.setTitle(c.nextLine());
    System.out.println("Enter author's first name: ");
    b.setFirstName(c.next());
    System.out.println("Enter author's last name: ");
    b.setLastName(c.next());
    System.out.println("You are adding the following record:");
    System.out.println("\t"+b.toString());
    li.add(b);
    System.out.println(DELIM);
    System.out.println("Returning to main options...\n");
    choice(li);
  }//end addBook

  public static void deleteBook(ArrayList<Book> li){
    String ln = "";
    c.nextLine();//again start with fresh console buffer
    System.out.println("Enter the title of the book you want to remove: ");
    ln = c.nextLine();
    for(int i=0;i<li.size();i++){
      if(li.get(i).getTitle().equals(ln)){
        System.out.println("Do you want to remove: \""+li.get(i).toString()+"\" from your library? (y or n)");
        System.out.print("> ");
        ln = c.next();
        ln.toLowerCase();
        if(ln.equals("y")){
          System.out.println("Removing "+li.get(i).getTitle());
          li.remove(i);
          System.out.println(DELIM);
          System.out.println("Returning to main options...\n");
          choice(li);
        }
        else {
          System.out.println("Deletion canceled, returning to main options.");
          choice(li);
        }
      }
    }
    System.out.println("Returning to main options...\n");
    choice(li);
  }//end deleteBook

  public static void quitTest(ArrayList<Book> li) throws IOException{
    Runtime rs =  Runtime.getRuntime();
    BufferedWriter fw = new BufferedWriter(new FileWriter(FILE,false));
    String record = "";
    for(Book b:li){
        record = b.getTitle()+","+b.getFirstName()+","+b.getLastName();
        fw.write(record);
        fw.newLine();
    }
    fw.close();
    c.close();
    rs.gc();
    System.exit(0);
  }

}//end class
