/**
 * @author Michael Fecht + Rebecca Goldberg
 * CSC 220-02 
 * Project 4
 * 
 * This NameRecord class creates a NameRecord class and includes multiple 
 * methods that can be called on the object. Including getName and getRank methods
 * as well as the bestYear method and a plot method. 
 */
public class NameRecord {
    // initialization of private fields
    private final int START = 1900;
    private static final int DECADES = 11;
    private int[] rankNumbers = new int[DECADES];
    private String name;
    
    /**
     * Constructor class for the NameRecord method
     * Takes a string of data and initializes the data into a
     * NameRecord object
     * @param data
     */
    public NameRecord(String data) {
      // creates an int[]
      rankNumbers = new int[DECADES];
      // uses .indexOf to seperate the name from the numbers
	    name = data.substring(0, data.indexOf(' '));
	    data = data.substring(data.indexOf(' ')+1);
      
      // for loop populates the int[] with the data
	    int rankPos = 0;
	    for (int i = 0; i < data.length(); i++) {
		    rankNumbers[rankPos] = Integer.parseInt(data.substring(0, data.indexOf(' ')));
		    data = data.substring(data.indexOf(' ')+1);;
		    rankPos++;
		    i = 0;
		    if (data.indexOf(' ') == -1) {
		      rankNumbers[rankPos] = Integer.parseInt(data);
		      break;
		    }
		  }
	  }

    /**
     * This method returns the name
     * @return name
     */
	  public String getName() {
		  return name;
    }
    
    /**
     * This method takes a decade as a parameter and returns the rank
     * of the name during that year
     * @param decade
     * @return rank
     */
	  public int getRank(int decade) {
      return rankNumbers[decade];
    }

    /**
     * This method returns the year where the name was most popular
     * @return int bestYear
     */
    public int bestYear() {
      int bestYear = 0;
      int rank = rankNumbers[0];
      // for loop finds the best year out of the decades
      for (int i = 0; i < DECADES; i++) {
        if (rank == 0) {
          rank = rankNumbers[i];
          bestYear = i;
        } 
        else if (rankNumbers[i] != 0 && rankNumbers[i] < rank) {
          bestYear = i;
          rank = rankNumbers[i];
        }
      }
      
      // turns the decade number into its corresponding year number
      if (bestYear == 10) {
          bestYear = 2000;
        } 
      else {
          bestYear = START + bestYear * 10;
        }

      return bestYear;
    }

    /**
     * This method plots the popularity of the name throughout
     * the decades using the StdDraw.java class
     */
    public void plot() {
      setRandomPenColor();
      
      double lastX = 0;
      double lastY = 0;
      // loops through the data points and plots them
		for (int i = 0; i < 11; i++) {
			StdDraw.setPenRadius(.01);
			// evenly spaces out the x coordinates
			double x = i * (1.0 / (double) DECADES);
			// normalizes the data points to be represented between (0,1)
			double y = 0;
			if (this.getRank(i) != 0)
				y = ((this.getRank(i) - 1100) / -1100.0); // normalizes the number between 0 and 1

			StdDraw.point(x, y);

			// Connects the current point with the last point
			if (i != 0) {
			StdDraw.setPenRadius(.005);
			StdDraw.line(lastX, lastY, x, y);
		    }
			lastX = x;
			lastY = y;
		}
      }
     
      
    
    /**
     * This method chooses a random color for each time it 
     * is called. This method is used inside the plot() method
     */
    public void setRandomPenColor() {
      int num = (int) (Math.random()*DECADES);
      switch(num){
        case 0:
          StdDraw.setPenColor(StdDraw.BLACK);
          break;
        case 1:
          StdDraw.setPenColor(StdDraw.BLUE);
          break;
        case 2:
          StdDraw.setPenColor(StdDraw.CYAN);
          break;
        case 3:
          StdDraw.setPenColor(StdDraw.DARK_GRAY);
          break;
        case 4:
          StdDraw.setPenColor(StdDraw.GRAY);
          break;
        case 5:
          StdDraw.setPenColor(StdDraw.GREEN);
          break;
        case 6:
          StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
          break;
        case 7:
          StdDraw.setPenColor(StdDraw.MAGENTA);           
          break;
        case 8:
          StdDraw.setPenColor(StdDraw.ORANGE);
          break;
        case 9:
          StdDraw.setPenColor(StdDraw.PINK);
          break;
        case 10:
          StdDraw.setPenColor(StdDraw.RED);
          break;
        case 11:
          StdDraw.setPenColor(StdDraw.WHITE);
          break;
        case 12:
          StdDraw.setPenColor(StdDraw.YELLOW);
          break; 
        }
        
    }

}