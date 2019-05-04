//%% NEW FILE RegistrerStandServlet BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 34 "model.ump"
// line 110 "model.ump"
public class RegistrerStandServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegistrerStandServlet Associations
  private List<Stand> stands;
  private DbHandler dbHandler;
  private LoginUtil loginUtil;
  private JavaEmail javaEmail;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegistrerStandServlet(DbHandler aDbHandler, LoginUtil aLoginUtil, JavaEmail aJavaEmail)
  {
    stands = new ArrayList<Stand>();
    if (aDbHandler == null || aDbHandler.getRegistrerStandServlet() != null)
    {
      throw new RuntimeException("Unable to create RegistrerStandServlet due to aDbHandler");
    }
    dbHandler = aDbHandler;
    if (aLoginUtil == null || aLoginUtil.getRegistrerStandServlet() != null)
    {
      throw new RuntimeException("Unable to create RegistrerStandServlet due to aLoginUtil");
    }
    loginUtil = aLoginUtil;
    if (aJavaEmail == null || aJavaEmail.getRegistrerStandServlet() != null)
    {
      throw new RuntimeException("Unable to create RegistrerStandServlet due to aJavaEmail");
    }
    javaEmail = aJavaEmail;
  }

  public RegistrerStandServlet(String aUrlForDbHandler, String aUserForDbHandler, String aPasswordForDbHandler, LoginServlet aLoginServletForDbHandler, StandAdminServlet aStandAdminServletForDbHandler, StandServlet aStandServletForDbHandler, ResultServlet aResultServletForDbHandler, AdminServlet aAdminServletForDbHandler, StandAdminServlet aStandAdminServletForLoginUtil, LoginServlet aLoginServletForLoginUtil, AdminServlet aAdminServletForLoginUtil, Session aMailSessionForJavaEmail)
  {
    stands = new ArrayList<Stand>();
    dbHandler = new DbHandler(aUrlForDbHandler, aUserForDbHandler, aPasswordForDbHandler, aLoginServletForDbHandler, aStandAdminServletForDbHandler, this, aStandServletForDbHandler, aResultServletForDbHandler, aAdminServletForDbHandler);
    loginUtil = new LoginUtil(aStandAdminServletForLoginUtil, this, aLoginServletForLoginUtil, aAdminServletForLoginUtil);
    javaEmail = new JavaEmail(aMailSessionForJavaEmail, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetOne */
  public LoginUtil getLoginUtil()
  {
    return loginUtil;
  }
  /* Code from template association_GetOne */
  public JavaEmail getJavaEmail()
  {
    return javaEmail;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, StandOverview aStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, ResultServlet aResultServlet, AdminServlet aAdminServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, aStandAdminServlet, aStandServlet, aStandOverview, aDbHandler, aLoginServlet, aResultServlet, this, aAdminServlet);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    RegistrerStandServlet existingRegistrerStandServlet = aStand.getRegistrerStandServlet();
    boolean isNewRegistrerStandServlet = existingRegistrerStandServlet != null && !this.equals(existingRegistrerStandServlet);
    if (isNewRegistrerStandServlet)
    {
      aStand.setRegistrerStandServlet(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a registrerStandServlet
    if (!this.equals(aStand.getRegistrerStandServlet()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
    DbHandler existingDbHandler = dbHandler;
    dbHandler = null;
    if (existingDbHandler != null)
    {
      existingDbHandler.delete();
    }
    LoginUtil existingLoginUtil = loginUtil;
    loginUtil = null;
    if (existingLoginUtil != null)
    {
      existingLoginUtil.delete();
    }
    JavaEmail existingJavaEmail = javaEmail;
    javaEmail = null;
    if (existingJavaEmail != null)
    {
      existingJavaEmail.delete();
    }
  }

}



//%% NEW FILE StandOverview BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 83 "model.ump"
// line 145 "model.ump"
public class StandOverview
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandOverview Associations
  private DbHandler dbHandler;
  private Stand stand;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StandOverview(DbHandler aDbHandler, Stand aStand)
  {
    boolean didAddDbHandler = setDbHandler(aDbHandler);
    if (!didAddDbHandler)
    {
      throw new RuntimeException("Unable to create standOverview due to dbHandler");
    }
    if (aStand == null || aStand.getStandOverview() != null)
    {
      throw new RuntimeException("Unable to create StandOverview due to aStand");
    }
    stand = aStand;
  }

  public StandOverview(DbHandler aDbHandler, int aIdForStand, String aNameForStand, String aImageUrlForStand, String aEpostadminForStand, String aPinForStand, StandAdminServlet aStandAdminServletForStand, StandServlet aStandServletForStand, DbHandler aDbHandlerForStand, LoginServlet aLoginServletForStand, ResultServlet aResultServletForStand, RegistrerStandServlet aRegistrerStandServletForStand, AdminServlet aAdminServletForStand)
  {
    boolean didAddDbHandler = setDbHandler(aDbHandler);
    if (!didAddDbHandler)
    {
      throw new RuntimeException("Unable to create standOverview due to dbHandler");
    }
    stand = new Stand(aIdForStand, aNameForStand, aImageUrlForStand, aEpostadminForStand, aPinForStand, aStandAdminServletForStand, aStandServletForStand, this, aDbHandlerForStand, aLoginServletForStand, aResultServletForStand, aRegistrerStandServletForStand, aAdminServletForStand);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetOne */
  public Stand getStand()
  {
    return stand;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDbHandler(DbHandler aDbHandler)
  {
    boolean wasSet = false;
    if (aDbHandler == null)
    {
      return wasSet;
    }

    DbHandler existingDbHandler = dbHandler;
    dbHandler = aDbHandler;
    if (existingDbHandler != null && !existingDbHandler.equals(aDbHandler))
    {
      existingDbHandler.removeStandOverview(this);
    }
    dbHandler.addStandOverview(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DbHandler placeholderDbHandler = dbHandler;
    this.dbHandler = null;
    if(placeholderDbHandler != null)
    {
      placeholderDbHandler.removeStandOverview(this);
    }
    Stand existingStand = stand;
    stand = null;
    if (existingStand != null)
    {
      existingStand.delete();
    }
  }

}



//%% NEW FILE Stand BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 51 "model.ump"
// line 125 "model.ump"
public class Stand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stand Attributes
  private int id;
  private String name;
  private String imageUrl;
  private String epostadmin;
  private String pin;

  //Stand Associations
  private StandAdminServlet standAdminServlet;
  private StandServlet standServlet;
  private StandOverview standOverview;
  private DbHandler dbHandler;
  private LoginServlet loginServlet;
  private ResultServlet resultServlet;
  private RegistrerStandServlet registrerStandServlet;
  private AdminServlet adminServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, StandOverview aStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    id = aId;
    name = aName;
    imageUrl = aImageUrl;
    epostadmin = aEpostadmin;
    pin = aPin;
    boolean didAddStandAdminServlet = setStandAdminServlet(aStandAdminServlet);
    if (!didAddStandAdminServlet)
    {
      throw new RuntimeException("Unable to create stand due to standAdminServlet");
    }
    boolean didAddStandServlet = setStandServlet(aStandServlet);
    if (!didAddStandServlet)
    {
      throw new RuntimeException("Unable to create stand due to standServlet");
    }
    if (aStandOverview == null || aStandOverview.getStand() != null)
    {
      throw new RuntimeException("Unable to create Stand due to aStandOverview");
    }
    standOverview = aStandOverview;
    boolean didAddDbHandler = setDbHandler(aDbHandler);
    if (!didAddDbHandler)
    {
      throw new RuntimeException("Unable to create stand due to dbHandler");
    }
    boolean didAddLoginServlet = setLoginServlet(aLoginServlet);
    if (!didAddLoginServlet)
    {
      throw new RuntimeException("Unable to create stand due to loginServlet");
    }
    boolean didAddResultServlet = setResultServlet(aResultServlet);
    if (!didAddResultServlet)
    {
      throw new RuntimeException("Unable to create stand due to resultServlet");
    }
    boolean didAddRegistrerStandServlet = setRegistrerStandServlet(aRegistrerStandServlet);
    if (!didAddRegistrerStandServlet)
    {
      throw new RuntimeException("Unable to create stand due to registrerStandServlet");
    }
    boolean didAddAdminServlet = setAdminServlet(aAdminServlet);
    if (!didAddAdminServlet)
    {
      throw new RuntimeException("Unable to create stand due to adminServlet");
    }
  }

  public Stand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, DbHandler aDbHandlerForStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    id = aId;
    name = aName;
    imageUrl = aImageUrl;
    epostadmin = aEpostadmin;
    pin = aPin;
    boolean didAddStandAdminServlet = setStandAdminServlet(aStandAdminServlet);
    if (!didAddStandAdminServlet)
    {
      throw new RuntimeException("Unable to create stand due to standAdminServlet");
    }
    boolean didAddStandServlet = setStandServlet(aStandServlet);
    if (!didAddStandServlet)
    {
      throw new RuntimeException("Unable to create stand due to standServlet");
    }
    standOverview = new StandOverview(aDbHandlerForStandOverview, this);
    boolean didAddDbHandler = setDbHandler(aDbHandler);
    if (!didAddDbHandler)
    {
      throw new RuntimeException("Unable to create stand due to dbHandler");
    }
    boolean didAddLoginServlet = setLoginServlet(aLoginServlet);
    if (!didAddLoginServlet)
    {
      throw new RuntimeException("Unable to create stand due to loginServlet");
    }
    boolean didAddResultServlet = setResultServlet(aResultServlet);
    if (!didAddResultServlet)
    {
      throw new RuntimeException("Unable to create stand due to resultServlet");
    }
    boolean didAddRegistrerStandServlet = setRegistrerStandServlet(aRegistrerStandServlet);
    if (!didAddRegistrerStandServlet)
    {
      throw new RuntimeException("Unable to create stand due to registrerStandServlet");
    }
    boolean didAddAdminServlet = setAdminServlet(aAdminServlet);
    if (!didAddAdminServlet)
    {
      throw new RuntimeException("Unable to create stand due to adminServlet");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setImageUrl(String aImageUrl)
  {
    boolean wasSet = false;
    imageUrl = aImageUrl;
    wasSet = true;
    return wasSet;
  }

  public boolean setEpostadmin(String aEpostadmin)
  {
    boolean wasSet = false;
    epostadmin = aEpostadmin;
    wasSet = true;
    return wasSet;
  }

  public boolean setPin(String aPin)
  {
    boolean wasSet = false;
    pin = aPin;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public String getImageUrl()
  {
    return imageUrl;
  }

  public String getEpostadmin()
  {
    return epostadmin;
  }

  public String getPin()
  {
    return pin;
  }
  /* Code from template association_GetOne */
  public StandAdminServlet getStandAdminServlet()
  {
    return standAdminServlet;
  }
  /* Code from template association_GetOne */
  public StandServlet getStandServlet()
  {
    return standServlet;
  }
  /* Code from template association_GetOne */
  public StandOverview getStandOverview()
  {
    return standOverview;
  }
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetOne */
  public LoginServlet getLoginServlet()
  {
    return loginServlet;
  }
  /* Code from template association_GetOne */
  public ResultServlet getResultServlet()
  {
    return resultServlet;
  }
  /* Code from template association_GetOne */
  public RegistrerStandServlet getRegistrerStandServlet()
  {
    return registrerStandServlet;
  }
  /* Code from template association_GetOne */
  public AdminServlet getAdminServlet()
  {
    return adminServlet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStandAdminServlet(StandAdminServlet aStandAdminServlet)
  {
    boolean wasSet = false;
    if (aStandAdminServlet == null)
    {
      return wasSet;
    }

    StandAdminServlet existingStandAdminServlet = standAdminServlet;
    standAdminServlet = aStandAdminServlet;
    if (existingStandAdminServlet != null && !existingStandAdminServlet.equals(aStandAdminServlet))
    {
      existingStandAdminServlet.removeStand(this);
    }
    standAdminServlet.addStand(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStandServlet(StandServlet aStandServlet)
  {
    boolean wasSet = false;
    if (aStandServlet == null)
    {
      return wasSet;
    }

    StandServlet existingStandServlet = standServlet;
    standServlet = aStandServlet;
    if (existingStandServlet != null && !existingStandServlet.equals(aStandServlet))
    {
      existingStandServlet.removeStand(this);
    }
    standServlet.addStand(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDbHandler(DbHandler aDbHandler)
  {
    boolean wasSet = false;
    if (aDbHandler == null)
    {
      return wasSet;
    }

    DbHandler existingDbHandler = dbHandler;
    dbHandler = aDbHandler;
    if (existingDbHandler != null && !existingDbHandler.equals(aDbHandler))
    {
      existingDbHandler.removeStand(this);
    }
    dbHandler.addStand(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setLoginServlet(LoginServlet aLoginServlet)
  {
    boolean wasSet = false;
    if (aLoginServlet == null)
    {
      return wasSet;
    }

    LoginServlet existingLoginServlet = loginServlet;
    loginServlet = aLoginServlet;
    if (existingLoginServlet != null && !existingLoginServlet.equals(aLoginServlet))
    {
      existingLoginServlet.removeStand(this);
    }
    loginServlet.addStand(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setResultServlet(ResultServlet aResultServlet)
  {
    boolean wasSet = false;
    if (aResultServlet == null)
    {
      return wasSet;
    }

    ResultServlet existingResultServlet = resultServlet;
    resultServlet = aResultServlet;
    if (existingResultServlet != null && !existingResultServlet.equals(aResultServlet))
    {
      existingResultServlet.removeStand(this);
    }
    resultServlet.addStand(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRegistrerStandServlet(RegistrerStandServlet aRegistrerStandServlet)
  {
    boolean wasSet = false;
    if (aRegistrerStandServlet == null)
    {
      return wasSet;
    }

    RegistrerStandServlet existingRegistrerStandServlet = registrerStandServlet;
    registrerStandServlet = aRegistrerStandServlet;
    if (existingRegistrerStandServlet != null && !existingRegistrerStandServlet.equals(aRegistrerStandServlet))
    {
      existingRegistrerStandServlet.removeStand(this);
    }
    registrerStandServlet.addStand(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setAdminServlet(AdminServlet aAdminServlet)
  {
    boolean wasSet = false;
    if (aAdminServlet == null)
    {
      return wasSet;
    }

    AdminServlet existingAdminServlet = adminServlet;
    adminServlet = aAdminServlet;
    if (existingAdminServlet != null && !existingAdminServlet.equals(aAdminServlet))
    {
      existingAdminServlet.removeStand(this);
    }
    adminServlet.addStand(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    StandAdminServlet placeholderStandAdminServlet = standAdminServlet;
    this.standAdminServlet = null;
    if(placeholderStandAdminServlet != null)
    {
      placeholderStandAdminServlet.removeStand(this);
    }
    StandServlet placeholderStandServlet = standServlet;
    this.standServlet = null;
    if(placeholderStandServlet != null)
    {
      placeholderStandServlet.removeStand(this);
    }
    StandOverview existingStandOverview = standOverview;
    standOverview = null;
    if (existingStandOverview != null)
    {
      existingStandOverview.delete();
    }
    DbHandler placeholderDbHandler = dbHandler;
    this.dbHandler = null;
    if(placeholderDbHandler != null)
    {
      placeholderDbHandler.removeStand(this);
    }
    LoginServlet placeholderLoginServlet = loginServlet;
    this.loginServlet = null;
    if(placeholderLoginServlet != null)
    {
      placeholderLoginServlet.removeStand(this);
    }
    ResultServlet placeholderResultServlet = resultServlet;
    this.resultServlet = null;
    if(placeholderResultServlet != null)
    {
      placeholderResultServlet.removeStand(this);
    }
    RegistrerStandServlet placeholderRegistrerStandServlet = registrerStandServlet;
    this.registrerStandServlet = null;
    if(placeholderRegistrerStandServlet != null)
    {
      placeholderRegistrerStandServlet.removeStand(this);
    }
    AdminServlet placeholderAdminServlet = adminServlet;
    this.adminServlet = null;
    if(placeholderAdminServlet != null)
    {
      placeholderAdminServlet.removeStand(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "," +
            "imageUrl" + ":" + getImageUrl()+ "," +
            "epostadmin" + ":" + getEpostadmin()+ "," +
            "pin" + ":" + getPin()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "standAdminServlet = "+(getStandAdminServlet()!=null?Integer.toHexString(System.identityHashCode(getStandAdminServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "standServlet = "+(getStandServlet()!=null?Integer.toHexString(System.identityHashCode(getStandServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "standOverview = "+(getStandOverview()!=null?Integer.toHexString(System.identityHashCode(getStandOverview())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "dbHandler = "+(getDbHandler()!=null?Integer.toHexString(System.identityHashCode(getDbHandler())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "loginServlet = "+(getLoginServlet()!=null?Integer.toHexString(System.identityHashCode(getLoginServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "resultServlet = "+(getResultServlet()!=null?Integer.toHexString(System.identityHashCode(getResultServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "registrerStandServlet = "+(getRegistrerStandServlet()!=null?Integer.toHexString(System.identityHashCode(getRegistrerStandServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "adminServlet = "+(getAdminServlet()!=null?Integer.toHexString(System.identityHashCode(getAdminServlet())):"null");
  }
}



//%% NEW FILE Vote BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 69 "model.ump"
// line 135 "model.ump"
public class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private int id;
  private String userName;
  private int stand;
  private int score;

  //Vote Associations
  private DbHandler dbHandler;
  private StandServlet standServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Vote(int aId, String aUserName, int aStand, int aScore, DbHandler aDbHandler, StandServlet aStandServlet)
  {
    id = aId;
    userName = aUserName;
    stand = aStand;
    score = aScore;
    boolean didAddDbHandler = setDbHandler(aDbHandler);
    if (!didAddDbHandler)
    {
      throw new RuntimeException("Unable to create vote due to dbHandler");
    }
    boolean didAddStandServlet = setStandServlet(aStandServlet);
    if (!didAddStandServlet)
    {
      throw new RuntimeException("Unable to create vote due to standServlet");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setUserName(String aUserName)
  {
    boolean wasSet = false;
    userName = aUserName;
    wasSet = true;
    return wasSet;
  }

  public boolean setStand(int aStand)
  {
    boolean wasSet = false;
    stand = aStand;
    wasSet = true;
    return wasSet;
  }

  public boolean setScore(int aScore)
  {
    boolean wasSet = false;
    score = aScore;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public String getUserName()
  {
    return userName;
  }

  public int getStand()
  {
    return stand;
  }

  public int getScore()
  {
    return score;
  }
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetOne */
  public StandServlet getStandServlet()
  {
    return standServlet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDbHandler(DbHandler aDbHandler)
  {
    boolean wasSet = false;
    if (aDbHandler == null)
    {
      return wasSet;
    }

    DbHandler existingDbHandler = dbHandler;
    dbHandler = aDbHandler;
    if (existingDbHandler != null && !existingDbHandler.equals(aDbHandler))
    {
      existingDbHandler.removeVote(this);
    }
    dbHandler.addVote(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStandServlet(StandServlet aStandServlet)
  {
    boolean wasSet = false;
    if (aStandServlet == null)
    {
      return wasSet;
    }

    StandServlet existingStandServlet = standServlet;
    standServlet = aStandServlet;
    if (existingStandServlet != null && !existingStandServlet.equals(aStandServlet))
    {
      existingStandServlet.removeVote(this);
    }
    standServlet.addVote(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    DbHandler placeholderDbHandler = dbHandler;
    this.dbHandler = null;
    if(placeholderDbHandler != null)
    {
      placeholderDbHandler.removeVote(this);
    }
    StandServlet placeholderStandServlet = standServlet;
    this.standServlet = null;
    if(placeholderStandServlet != null)
    {
      placeholderStandServlet.removeVote(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "userName" + ":" + getUserName()+ "," +
            "stand" + ":" + getStand()+ "," +
            "score" + ":" + getScore()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dbHandler = "+(getDbHandler()!=null?Integer.toHexString(System.identityHashCode(getDbHandler())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "standServlet = "+(getStandServlet()!=null?Integer.toHexString(System.identityHashCode(getStandServlet())):"null");
  }
}



//%% NEW FILE StandAdminServlet BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 30 "model.ump"
// line 105 "model.ump"
public class StandAdminServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandAdminServlet Associations
  private DbHandler dbHandler;
  private List<Stand> stands;
  private LoginUtil loginUtil;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StandAdminServlet(DbHandler aDbHandler, LoginUtil aLoginUtil)
  {
    if (aDbHandler == null || aDbHandler.getStandAdminServlet() != null)
    {
      throw new RuntimeException("Unable to create StandAdminServlet due to aDbHandler");
    }
    dbHandler = aDbHandler;
    stands = new ArrayList<Stand>();
    if (aLoginUtil == null || aLoginUtil.getStandAdminServlet() != null)
    {
      throw new RuntimeException("Unable to create StandAdminServlet due to aLoginUtil");
    }
    loginUtil = aLoginUtil;
  }

  public StandAdminServlet(String aUrlForDbHandler, String aUserForDbHandler, String aPasswordForDbHandler, LoginServlet aLoginServletForDbHandler, RegistrerStandServlet aRegistrerStandServletForDbHandler, StandServlet aStandServletForDbHandler, ResultServlet aResultServletForDbHandler, AdminServlet aAdminServletForDbHandler, RegistrerStandServlet aRegistrerStandServletForLoginUtil, LoginServlet aLoginServletForLoginUtil, AdminServlet aAdminServletForLoginUtil)
  {
    dbHandler = new DbHandler(aUrlForDbHandler, aUserForDbHandler, aPasswordForDbHandler, aLoginServletForDbHandler, this, aRegistrerStandServletForDbHandler, aStandServletForDbHandler, aResultServletForDbHandler, aAdminServletForDbHandler);
    stands = new ArrayList<Stand>();
    loginUtil = new LoginUtil(this, aRegistrerStandServletForLoginUtil, aLoginServletForLoginUtil, aAdminServletForLoginUtil);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_GetOne */
  public LoginUtil getLoginUtil()
  {
    return loginUtil;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandServlet aStandServlet, StandOverview aStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, this, aStandServlet, aStandOverview, aDbHandler, aLoginServlet, aResultServlet, aRegistrerStandServlet, aAdminServlet);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    StandAdminServlet existingStandAdminServlet = aStand.getStandAdminServlet();
    boolean isNewStandAdminServlet = existingStandAdminServlet != null && !this.equals(existingStandAdminServlet);
    if (isNewStandAdminServlet)
    {
      aStand.setStandAdminServlet(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a standAdminServlet
    if (!this.equals(aStand.getStandAdminServlet()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    DbHandler existingDbHandler = dbHandler;
    dbHandler = null;
    if (existingDbHandler != null)
    {
      existingDbHandler.delete();
    }
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
    LoginUtil existingLoginUtil = loginUtil;
    loginUtil = null;
    if (existingLoginUtil != null)
    {
      existingLoginUtil.delete();
    }
  }

}



//%% NEW FILE AdminServlet BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 44 "model.ump"
// line 120 "model.ump"
public class AdminServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AdminServlet Associations
  private DbHandler dbHandler;
  private LoginUtil loginUtil;
  private List<Stand> stands;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AdminServlet(DbHandler aDbHandler, LoginUtil aLoginUtil)
  {
    if (aDbHandler == null || aDbHandler.getAdminServlet() != null)
    {
      throw new RuntimeException("Unable to create AdminServlet due to aDbHandler");
    }
    dbHandler = aDbHandler;
    if (aLoginUtil == null || aLoginUtil.getAdminServlet() != null)
    {
      throw new RuntimeException("Unable to create AdminServlet due to aLoginUtil");
    }
    loginUtil = aLoginUtil;
    stands = new ArrayList<Stand>();
  }

  public AdminServlet(String aUrlForDbHandler, String aUserForDbHandler, String aPasswordForDbHandler, LoginServlet aLoginServletForDbHandler, StandAdminServlet aStandAdminServletForDbHandler, RegistrerStandServlet aRegistrerStandServletForDbHandler, StandServlet aStandServletForDbHandler, ResultServlet aResultServletForDbHandler, StandAdminServlet aStandAdminServletForLoginUtil, RegistrerStandServlet aRegistrerStandServletForLoginUtil, LoginServlet aLoginServletForLoginUtil)
  {
    dbHandler = new DbHandler(aUrlForDbHandler, aUserForDbHandler, aPasswordForDbHandler, aLoginServletForDbHandler, aStandAdminServletForDbHandler, aRegistrerStandServletForDbHandler, aStandServletForDbHandler, aResultServletForDbHandler, this);
    loginUtil = new LoginUtil(aStandAdminServletForLoginUtil, aRegistrerStandServletForLoginUtil, aLoginServletForLoginUtil, this);
    stands = new ArrayList<Stand>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetOne */
  public LoginUtil getLoginUtil()
  {
    return loginUtil;
  }
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, StandOverview aStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, aStandAdminServlet, aStandServlet, aStandOverview, aDbHandler, aLoginServlet, aResultServlet, aRegistrerStandServlet, this);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    AdminServlet existingAdminServlet = aStand.getAdminServlet();
    boolean isNewAdminServlet = existingAdminServlet != null && !this.equals(existingAdminServlet);
    if (isNewAdminServlet)
    {
      aStand.setAdminServlet(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a adminServlet
    if (!this.equals(aStand.getAdminServlet()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    DbHandler existingDbHandler = dbHandler;
    dbHandler = null;
    if (existingDbHandler != null)
    {
      existingDbHandler.delete();
    }
    LoginUtil existingLoginUtil = loginUtil;
    loginUtil = null;
    if (existingLoginUtil != null)
    {
      existingLoginUtil.delete();
    }
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
  }

}



//%% NEW FILE LoginUtil BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 63 "model.ump"
// line 130 "model.ump"
public class LoginUtil
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoginUtil Associations
  private StandAdminServlet standAdminServlet;
  private RegistrerStandServlet registrerStandServlet;
  private LoginServlet loginServlet;
  private AdminServlet adminServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoginUtil(StandAdminServlet aStandAdminServlet, RegistrerStandServlet aRegistrerStandServlet, LoginServlet aLoginServlet, AdminServlet aAdminServlet)
  {
    if (aStandAdminServlet == null || aStandAdminServlet.getLoginUtil() != null)
    {
      throw new RuntimeException("Unable to create LoginUtil due to aStandAdminServlet");
    }
    standAdminServlet = aStandAdminServlet;
    if (aRegistrerStandServlet == null || aRegistrerStandServlet.getLoginUtil() != null)
    {
      throw new RuntimeException("Unable to create LoginUtil due to aRegistrerStandServlet");
    }
    registrerStandServlet = aRegistrerStandServlet;
    if (aLoginServlet == null || aLoginServlet.getLoginUtil() != null)
    {
      throw new RuntimeException("Unable to create LoginUtil due to aLoginServlet");
    }
    loginServlet = aLoginServlet;
    if (aAdminServlet == null || aAdminServlet.getLoginUtil() != null)
    {
      throw new RuntimeException("Unable to create LoginUtil due to aAdminServlet");
    }
    adminServlet = aAdminServlet;
  }

  public LoginUtil(DbHandler aDbHandlerForStandAdminServlet, DbHandler aDbHandlerForRegistrerStandServlet, JavaEmail aJavaEmailForRegistrerStandServlet, String aAdminUserForLoginServlet, String aAdminPassForLoginServlet, DbHandler aDbHandlerForLoginServlet, DbHandler aDbHandlerForAdminServlet)
  {
    standAdminServlet = new StandAdminServlet(aDbHandlerForStandAdminServlet, this);
    registrerStandServlet = new RegistrerStandServlet(aDbHandlerForRegistrerStandServlet, this, aJavaEmailForRegistrerStandServlet);
    loginServlet = new LoginServlet(aAdminUserForLoginServlet, aAdminPassForLoginServlet, this, aDbHandlerForLoginServlet);
    adminServlet = new AdminServlet(aDbHandlerForAdminServlet, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public StandAdminServlet getStandAdminServlet()
  {
    return standAdminServlet;
  }
  /* Code from template association_GetOne */
  public RegistrerStandServlet getRegistrerStandServlet()
  {
    return registrerStandServlet;
  }
  /* Code from template association_GetOne */
  public LoginServlet getLoginServlet()
  {
    return loginServlet;
  }
  /* Code from template association_GetOne */
  public AdminServlet getAdminServlet()
  {
    return adminServlet;
  }

  public void delete()
  {
    StandAdminServlet existingStandAdminServlet = standAdminServlet;
    standAdminServlet = null;
    if (existingStandAdminServlet != null)
    {
      existingStandAdminServlet.delete();
    }
    RegistrerStandServlet existingRegistrerStandServlet = registrerStandServlet;
    registrerStandServlet = null;
    if (existingRegistrerStandServlet != null)
    {
      existingRegistrerStandServlet.delete();
    }
    LoginServlet existingLoginServlet = loginServlet;
    loginServlet = null;
    if (existingLoginServlet != null)
    {
      existingLoginServlet.delete();
    }
    AdminServlet existingAdminServlet = adminServlet;
    adminServlet = null;
    if (existingAdminServlet != null)
    {
      existingAdminServlet.delete();
    }
  }

}



//%% NEW FILE JavaEmail BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 77 "model.ump"
// line 140 "model.ump"
public class JavaEmail
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //JavaEmail Attributes
  private Session mailSession;

  //JavaEmail Associations
  private RegistrerStandServlet registrerStandServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JavaEmail(Session aMailSession, RegistrerStandServlet aRegistrerStandServlet)
  {
    mailSession = aMailSession;
    if (aRegistrerStandServlet == null || aRegistrerStandServlet.getJavaEmail() != null)
    {
      throw new RuntimeException("Unable to create JavaEmail due to aRegistrerStandServlet");
    }
    registrerStandServlet = aRegistrerStandServlet;
  }

  public JavaEmail(Session aMailSession, DbHandler aDbHandlerForRegistrerStandServlet, LoginUtil aLoginUtilForRegistrerStandServlet)
  {
    mailSession = aMailSession;
    registrerStandServlet = new RegistrerStandServlet(aDbHandlerForRegistrerStandServlet, aLoginUtilForRegistrerStandServlet, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMailSession(Session aMailSession)
  {
    boolean wasSet = false;
    mailSession = aMailSession;
    wasSet = true;
    return wasSet;
  }

  public Session getMailSession()
  {
    return mailSession;
  }
  /* Code from template association_GetOne */
  public RegistrerStandServlet getRegistrerStandServlet()
  {
    return registrerStandServlet;
  }

  public void delete()
  {
    RegistrerStandServlet existingRegistrerStandServlet = registrerStandServlet;
    registrerStandServlet = null;
    if (existingRegistrerStandServlet != null)
    {
      existingRegistrerStandServlet.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mailSession" + "=" + (getMailSession() != null ? !getMailSession().equals(this)  ? getMailSession().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "registrerStandServlet = "+(getRegistrerStandServlet()!=null?Integer.toHexString(System.identityHashCode(getRegistrerStandServlet())):"null");
  }
}



//%% NEW FILE ResultServlet BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 25 "model.ump"
// line 100 "model.ump"
public class ResultServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ResultServlet Associations
  private List<Stand> stands;
  private DbHandler dbHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ResultServlet(DbHandler aDbHandler)
  {
    stands = new ArrayList<Stand>();
    if (aDbHandler == null || aDbHandler.getResultServlet() != null)
    {
      throw new RuntimeException("Unable to create ResultServlet due to aDbHandler");
    }
    dbHandler = aDbHandler;
  }

  public ResultServlet(String aUrlForDbHandler, String aUserForDbHandler, String aPasswordForDbHandler, LoginServlet aLoginServletForDbHandler, StandAdminServlet aStandAdminServletForDbHandler, RegistrerStandServlet aRegistrerStandServletForDbHandler, StandServlet aStandServletForDbHandler, AdminServlet aAdminServletForDbHandler)
  {
    stands = new ArrayList<Stand>();
    dbHandler = new DbHandler(aUrlForDbHandler, aUserForDbHandler, aPasswordForDbHandler, aLoginServletForDbHandler, aStandAdminServletForDbHandler, aRegistrerStandServletForDbHandler, aStandServletForDbHandler, this, aAdminServletForDbHandler);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, StandOverview aStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, aStandAdminServlet, aStandServlet, aStandOverview, aDbHandler, aLoginServlet, this, aRegistrerStandServlet, aAdminServlet);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    ResultServlet existingResultServlet = aStand.getResultServlet();
    boolean isNewResultServlet = existingResultServlet != null && !this.equals(existingResultServlet);
    if (isNewResultServlet)
    {
      aStand.setResultServlet(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a resultServlet
    if (!this.equals(aStand.getResultServlet()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
    DbHandler existingDbHandler = dbHandler;
    dbHandler = null;
    if (existingDbHandler != null)
    {
      existingDbHandler.delete();
    }
  }

}



//%% NEW FILE DbHandler BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 88 "model.ump"
public class DbHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DbHandler Attributes
  private String url;
  private String user;
  private String password;

  //DbHandler Associations
  private LoginServlet loginServlet;
  private StandAdminServlet standAdminServlet;
  private RegistrerStandServlet registrerStandServlet;
  private StandServlet standServlet;
  private ResultServlet resultServlet;
  private List<Stand> stands;
  private List<StandOverview> standOverviews;
  private List<Vote> votes;
  private AdminServlet adminServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DbHandler(String aUrl, String aUser, String aPassword, LoginServlet aLoginServlet, StandAdminServlet aStandAdminServlet, RegistrerStandServlet aRegistrerStandServlet, StandServlet aStandServlet, ResultServlet aResultServlet, AdminServlet aAdminServlet)
  {
    url = aUrl;
    user = aUser;
    password = aPassword;
    if (aLoginServlet == null || aLoginServlet.getDbHandler() != null)
    {
      throw new RuntimeException("Unable to create DbHandler due to aLoginServlet");
    }
    loginServlet = aLoginServlet;
    if (aStandAdminServlet == null || aStandAdminServlet.getDbHandler() != null)
    {
      throw new RuntimeException("Unable to create DbHandler due to aStandAdminServlet");
    }
    standAdminServlet = aStandAdminServlet;
    if (aRegistrerStandServlet == null || aRegistrerStandServlet.getDbHandler() != null)
    {
      throw new RuntimeException("Unable to create DbHandler due to aRegistrerStandServlet");
    }
    registrerStandServlet = aRegistrerStandServlet;
    if (aStandServlet == null || aStandServlet.getDbHandler() != null)
    {
      throw new RuntimeException("Unable to create DbHandler due to aStandServlet");
    }
    standServlet = aStandServlet;
    if (aResultServlet == null || aResultServlet.getDbHandler() != null)
    {
      throw new RuntimeException("Unable to create DbHandler due to aResultServlet");
    }
    resultServlet = aResultServlet;
    stands = new ArrayList<Stand>();
    standOverviews = new ArrayList<StandOverview>();
    votes = new ArrayList<Vote>();
    if (aAdminServlet == null || aAdminServlet.getDbHandler() != null)
    {
      throw new RuntimeException("Unable to create DbHandler due to aAdminServlet");
    }
    adminServlet = aAdminServlet;
  }

  public DbHandler(String aUrl, String aUser, String aPassword, String aAdminUserForLoginServlet, String aAdminPassForLoginServlet, LoginUtil aLoginUtilForLoginServlet, LoginUtil aLoginUtilForStandAdminServlet, LoginUtil aLoginUtilForRegistrerStandServlet, JavaEmail aJavaEmailForRegistrerStandServlet, LoginUtil aLoginUtilForAdminServlet)
  {
    url = aUrl;
    user = aUser;
    password = aPassword;
    loginServlet = new LoginServlet(aAdminUserForLoginServlet, aAdminPassForLoginServlet, aLoginUtilForLoginServlet, this);
    standAdminServlet = new StandAdminServlet(this, aLoginUtilForStandAdminServlet);
    registrerStandServlet = new RegistrerStandServlet(this, aLoginUtilForRegistrerStandServlet, aJavaEmailForRegistrerStandServlet);
    standServlet = new StandServlet(this);
    resultServlet = new ResultServlet(this);
    stands = new ArrayList<Stand>();
    standOverviews = new ArrayList<StandOverview>();
    votes = new ArrayList<Vote>();
    adminServlet = new AdminServlet(this, aLoginUtilForAdminServlet);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUrl(String aUrl)
  {
    boolean wasSet = false;
    url = aUrl;
    wasSet = true;
    return wasSet;
  }

  public boolean setUser(String aUser)
  {
    boolean wasSet = false;
    user = aUser;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getUrl()
  {
    return url;
  }

  public String getUser()
  {
    return user;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetOne */
  public LoginServlet getLoginServlet()
  {
    return loginServlet;
  }
  /* Code from template association_GetOne */
  public StandAdminServlet getStandAdminServlet()
  {
    return standAdminServlet;
  }
  /* Code from template association_GetOne */
  public RegistrerStandServlet getRegistrerStandServlet()
  {
    return registrerStandServlet;
  }
  /* Code from template association_GetOne */
  public StandServlet getStandServlet()
  {
    return standServlet;
  }
  /* Code from template association_GetOne */
  public ResultServlet getResultServlet()
  {
    return resultServlet;
  }
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_GetMany */
  public StandOverview getStandOverview(int index)
  {
    StandOverview aStandOverview = standOverviews.get(index);
    return aStandOverview;
  }

  public List<StandOverview> getStandOverviews()
  {
    List<StandOverview> newStandOverviews = Collections.unmodifiableList(standOverviews);
    return newStandOverviews;
  }

  public int numberOfStandOverviews()
  {
    int number = standOverviews.size();
    return number;
  }

  public boolean hasStandOverviews()
  {
    boolean has = standOverviews.size() > 0;
    return has;
  }

  public int indexOfStandOverview(StandOverview aStandOverview)
  {
    int index = standOverviews.indexOf(aStandOverview);
    return index;
  }
  /* Code from template association_GetMany */
  public Vote getVote(int index)
  {
    Vote aVote = votes.get(index);
    return aVote;
  }

  public List<Vote> getVotes()
  {
    List<Vote> newVotes = Collections.unmodifiableList(votes);
    return newVotes;
  }

  public int numberOfVotes()
  {
    int number = votes.size();
    return number;
  }

  public boolean hasVotes()
  {
    boolean has = votes.size() > 0;
    return has;
  }

  public int indexOfVote(Vote aVote)
  {
    int index = votes.indexOf(aVote);
    return index;
  }
  /* Code from template association_GetOne */
  public AdminServlet getAdminServlet()
  {
    return adminServlet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, StandOverview aStandOverview, LoginServlet aLoginServlet, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, aStandAdminServlet, aStandServlet, aStandOverview, this, aLoginServlet, aResultServlet, aRegistrerStandServlet, aAdminServlet);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    DbHandler existingDbHandler = aStand.getDbHandler();
    boolean isNewDbHandler = existingDbHandler != null && !this.equals(existingDbHandler);
    if (isNewDbHandler)
    {
      aStand.setDbHandler(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a dbHandler
    if (!this.equals(aStand.getDbHandler()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStandOverviews()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public StandOverview addStandOverview(Stand aStand)
  {
    return new StandOverview(this, aStand);
  }

  public boolean addStandOverview(StandOverview aStandOverview)
  {
    boolean wasAdded = false;
    if (standOverviews.contains(aStandOverview)) { return false; }
    DbHandler existingDbHandler = aStandOverview.getDbHandler();
    boolean isNewDbHandler = existingDbHandler != null && !this.equals(existingDbHandler);
    if (isNewDbHandler)
    {
      aStandOverview.setDbHandler(this);
    }
    else
    {
      standOverviews.add(aStandOverview);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStandOverview(StandOverview aStandOverview)
  {
    boolean wasRemoved = false;
    //Unable to remove aStandOverview, as it must always have a dbHandler
    if (!this.equals(aStandOverview.getDbHandler()))
    {
      standOverviews.remove(aStandOverview);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandOverviewAt(StandOverview aStandOverview, int index)
  {  
    boolean wasAdded = false;
    if(addStandOverview(aStandOverview))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStandOverviews()) { index = numberOfStandOverviews() - 1; }
      standOverviews.remove(aStandOverview);
      standOverviews.add(index, aStandOverview);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandOverviewAt(StandOverview aStandOverview, int index)
  {
    boolean wasAdded = false;
    if(standOverviews.contains(aStandOverview))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStandOverviews()) { index = numberOfStandOverviews() - 1; }
      standOverviews.remove(aStandOverview);
      standOverviews.add(index, aStandOverview);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandOverviewAt(aStandOverview, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVotes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vote addVote(int aId, String aUserName, int aStand, int aScore, StandServlet aStandServlet)
  {
    return new Vote(aId, aUserName, aStand, aScore, this, aStandServlet);
  }

  public boolean addVote(Vote aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    DbHandler existingDbHandler = aVote.getDbHandler();
    boolean isNewDbHandler = existingDbHandler != null && !this.equals(existingDbHandler);
    if (isNewDbHandler)
    {
      aVote.setDbHandler(this);
    }
    else
    {
      votes.add(aVote);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVote(Vote aVote)
  {
    boolean wasRemoved = false;
    //Unable to remove aVote, as it must always have a dbHandler
    if (!this.equals(aVote.getDbHandler()))
    {
      votes.remove(aVote);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVoteAt(Vote aVote, int index)
  {  
    boolean wasAdded = false;
    if(addVote(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoteAt(Vote aVote, int index)
  {
    boolean wasAdded = false;
    if(votes.contains(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoteAt(aVote, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    LoginServlet existingLoginServlet = loginServlet;
    loginServlet = null;
    if (existingLoginServlet != null)
    {
      existingLoginServlet.delete();
    }
    StandAdminServlet existingStandAdminServlet = standAdminServlet;
    standAdminServlet = null;
    if (existingStandAdminServlet != null)
    {
      existingStandAdminServlet.delete();
    }
    RegistrerStandServlet existingRegistrerStandServlet = registrerStandServlet;
    registrerStandServlet = null;
    if (existingRegistrerStandServlet != null)
    {
      existingRegistrerStandServlet.delete();
    }
    StandServlet existingStandServlet = standServlet;
    standServlet = null;
    if (existingStandServlet != null)
    {
      existingStandServlet.delete();
    }
    ResultServlet existingResultServlet = resultServlet;
    resultServlet = null;
    if (existingResultServlet != null)
    {
      existingResultServlet.delete();
    }
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
    for(int i=standOverviews.size(); i > 0; i--)
    {
      StandOverview aStandOverview = standOverviews.get(i - 1);
      aStandOverview.delete();
    }
    for(int i=votes.size(); i > 0; i--)
    {
      Vote aVote = votes.get(i - 1);
      aVote.delete();
    }
    AdminServlet existingAdminServlet = adminServlet;
    adminServlet = null;
    if (existingAdminServlet != null)
    {
      existingAdminServlet.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "url" + ":" + getUrl()+ "," +
            "user" + ":" + getUser()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "loginServlet = "+(getLoginServlet()!=null?Integer.toHexString(System.identityHashCode(getLoginServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "standAdminServlet = "+(getStandAdminServlet()!=null?Integer.toHexString(System.identityHashCode(getStandAdminServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "registrerStandServlet = "+(getRegistrerStandServlet()!=null?Integer.toHexString(System.identityHashCode(getRegistrerStandServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "standServlet = "+(getStandServlet()!=null?Integer.toHexString(System.identityHashCode(getStandServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "resultServlet = "+(getResultServlet()!=null?Integer.toHexString(System.identityHashCode(getResultServlet())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "adminServlet = "+(getAdminServlet()!=null?Integer.toHexString(System.identityHashCode(getAdminServlet())):"null");
  }
}



//%% NEW FILE StandServlet BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 39 "model.ump"
// line 115 "model.ump"
public class StandServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandServlet Associations
  private List<Vote> votes;
  private DbHandler dbHandler;
  private List<Stand> stands;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StandServlet(DbHandler aDbHandler)
  {
    votes = new ArrayList<Vote>();
    if (aDbHandler == null || aDbHandler.getStandServlet() != null)
    {
      throw new RuntimeException("Unable to create StandServlet due to aDbHandler");
    }
    dbHandler = aDbHandler;
    stands = new ArrayList<Stand>();
  }

  public StandServlet(String aUrlForDbHandler, String aUserForDbHandler, String aPasswordForDbHandler, LoginServlet aLoginServletForDbHandler, StandAdminServlet aStandAdminServletForDbHandler, RegistrerStandServlet aRegistrerStandServletForDbHandler, ResultServlet aResultServletForDbHandler, AdminServlet aAdminServletForDbHandler)
  {
    votes = new ArrayList<Vote>();
    dbHandler = new DbHandler(aUrlForDbHandler, aUserForDbHandler, aPasswordForDbHandler, aLoginServletForDbHandler, aStandAdminServletForDbHandler, aRegistrerStandServletForDbHandler, this, aResultServletForDbHandler, aAdminServletForDbHandler);
    stands = new ArrayList<Stand>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Vote getVote(int index)
  {
    Vote aVote = votes.get(index);
    return aVote;
  }

  public List<Vote> getVotes()
  {
    List<Vote> newVotes = Collections.unmodifiableList(votes);
    return newVotes;
  }

  public int numberOfVotes()
  {
    int number = votes.size();
    return number;
  }

  public boolean hasVotes()
  {
    boolean has = votes.size() > 0;
    return has;
  }

  public int indexOfVote(Vote aVote)
  {
    int index = votes.indexOf(aVote);
    return index;
  }
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVotes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Vote addVote(int aId, String aUserName, int aStand, int aScore, DbHandler aDbHandler)
  {
    return new Vote(aId, aUserName, aStand, aScore, aDbHandler, this);
  }

  public boolean addVote(Vote aVote)
  {
    boolean wasAdded = false;
    if (votes.contains(aVote)) { return false; }
    StandServlet existingStandServlet = aVote.getStandServlet();
    boolean isNewStandServlet = existingStandServlet != null && !this.equals(existingStandServlet);
    if (isNewStandServlet)
    {
      aVote.setStandServlet(this);
    }
    else
    {
      votes.add(aVote);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVote(Vote aVote)
  {
    boolean wasRemoved = false;
    //Unable to remove aVote, as it must always have a standServlet
    if (!this.equals(aVote.getStandServlet()))
    {
      votes.remove(aVote);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVoteAt(Vote aVote, int index)
  {  
    boolean wasAdded = false;
    if(addVote(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoteAt(Vote aVote, int index)
  {
    boolean wasAdded = false;
    if(votes.contains(aVote))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVotes()) { index = numberOfVotes() - 1; }
      votes.remove(aVote);
      votes.add(index, aVote);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoteAt(aVote, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandOverview aStandOverview, DbHandler aDbHandler, LoginServlet aLoginServlet, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, aStandAdminServlet, this, aStandOverview, aDbHandler, aLoginServlet, aResultServlet, aRegistrerStandServlet, aAdminServlet);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    StandServlet existingStandServlet = aStand.getStandServlet();
    boolean isNewStandServlet = existingStandServlet != null && !this.equals(existingStandServlet);
    if (isNewStandServlet)
    {
      aStand.setStandServlet(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a standServlet
    if (!this.equals(aStand.getStandServlet()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=votes.size(); i > 0; i--)
    {
      Vote aVote = votes.get(i - 1);
      aVote.delete();
    }
    DbHandler existingDbHandler = dbHandler;
    dbHandler = null;
    if (existingDbHandler != null)
    {
      existingDbHandler.delete();
    }
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
  }

}



//%% NEW FILE LoginServlet BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/


import java.util.*;

// line 17 "model.ump"
// line 95 "model.ump"
public class LoginServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoginServlet Attributes
  private String adminUser;
  private String adminPass;

  //LoginServlet Associations
  private LoginUtil loginUtil;
  private List<Stand> stands;
  private DbHandler dbHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoginServlet(String aAdminUser, String aAdminPass, LoginUtil aLoginUtil, DbHandler aDbHandler)
  {
    adminUser = aAdminUser;
    adminPass = aAdminPass;
    if (aLoginUtil == null || aLoginUtil.getLoginServlet() != null)
    {
      throw new RuntimeException("Unable to create LoginServlet due to aLoginUtil");
    }
    loginUtil = aLoginUtil;
    stands = new ArrayList<Stand>();
    if (aDbHandler == null || aDbHandler.getLoginServlet() != null)
    {
      throw new RuntimeException("Unable to create LoginServlet due to aDbHandler");
    }
    dbHandler = aDbHandler;
  }

  public LoginServlet(String aAdminUser, String aAdminPass, StandAdminServlet aStandAdminServletForLoginUtil, RegistrerStandServlet aRegistrerStandServletForLoginUtil, AdminServlet aAdminServletForLoginUtil, String aUrlForDbHandler, String aUserForDbHandler, String aPasswordForDbHandler, StandAdminServlet aStandAdminServletForDbHandler, RegistrerStandServlet aRegistrerStandServletForDbHandler, StandServlet aStandServletForDbHandler, ResultServlet aResultServletForDbHandler, AdminServlet aAdminServletForDbHandler)
  {
    adminUser = aAdminUser;
    adminPass = aAdminPass;
    loginUtil = new LoginUtil(aStandAdminServletForLoginUtil, aRegistrerStandServletForLoginUtil, this, aAdminServletForLoginUtil);
    stands = new ArrayList<Stand>();
    dbHandler = new DbHandler(aUrlForDbHandler, aUserForDbHandler, aPasswordForDbHandler, this, aStandAdminServletForDbHandler, aRegistrerStandServletForDbHandler, aStandServletForDbHandler, aResultServletForDbHandler, aAdminServletForDbHandler);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAdminUser(String aAdminUser)
  {
    boolean wasSet = false;
    adminUser = aAdminUser;
    wasSet = true;
    return wasSet;
  }

  public boolean setAdminPass(String aAdminPass)
  {
    boolean wasSet = false;
    adminPass = aAdminPass;
    wasSet = true;
    return wasSet;
  }

  public String getAdminUser()
  {
    return adminUser;
  }

  public String getAdminPass()
  {
    return adminPass;
  }
  /* Code from template association_GetOne */
  public LoginUtil getLoginUtil()
  {
    return loginUtil;
  }
  /* Code from template association_GetMany */
  public Stand getStand(int index)
  {
    Stand aStand = stands.get(index);
    return aStand;
  }

  public List<Stand> getStands()
  {
    List<Stand> newStands = Collections.unmodifiableList(stands);
    return newStands;
  }

  public int numberOfStands()
  {
    int number = stands.size();
    return number;
  }

  public boolean hasStands()
  {
    boolean has = stands.size() > 0;
    return has;
  }

  public int indexOfStand(Stand aStand)
  {
    int index = stands.indexOf(aStand);
    return index;
  }
  /* Code from template association_GetOne */
  public DbHandler getDbHandler()
  {
    return dbHandler;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStands()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stand addStand(int aId, String aName, String aImageUrl, String aEpostadmin, String aPin, StandAdminServlet aStandAdminServlet, StandServlet aStandServlet, StandOverview aStandOverview, DbHandler aDbHandler, ResultServlet aResultServlet, RegistrerStandServlet aRegistrerStandServlet, AdminServlet aAdminServlet)
  {
    return new Stand(aId, aName, aImageUrl, aEpostadmin, aPin, aStandAdminServlet, aStandServlet, aStandOverview, aDbHandler, this, aResultServlet, aRegistrerStandServlet, aAdminServlet);
  }

  public boolean addStand(Stand aStand)
  {
    boolean wasAdded = false;
    if (stands.contains(aStand)) { return false; }
    LoginServlet existingLoginServlet = aStand.getLoginServlet();
    boolean isNewLoginServlet = existingLoginServlet != null && !this.equals(existingLoginServlet);
    if (isNewLoginServlet)
    {
      aStand.setLoginServlet(this);
    }
    else
    {
      stands.add(aStand);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStand(Stand aStand)
  {
    boolean wasRemoved = false;
    //Unable to remove aStand, as it must always have a loginServlet
    if (!this.equals(aStand.getLoginServlet()))
    {
      stands.remove(aStand);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandAt(Stand aStand, int index)
  {  
    boolean wasAdded = false;
    if(addStand(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandAt(Stand aStand, int index)
  {
    boolean wasAdded = false;
    if(stands.contains(aStand))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStands()) { index = numberOfStands() - 1; }
      stands.remove(aStand);
      stands.add(index, aStand);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandAt(aStand, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    LoginUtil existingLoginUtil = loginUtil;
    loginUtil = null;
    if (existingLoginUtil != null)
    {
      existingLoginUtil.delete();
    }
    for(int i=stands.size(); i > 0; i--)
    {
      Stand aStand = stands.get(i - 1);
      aStand.delete();
    }
    DbHandler existingDbHandler = dbHandler;
    dbHandler = null;
    if (existingDbHandler != null)
    {
      existingDbHandler.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "adminUser" + ":" + getAdminUser()+ "," +
            "adminPass" + ":" + getAdminPass()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "loginUtil = "+(getLoginUtil()!=null?Integer.toHexString(System.identityHashCode(getLoginUtil())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "dbHandler = "+(getDbHandler()!=null?Integer.toHexString(System.identityHashCode(getDbHandler())):"null");
  }
}
