//import necessary classes
import java.util.*

public class DepInfo  {
  //declare properties
  private String icaoIdent; //destination airport
  private String callsign; //name that ATC uses to communicate with the aircraft
  private String depAssign; //assigned SID
  private String rwyAssign //assigned runway
  private String rwyAct1; //first active runway
  private String rwyAct2; //second active runway
  private String rwyAct3; //third active runway (not used for dep)
  private boolean isJet; //is the plane a jet or a prop
  private int xpdr; //transponder codde
  
  /**
   * Constructor.
  */
  public DepInfo(String arrIcao, String cs, boolean type)  {
    //set the properties to be the arguments received
    icaoIdent = arrIcao;
    callsign = cs;
    isJet = type;
  }
  
  
  /**
   * Get Active Runway Method.
  */
  public void getAct()  {
    //create the scanner object
    Scanner scanner = new Scanner(System.in);
    
    //east-west ops or north-south ops?
    System.out.print("East-West ops type 0. North-South ops type 1: ");
    
    int estWstNrthSth = 0; //this decides the set of runways in use
    int estWst = 0; //this decides the direction of runways in use
    int nrthSth = 0; //this decides the direction of runways in use
    int rwyActive = "";
    
    //catching the error in case of an invalid input
    try {
      ops = scanner.nextInt();
      
      //getting the specific runway configs now
      switch (ops)  {
        case 0: //east-west ops chosen
          System.out.print("East (0) or West (1) ops?: ");
          estWst = scanner.nextInt();
          
          if (estWst == 0)  {
            //active runways are 05/06L
            rwyAct1 = "05";
            rwyAct2 = "06L"
          } else  {
            //active runways are 23/24R
            rwyAct1 = "23";
            rwyAct2 = "24R";
          }
          break;
          
        default:
          System.out.print("North (0) or South (1) ops?: ");
          nrthSth = scanner.nextInt();
          
          if (nrthSth == 0) {
            //active runways are 33R/33L
            rwyAct1 = "33R";
            rwyAct2 = "33L";
          } else  {
            //active runways are 15L/15R
            rwyAct1 = "15L";
            rwyAct2 = "15R";
          }
          break;
      }
    } catch(Exception e) {
      System.out.println("Invalid input, try again.");
    }
  }
}