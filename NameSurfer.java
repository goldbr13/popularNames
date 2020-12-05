import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Michael Fecht + Rebecca Goldberg
 * CSC 220-02
 * Project 4
 * 
 * This is the driver class for the NameRecord object. The main method
 * reads the data from the file with a scanner and populates an ArrayList
 * with each NameRecord object. This method prints a menu and asks for
 * user input in order to navigate the menu. The user is able to find the best year for a name,
 * find best rank for a name, or plot the popularity of a name. Additional options
 * include the ability to clear the plot and quit the program when finished.
 */
public class NameSurfer {
    // creates an ArrayList named list that holds NameRecord objects
    public static ArrayList<NameRecord> list = new ArrayList<NameRecord>();
    
    public static void main (String[] args) throws FileNotFoundException {
      // creates a file variable containing the name data
      File file = new File("name_data.txt");
      Scanner scnr = new Scanner(file);
      // populates the NameRecord objects into the ArrayList
      for(int i = 0; i < 4429; i++)
        list.add(new NameRecord(scnr.nextLine()));        
      // prints out the menu options
      System.out.println("1 – Find best year for a name\n2 – Find best rank for a name");
      System.out.println("3 – Plot popularity of a name\n4 – Clear plot\n5 – Quit \nEnter your selection.");
        
      boolean loop = true;
      while(loop) {
        // scanner for the user input
        Scanner user = new Scanner(System.in);
        int num = user.nextInt();
        // If the user selects the first option
        if(num == 1) {
          // prompts the user for a name
          System.out.println("Please enter a name:");
          user = new Scanner(System.in);
          String inputName = user.next();
          int foundIndex = -1;
          // traverses the ArrayList until a match is found
          for(int i = 0; i < list.size(); i++) {
            if(inputName.equalsIgnoreCase((list.get(i).getName()))) {
              foundIndex = i;
            break;
            }
          }
          // if there is no match, the system prints that the name is not valid
          // otherwise prints out the best year of the input name
          if(foundIndex == -1)
            System.out.println(inputName + " is not valid");
          else
            System.out.println(list.get(foundIndex).bestYear());
          // prints out the menu options again
          System.out.println("1 – Find best year for a name\n2 – Find best rank for a name");
          System.out.println("3 – Plot popularity of a name\n4 – Clear plot\n5 – Quit \nEnter your selection.");
        }
        // If the user selects the second option
        else if(num == 2) {
          // prompts the user for a name input
          System.out.println("Please enter a name:");
          user = new Scanner(System.in);
          String inputName = user.next();
          // traverses the ArrayList until a match is found
          int foundIndex = -1;
          for(int i = 0; i < list.size(); i++) {
            if(inputName.equalsIgnoreCase(list.get(i).getName())) {
            foundIndex = i;
            break;
            }
          }
          // if there is no match, the system prints that the name is not valid
          // otherwise prints out the best rank for that name
          if(foundIndex == -1)
            System.out.println(inputName + " is not valid");
          else
          {
            // computes the decade number of the bestYear 
            int decade = list.get(foundIndex).bestYear() - 1900;
            // uses the decade number as the parameter to get and print the rank
            System.out.println(list.get(foundIndex).getRank(decade/10));
          }
          // reprints the menu options
          System.out.println("1 – Find best year for a name\n2 – Find best rank for a name");
          System.out.println("3 – Plot popularity of a name\n4 – Clear plot\n5 – Quit \nEnter your selection.");
        }
        // If the user chooses option 3
        else if(num == 3) {
          // prompts the user for a name
          System.out.println("Please enter a name:");
          user = new Scanner(System.in);
          String inputName = user.next();
          // traverses the ArrayList until a match is found
          int foundIndex = -1;
          for(int i = 0; i < list.size(); i++) {
            if(inputName.equalsIgnoreCase(list.get(i).getName())) {
            foundIndex = i;
            break;
            }
          }
          // if there is no match, the system prints that the name is not valid
          // otherwise plots the popularity of the name
          if(foundIndex == -1)
            System.out.println(inputName + " is not valid");
          else
          {
            // plots the corresponding NameObject
            list.get(foundIndex).plot();
          }
          // reprints the menu options
          System.out.println("1 – Find best year for a name\n2 – Find best rank for a name");
          System.out.println("3 – Plot popularity of a name\n4 – Clear plot\n5 – Quit \nEnter your selection.");
        }
        // If the user chooses menu option 4
        else if(num == 4) {
          // clears the plot
          StdDraw.clear();
          // reprints the menu options
          System.out.println("1 – Find best year for a name\n2 – Find best rank for a name");
          System.out.println("3 – Plot popularity of a name\n4 – Clear plot\n5 – Quit \nEnter your selection.");
        }
        // If the user chooses menu option 5
        else if(num == 5) {
          // exits the while loop and terminates the program
          System.exit(0);
        }    

      }
      scnr.close();

    }

}
      

    