//import necessary classes
import java.util.*;

public class ArrAprt  {
  //properties
  private String prefRwyNrth;
  private String prefRwySth;
  private String prefRwyEst;
  private String prefRwyWst;
  private String propDep;
  private String jetDep;
  
  /**
   * Constructor.
  */
  public ArrAprt(String rwyN, String rwyE, String rwyS, String rwyW, String jet, String prop)  {
    prefRwyNrth = rwyN;
    prefRwyEst = rwyE;
    prefRwySth = rwyS;
    prefRwyWst = rwyW;
    propDep = prop;
    jetDep = jet;
  }
  
  /**
   * Send pref rwy for direction
  */
  public String getRwy(int direction) {
    //declare variables
    String retStr = "";
    
    if (direction == 0) { //north
      retStr = prefRwyNrth;
    } else if (direction == 1)  { //east
      retStr = prefRwyEst;
    } else if (direction == 2)  { //south
      retStr = prefRwySth;
    } else  { //west
      retStr = prefRwyWst;
    }
    //return the preferred runway
    return retStr;
  }
  
  /**
   * Send SID req for type.
  */
  public String getSid(boolean isJet) {
    //declare variables
    String retStr = "";
    
    //if its a jet, return jetDep
    if (isJet == true)  {
      retStr = jetDep;
    } else  {
      retStr = propDep;
    }
    //return the SID
    return retStr;
  }
}