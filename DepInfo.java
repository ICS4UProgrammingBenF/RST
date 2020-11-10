//import necessary classes
import java.util.*;

public class DepInfo  {
  //declare properties
  private static String icaoIdent; //destination airport
  private static String callsign; //name that ATC uses to communicate with the aircraft
  private static String depAssign; //assigned SID
  private static String rwyAssign; //assigned runway
  private static String rwyAct1; //first active runway
  private static String rwyAct2; //second active runway
  private static int rwyDir; //direction of active runway(s)
  private static boolean isJet; //is the plane a jet or a prop
  private static String xpdr; //transponder codde
  
  /**
   * Constructor.
  */
  public DepInfo(String arrIcao, String cs, boolean type, String squawk)  {
    //set the properties to be the arguments received
    icaoIdent = arrIcao;
    callsign = cs;
    isJet = type;
    xpdr = squawk;
  }
  
  
  /**
   * Get Active Runway Method.
  */
  public void getAct()  {
    //create the scanner object
    Scanner scanner = new Scanner(System.in);
    
    //east-west ops or north-south ops?
    System.out.print("East-West ops (0). North-South ops (1): ");
    
    int estWstNrthSth = 0; //this decides the set of runways in use
    int estWst = 0; //this decides the direction of runways in use
    int nrthSth = 0; //this decides the direction of runways in use
    
    //catching the error in case of an invalid input
    try {
      estWstNrthSth = scanner.nextInt();
      
      //getting the specific runway configs now
      switch (estWstNrthSth)  {
        case 0: //east-west ops chosen
          System.out.print("East (0) or West (1) ops?: ");
          estWst = scanner.nextInt();
          
          if (estWst == 0)  {
            //active runways are 05/06L
            rwyAct1 = "05";
            rwyAct2 = "06L";
            rwyDir = 1;
          } else  {
            //active runways are 23/24R
            rwyAct1 = "23";
            rwyAct2 = "24R";
            rwyDir = 3;
          }
          break;
          
        default:
          System.out.print("North (0) or South (1) ops?: ");
          nrthSth = scanner.nextInt();
          
          if (nrthSth == 0) {
            //active runways are 33R/33L
            rwyAct1 = "33R";
            rwyAct2 = "33L";
            rwyDir = 0;
          } else  {
            //active runways are 15L/15R
            rwyAct1 = "15L";
            rwyAct2 = "15R";
            rwyDir = 2;
          }
          break;
      }
    } catch(Exception e) {
      System.out.println("Invalid input, try again.");
    }
  }
  
  public void getDepItems(ArrAprt arrAprt) {
    //depending on the airport, get the data for it
    rwyAssign = arrAprt.getRwy(rwyDir);
    depAssign = arrAprt.getSid(isJet);
  }
  
  /**
   * Print clearance method.
  */
  public String printClearance() {
    //declare variables/constants
    String output = "";
    final String out1 = " Cleared to the ";
    final String out2 = " Airport via the ";
    final String out3 = " departure, flight planned route. Depart runway ";
    final String out4 = ", Squawk ";
    
    //actually assign text to the output string
    output = callsign + out1 + icaoIdent + out2 + depAssign + out3 + rwyAssign + out4 + xpdr;
    
    //return the clearance
    return output;
  }
}