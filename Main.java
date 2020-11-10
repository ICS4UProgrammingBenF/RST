//import necessary classes
import java.util.*;

/**
 * Class Main
 */
public class Main {
  public static void main(String[] args) {
    //create obkects
    Scanner scanner = new Scanner(System.in);
    
    //declare variables
    String icaoIdent = "";
    String callsign = "";
    boolean isJet = false;
    String xpdr = "";
    boolean valid = false;
    
    do  {
      //get the destination ICAO from the user
      System.out.print("Enter dest ICAO: ");
      icaoIdent = scanner.nextLine();
      
      //convert the user input to upper case
      icaoIdent = icaoIdent.toUpperCase();
      
      valid = checkIcao(icaoIdent);
      
    } while (valid == false);
    
    //get the callsign
    System.out.print("Enter the callsign: ");
    callsign = scanner.nextLine();
    
    //is the aircraft a jet?
    do  {
      //get the type
      System.out.print("Is the aircraft a jet? (y/n): ");
      String strIsJet = scanner.nextLine();
      
      //convert strIsJet to lower case
      strIsJet = strIsJet.toLowerCase();
      
      //checking for valid input
      if (strIsJet.equals("y")) {
        isJet = true;
        valid = true;
      } else if (strIsJet.equals("n"))  {
        isJet = false;
        valid = true;
      } else  {
        System.out.print("Invalid input. Try again");
        valid = false;
      }
    } while (valid == false);
    
    //get the transponder code
    System.out.print("Enter the assigned transponder code: ");
    xpdr = scanner.nextLine();
    
    //create the Dep Info object
    DepInfo depInfo = new DepInfo(icaoIdent, callsign, isJet, xpdr);
    
    //create the arrival airport objects
    ArrAprt CYOW = new ArrAprt("33R", "06L", "15L", "24R", "VERDO6_ELSUB", "BOMET7_MIVOK");
    ArrAprt CYUL = new ArrAprt("33R", "06L", "15L", "24R", "DEDKI4_MIGLO", "BOMET7_MIGLO");
    ArrAprt KLGA = new ArrAprt("33R", "06L", "15L", "24R", "KEPTA2_BMPAH", "TEVAD2_APPAH");
    ArrAprt CYWG = new ArrAprt("33R", "05", "15L", "23", "AVSEP6_MUSIT", "BOMET7_MIVOK");
    ArrAprt CYHZ = new ArrAprt("33R", "06L", "15L", "24R", "DEDKI4_OLABA", "BOMET7_OLABA");
    
    //get and store the active rwy info
    depInfo.getAct();
    
    //getting deperture info ready
    if (icaoIdent.equals("CYOW")) {
      depInfo.getDepItems(CYOW);
    } else if (icaoIdent.equals("CYUL"))  {
      depInfo.getDepItems(CYUL);
    } else if (icaoIdent.equals("KLGA"))  {
      depInfo.getDepItems(KLGA);
    } else if (icaoIdent.equals("CYWG"))  {
      depInfo.getDepItems(CYWG);
    } else if (icaoIdent.equals("CYHZ"))  {
      depInfo.getDepItems(CYHZ);
    }
    
    //finally, get the clearance
    String output = depInfo.printClearance();
    System.out.println(output);
  }
  
  /**
   * Checking that the user dest is valid.
  */
  public static boolean checkIcao (String destIcao)  {
    //declare variables
    boolean valid = false;
      switch (destIcao) {
        case "CYOW":
          valid = true;
          break;
        
        case "CYUL":
          valid = true;
          break;
        
        case "KLGA":
          valid = true;
          break;
        
        case "CYWG":
          valid = true;
          break;
        
        case "CYHZ":
          valid = true;
          break;
        
        default:
          System.out.println("Invalid input. Try agian");
          valid = false;
          break;
      }
    //return valid or invalid
    return valid;
  }
}