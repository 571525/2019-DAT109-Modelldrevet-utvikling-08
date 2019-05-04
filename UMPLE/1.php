//%% NEW FILE RegistrerStandServlet BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class RegistrerStandServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegistrerStandServlet Associations
  private $stands;
  private $dbHandler;
  private $loginUtil;
  private $javaEmail;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDbHandler = null, $aLoginUtil = null, $aJavaEmail = null)
  {
    if (func_num_args() == 0) { return; }

    $this->stands = array();
    if ($aDbHandler == null || $aDbHandler->getRegistrerStandServlet() != null)
    {
      throw new Exception("Unable to create RegistrerStandServlet due to aDbHandler");
    }
    $this->dbHandler = $aDbHandler;
    if ($aLoginUtil == null || $aLoginUtil->getRegistrerStandServlet() != null)
    {
      throw new Exception("Unable to create RegistrerStandServlet due to aLoginUtil");
    }
    $this->loginUtil = $aLoginUtil;
    if ($aJavaEmail == null || $aJavaEmail->getRegistrerStandServlet() != null)
    {
      throw new Exception("Unable to create RegistrerStandServlet due to aJavaEmail");
    }
    $this->javaEmail = $aJavaEmail;
  }
  public static function newInstance($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler, $aStandAdminServletForLoginUtil, $aLoginServletForLoginUtil, $aAdminServletForLoginUtil, $aMailSessionForJavaEmail)
  {
    $thisInstance = new RegistrerStandServlet();
    $this->stands = array();
    $thisInstance->dbHandler = new DbHandler($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $thisInstance, $aStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler);
    $thisInstance->loginUtil = new LoginUtil($aStandAdminServletForLoginUtil, $thisInstance, $aLoginServletForLoginUtil, $aAdminServletForLoginUtil);
    $thisInstance->javaEmail = new JavaEmail($aMailSessionForJavaEmail, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getLoginUtil()
  {
    return $this->loginUtil;
  }

  public function getJavaEmail()
  {
    return $this->javaEmail;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aAdminServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $this, $aAdminServlet);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingRegistrerStandServlet = $aStand->getRegistrerStandServlet();
    $isNewRegistrerStandServlet = $existingRegistrerStandServlet != null && $this !== $existingRegistrerStandServlet;
    if ($isNewRegistrerStandServlet)
    {
      $aStand->setRegistrerStandServlet($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a registrerStandServlet
    if ($this !== $aStand->getRegistrerStandServlet())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    if ($existingDbHandler != null)
    {
      $existingDbHandler->delete();
    }
    $existingLoginUtil = $this->loginUtil;
    $this->loginUtil = null;
    if ($existingLoginUtil != null)
    {
      $existingLoginUtil->delete();
    }
    $existingJavaEmail = $this->javaEmail;
    $this->javaEmail = null;
    if ($existingJavaEmail != null)
    {
      $existingJavaEmail->delete();
    }
  }

}




//%% NEW FILE StandOverview BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class StandOverview
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandOverview Associations
  private $dbHandler;
  private $stand;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDbHandler = null, $aStand = null)
  {
    if (func_num_args() == 0) { return; }

    $didAddDbHandler = $this->setDbHandler($aDbHandler);
    if (!$didAddDbHandler)
    {
      throw new Exception("Unable to create standOverview due to dbHandler");
    }
    if ($aStand == null || $aStand->getStandOverview() != null)
    {
      throw new Exception("Unable to create StandOverview due to aStand");
    }
    $this->stand = $aStand;
  }
  public static function newInstance($aDbHandler, $aIdForStand, $aNameForStand, $aImageUrlForStand, $aEpostadminForStand, $aPinForStand, $aStandAdminServletForStand, $aStandServletForStand, $aDbHandlerForStand, $aLoginServletForStand, $aResultServletForStand, $aRegistrerStandServletForStand, $aAdminServletForStand)
  {
    $thisInstance = new StandOverview();$this->dbHandlers = array();
    $this->dbHandlers[] = $aDbHandler;
    $thisInstance->stand = new Stand($aIdForStand, $aNameForStand, $aImageUrlForStand, $aEpostadminForStand, $aPinForStand, $aStandAdminServletForStand, $aStandServletForStand, $thisInstance, $aDbHandlerForStand, $aLoginServletForStand, $aResultServletForStand, $aRegistrerStandServletForStand, $aAdminServletForStand);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getStand()
  {
    return $this->stand;
  }

  public function setDbHandler($aDbHandler)
  {
    $wasSet = false;
    if ($aDbHandler == null)
    {
      return $wasSet;
    }
    
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = $aDbHandler;
    if ($existingDbHandler != null && $existingDbHandler != $aDbHandler)
    {
      $existingDbHandler->removeStandOverview($this);
    }
    $this->dbHandler->addStandOverview($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    $placeholderDbHandler->removeStandOverview($this);
    $existingStand = $this->stand;
    $this->stand = null;
    if ($existingStand != null)
    {
      $existingStand->delete();
    }
  }

}




//%% NEW FILE Stand BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class Stand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stand Attributes
  private $id;
  private $name;
  private $imageUrl;
  private $epostadmin;
  private $pin;

  //Stand Associations
  private $standAdminServlet;
  private $standServlet;
  private $standOverview;
  private $dbHandler;
  private $loginServlet;
  private $resultServlet;
  private $registrerStandServlet;
  private $adminServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId = null, $aName = null, $aImageUrl = null, $aEpostadmin = null, $aPin = null, $aStandAdminServlet = null, $aStandServlet = null, $aStandOverview = null, $aDbHandler = null, $aLoginServlet = null, $aResultServlet = null, $aRegistrerStandServlet = null, $aAdminServlet = null)
  {
    if (func_num_args() == 0) { return; }

    $this->id = $aId;
    $this->name = $aName;
    $this->imageUrl = $aImageUrl;
    $this->epostadmin = $aEpostadmin;
    $this->pin = $aPin;
    $didAddStandAdminServlet = $this->setStandAdminServlet($aStandAdminServlet);
    if (!$didAddStandAdminServlet)
    {
      throw new Exception("Unable to create stand due to standAdminServlet");
    }
    $didAddStandServlet = $this->setStandServlet($aStandServlet);
    if (!$didAddStandServlet)
    {
      throw new Exception("Unable to create stand due to standServlet");
    }
    if ($aStandOverview == null || $aStandOverview->getStand() != null)
    {
      throw new Exception("Unable to create Stand due to aStandOverview");
    }
    $this->standOverview = $aStandOverview;
    $didAddDbHandler = $this->setDbHandler($aDbHandler);
    if (!$didAddDbHandler)
    {
      throw new Exception("Unable to create stand due to dbHandler");
    }
    $didAddLoginServlet = $this->setLoginServlet($aLoginServlet);
    if (!$didAddLoginServlet)
    {
      throw new Exception("Unable to create stand due to loginServlet");
    }
    $didAddResultServlet = $this->setResultServlet($aResultServlet);
    if (!$didAddResultServlet)
    {
      throw new Exception("Unable to create stand due to resultServlet");
    }
    $didAddRegistrerStandServlet = $this->setRegistrerStandServlet($aRegistrerStandServlet);
    if (!$didAddRegistrerStandServlet)
    {
      throw new Exception("Unable to create stand due to registrerStandServlet");
    }
    $didAddAdminServlet = $this->setAdminServlet($aAdminServlet);
    if (!$didAddAdminServlet)
    {
      throw new Exception("Unable to create stand due to adminServlet");
    }
  }
  public static function newInstance($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aDbHandlerForStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet)
  {
    $thisInstance = new Stand();
    $thisInstance->id = $aId;
    $thisInstance->name = $aName;
    $thisInstance->imageUrl = $aImageUrl;
    $thisInstance->epostadmin = $aEpostadmin;
    $thisInstance->pin = $aPin;$this->standAdminServlets = array();
    $this->standAdminServlets[] = $aStandAdminServlet;$this->standServlets = array();
    $this->standServlets[] = $aStandServlet;
    $thisInstance->standOverview = new StandOverview($aDbHandlerForStandOverview, $thisInstance);$this->dbHandlers = array();
    $this->dbHandlers[] = $aDbHandler;$this->loginServlets = array();
    $this->loginServlets[] = $aLoginServlet;$this->resultServlets = array();
    $this->resultServlets[] = $aResultServlet;$this->registrerStandServlets = array();
    $this->registrerStandServlets[] = $aRegistrerStandServlet;$this->adminServlets = array();
    $this->adminServlets[] = $aAdminServlet;
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setImageUrl($aImageUrl)
  {
    $wasSet = false;
    $this->imageUrl = $aImageUrl;
    $wasSet = true;
    return $wasSet;
  }

  public function setEpostadmin($aEpostadmin)
  {
    $wasSet = false;
    $this->epostadmin = $aEpostadmin;
    $wasSet = true;
    return $wasSet;
  }

  public function setPin($aPin)
  {
    $wasSet = false;
    $this->pin = $aPin;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getImageUrl()
  {
    return $this->imageUrl;
  }

  public function getEpostadmin()
  {
    return $this->epostadmin;
  }

  public function getPin()
  {
    return $this->pin;
  }

  public function getStandAdminServlet()
  {
    return $this->standAdminServlet;
  }

  public function getStandServlet()
  {
    return $this->standServlet;
  }

  public function getStandOverview()
  {
    return $this->standOverview;
  }

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getLoginServlet()
  {
    return $this->loginServlet;
  }

  public function getResultServlet()
  {
    return $this->resultServlet;
  }

  public function getRegistrerStandServlet()
  {
    return $this->registrerStandServlet;
  }

  public function getAdminServlet()
  {
    return $this->adminServlet;
  }

  public function setStandAdminServlet($aStandAdminServlet)
  {
    $wasSet = false;
    if ($aStandAdminServlet == null)
    {
      return $wasSet;
    }
    
    $existingStandAdminServlet = $this->standAdminServlet;
    $this->standAdminServlet = $aStandAdminServlet;
    if ($existingStandAdminServlet != null && $existingStandAdminServlet != $aStandAdminServlet)
    {
      $existingStandAdminServlet->removeStand($this);
    }
    $this->standAdminServlet->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setStandServlet($aStandServlet)
  {
    $wasSet = false;
    if ($aStandServlet == null)
    {
      return $wasSet;
    }
    
    $existingStandServlet = $this->standServlet;
    $this->standServlet = $aStandServlet;
    if ($existingStandServlet != null && $existingStandServlet != $aStandServlet)
    {
      $existingStandServlet->removeStand($this);
    }
    $this->standServlet->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setDbHandler($aDbHandler)
  {
    $wasSet = false;
    if ($aDbHandler == null)
    {
      return $wasSet;
    }
    
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = $aDbHandler;
    if ($existingDbHandler != null && $existingDbHandler != $aDbHandler)
    {
      $existingDbHandler->removeStand($this);
    }
    $this->dbHandler->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setLoginServlet($aLoginServlet)
  {
    $wasSet = false;
    if ($aLoginServlet == null)
    {
      return $wasSet;
    }
    
    $existingLoginServlet = $this->loginServlet;
    $this->loginServlet = $aLoginServlet;
    if ($existingLoginServlet != null && $existingLoginServlet != $aLoginServlet)
    {
      $existingLoginServlet->removeStand($this);
    }
    $this->loginServlet->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setResultServlet($aResultServlet)
  {
    $wasSet = false;
    if ($aResultServlet == null)
    {
      return $wasSet;
    }
    
    $existingResultServlet = $this->resultServlet;
    $this->resultServlet = $aResultServlet;
    if ($existingResultServlet != null && $existingResultServlet != $aResultServlet)
    {
      $existingResultServlet->removeStand($this);
    }
    $this->resultServlet->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setRegistrerStandServlet($aRegistrerStandServlet)
  {
    $wasSet = false;
    if ($aRegistrerStandServlet == null)
    {
      return $wasSet;
    }
    
    $existingRegistrerStandServlet = $this->registrerStandServlet;
    $this->registrerStandServlet = $aRegistrerStandServlet;
    if ($existingRegistrerStandServlet != null && $existingRegistrerStandServlet != $aRegistrerStandServlet)
    {
      $existingRegistrerStandServlet->removeStand($this);
    }
    $this->registrerStandServlet->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setAdminServlet($aAdminServlet)
  {
    $wasSet = false;
    if ($aAdminServlet == null)
    {
      return $wasSet;
    }
    
    $existingAdminServlet = $this->adminServlet;
    $this->adminServlet = $aAdminServlet;
    if ($existingAdminServlet != null && $existingAdminServlet != $aAdminServlet)
    {
      $existingAdminServlet->removeStand($this);
    }
    $this->adminServlet->addStand($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderStandAdminServlet = $this->standAdminServlet;
    $this->standAdminServlet = null;
    $placeholderStandAdminServlet->removeStand($this);
    $placeholderStandServlet = $this->standServlet;
    $this->standServlet = null;
    $placeholderStandServlet->removeStand($this);
    $existingStandOverview = $this->standOverview;
    $this->standOverview = null;
    if ($existingStandOverview != null)
    {
      $existingStandOverview->delete();
    }
    $placeholderDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    $placeholderDbHandler->removeStand($this);
    $placeholderLoginServlet = $this->loginServlet;
    $this->loginServlet = null;
    $placeholderLoginServlet->removeStand($this);
    $placeholderResultServlet = $this->resultServlet;
    $this->resultServlet = null;
    $placeholderResultServlet->removeStand($this);
    $placeholderRegistrerStandServlet = $this->registrerStandServlet;
    $this->registrerStandServlet = null;
    $placeholderRegistrerStandServlet->removeStand($this);
    $placeholderAdminServlet = $this->adminServlet;
    $this->adminServlet = null;
    $placeholderAdminServlet->removeStand($this);
  }

}




//%% NEW FILE Vote BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class Vote
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Vote Attributes
  private $id;
  private $userName;
  private $stand;
  private $score;

  //Vote Associations
  private $dbHandler;
  private $standServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId, $aUserName, $aStand, $aScore, $aDbHandler, $aStandServlet)
  {
    $this->id = $aId;
    $this->userName = $aUserName;
    $this->stand = $aStand;
    $this->score = $aScore;
    $didAddDbHandler = $this->setDbHandler($aDbHandler);
    if (!$didAddDbHandler)
    {
      throw new Exception("Unable to create vote due to dbHandler");
    }
    $didAddStandServlet = $this->setStandServlet($aStandServlet);
    if (!$didAddStandServlet)
    {
      throw new Exception("Unable to create vote due to standServlet");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function setUserName($aUserName)
  {
    $wasSet = false;
    $this->userName = $aUserName;
    $wasSet = true;
    return $wasSet;
  }

  public function setStand($aStand)
  {
    $wasSet = false;
    $this->stand = $aStand;
    $wasSet = true;
    return $wasSet;
  }

  public function setScore($aScore)
  {
    $wasSet = false;
    $this->score = $aScore;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getUserName()
  {
    return $this->userName;
  }

  public function getStand()
  {
    return $this->stand;
  }

  public function getScore()
  {
    return $this->score;
  }

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getStandServlet()
  {
    return $this->standServlet;
  }

  public function setDbHandler($aDbHandler)
  {
    $wasSet = false;
    if ($aDbHandler == null)
    {
      return $wasSet;
    }
    
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = $aDbHandler;
    if ($existingDbHandler != null && $existingDbHandler != $aDbHandler)
    {
      $existingDbHandler->removeVote($this);
    }
    $this->dbHandler->addVote($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setStandServlet($aStandServlet)
  {
    $wasSet = false;
    if ($aStandServlet == null)
    {
      return $wasSet;
    }
    
    $existingStandServlet = $this->standServlet;
    $this->standServlet = $aStandServlet;
    if ($existingStandServlet != null && $existingStandServlet != $aStandServlet)
    {
      $existingStandServlet->removeVote($this);
    }
    $this->standServlet->addVote($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    $placeholderDbHandler->removeVote($this);
    $placeholderStandServlet = $this->standServlet;
    $this->standServlet = null;
    $placeholderStandServlet->removeVote($this);
  }

}




//%% NEW FILE StandAdminServlet BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class StandAdminServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandAdminServlet Associations
  private $dbHandler;
  private $stands;
  private $loginUtil;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDbHandler = null, $aLoginUtil = null)
  {
    if (func_num_args() == 0) { return; }

    if ($aDbHandler == null || $aDbHandler->getStandAdminServlet() != null)
    {
      throw new Exception("Unable to create StandAdminServlet due to aDbHandler");
    }
    $this->dbHandler = $aDbHandler;
    $this->stands = array();
    if ($aLoginUtil == null || $aLoginUtil->getStandAdminServlet() != null)
    {
      throw new Exception("Unable to create StandAdminServlet due to aLoginUtil");
    }
    $this->loginUtil = $aLoginUtil;
  }
  public static function newInstance($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler, $aRegistrerStandServletForLoginUtil, $aLoginServletForLoginUtil, $aAdminServletForLoginUtil)
  {
    $thisInstance = new StandAdminServlet();
    $thisInstance->dbHandler = new DbHandler($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $thisInstance, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler);
    $this->stands = array();
    $thisInstance->loginUtil = new LoginUtil($thisInstance, $aRegistrerStandServletForLoginUtil, $aLoginServletForLoginUtil, $aAdminServletForLoginUtil);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getLoginUtil()
  {
    return $this->loginUtil;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $this, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingStandAdminServlet = $aStand->getStandAdminServlet();
    $isNewStandAdminServlet = $existingStandAdminServlet != null && $this !== $existingStandAdminServlet;
    if ($isNewStandAdminServlet)
    {
      $aStand->setStandAdminServlet($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a standAdminServlet
    if ($this !== $aStand->getStandAdminServlet())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    if ($existingDbHandler != null)
    {
      $existingDbHandler->delete();
    }
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
    $existingLoginUtil = $this->loginUtil;
    $this->loginUtil = null;
    if ($existingLoginUtil != null)
    {
      $existingLoginUtil->delete();
    }
  }

}




//%% NEW FILE AdminServlet BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class AdminServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AdminServlet Associations
  private $dbHandler;
  private $loginUtil;
  private $stands;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDbHandler = null, $aLoginUtil = null)
  {
    if (func_num_args() == 0) { return; }

    if ($aDbHandler == null || $aDbHandler->getAdminServlet() != null)
    {
      throw new Exception("Unable to create AdminServlet due to aDbHandler");
    }
    $this->dbHandler = $aDbHandler;
    if ($aLoginUtil == null || $aLoginUtil->getAdminServlet() != null)
    {
      throw new Exception("Unable to create AdminServlet due to aLoginUtil");
    }
    $this->loginUtil = $aLoginUtil;
    $this->stands = array();
  }
  public static function newInstance($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $aStandAdminServletForLoginUtil, $aRegistrerStandServletForLoginUtil, $aLoginServletForLoginUtil)
  {
    $thisInstance = new AdminServlet();
    $thisInstance->dbHandler = new DbHandler($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $thisInstance);
    $thisInstance->loginUtil = new LoginUtil($aStandAdminServletForLoginUtil, $aRegistrerStandServletForLoginUtil, $aLoginServletForLoginUtil, $thisInstance);
    $this->stands = array();
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getLoginUtil()
  {
    return $this->loginUtil;
  }

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $this);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingAdminServlet = $aStand->getAdminServlet();
    $isNewAdminServlet = $existingAdminServlet != null && $this !== $existingAdminServlet;
    if ($isNewAdminServlet)
    {
      $aStand->setAdminServlet($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a adminServlet
    if ($this !== $aStand->getAdminServlet())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    if ($existingDbHandler != null)
    {
      $existingDbHandler->delete();
    }
    $existingLoginUtil = $this->loginUtil;
    $this->loginUtil = null;
    if ($existingLoginUtil != null)
    {
      $existingLoginUtil->delete();
    }
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
  }

}




//%% NEW FILE LoginUtil BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class LoginUtil
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoginUtil Associations
  private $standAdminServlet;
  private $registrerStandServlet;
  private $loginServlet;
  private $adminServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aStandAdminServlet = null, $aRegistrerStandServlet = null, $aLoginServlet = null, $aAdminServlet = null)
  {
    if (func_num_args() == 0) { return; }

    if ($aStandAdminServlet == null || $aStandAdminServlet->getLoginUtil() != null)
    {
      throw new Exception("Unable to create LoginUtil due to aStandAdminServlet");
    }
    $this->standAdminServlet = $aStandAdminServlet;
    if ($aRegistrerStandServlet == null || $aRegistrerStandServlet->getLoginUtil() != null)
    {
      throw new Exception("Unable to create LoginUtil due to aRegistrerStandServlet");
    }
    $this->registrerStandServlet = $aRegistrerStandServlet;
    if ($aLoginServlet == null || $aLoginServlet->getLoginUtil() != null)
    {
      throw new Exception("Unable to create LoginUtil due to aLoginServlet");
    }
    $this->loginServlet = $aLoginServlet;
    if ($aAdminServlet == null || $aAdminServlet->getLoginUtil() != null)
    {
      throw new Exception("Unable to create LoginUtil due to aAdminServlet");
    }
    $this->adminServlet = $aAdminServlet;
  }
  public static function newInstance($aDbHandlerForStandAdminServlet, $aDbHandlerForRegistrerStandServlet, $aJavaEmailForRegistrerStandServlet, $aAdminUserForLoginServlet, $aAdminPassForLoginServlet, $aDbHandlerForLoginServlet, $aDbHandlerForAdminServlet)
  {
    $thisInstance = new LoginUtil();
    $thisInstance->standAdminServlet = new StandAdminServlet($aDbHandlerForStandAdminServlet, $thisInstance);
    $thisInstance->registrerStandServlet = new RegistrerStandServlet($aDbHandlerForRegistrerStandServlet, $thisInstance, $aJavaEmailForRegistrerStandServlet);
    $thisInstance->loginServlet = new LoginServlet($aAdminUserForLoginServlet, $aAdminPassForLoginServlet, $thisInstance, $aDbHandlerForLoginServlet);
    $thisInstance->adminServlet = new AdminServlet($aDbHandlerForAdminServlet, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStandAdminServlet()
  {
    return $this->standAdminServlet;
  }

  public function getRegistrerStandServlet()
  {
    return $this->registrerStandServlet;
  }

  public function getLoginServlet()
  {
    return $this->loginServlet;
  }

  public function getAdminServlet()
  {
    return $this->adminServlet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingStandAdminServlet = $this->standAdminServlet;
    $this->standAdminServlet = null;
    if ($existingStandAdminServlet != null)
    {
      $existingStandAdminServlet->delete();
    }
    $existingRegistrerStandServlet = $this->registrerStandServlet;
    $this->registrerStandServlet = null;
    if ($existingRegistrerStandServlet != null)
    {
      $existingRegistrerStandServlet->delete();
    }
    $existingLoginServlet = $this->loginServlet;
    $this->loginServlet = null;
    if ($existingLoginServlet != null)
    {
      $existingLoginServlet->delete();
    }
    $existingAdminServlet = $this->adminServlet;
    $this->adminServlet = null;
    if ($existingAdminServlet != null)
    {
      $existingAdminServlet->delete();
    }
  }

}




//%% NEW FILE JavaEmail BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class JavaEmail
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //JavaEmail Attributes
  private $mailSession;

  //JavaEmail Associations
  private $registrerStandServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aMailSession = null, $aRegistrerStandServlet = null)
  {
    if (func_num_args() == 0) { return; }

    $this->mailSession = $aMailSession;
    if ($aRegistrerStandServlet == null || $aRegistrerStandServlet->getJavaEmail() != null)
    {
      throw new Exception("Unable to create JavaEmail due to aRegistrerStandServlet");
    }
    $this->registrerStandServlet = $aRegistrerStandServlet;
  }
  public static function newInstance($aMailSession, $aDbHandlerForRegistrerStandServlet, $aLoginUtilForRegistrerStandServlet)
  {
    $thisInstance = new JavaEmail();
    $thisInstance->mailSession = $aMailSession;
    $thisInstance->registrerStandServlet = new RegistrerStandServlet($aDbHandlerForRegistrerStandServlet, $aLoginUtilForRegistrerStandServlet, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setMailSession($aMailSession)
  {
    $wasSet = false;
    $this->mailSession = $aMailSession;
    $wasSet = true;
    return $wasSet;
  }

  public function getMailSession()
  {
    return $this->mailSession;
  }

  public function getRegistrerStandServlet()
  {
    return $this->registrerStandServlet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingRegistrerStandServlet = $this->registrerStandServlet;
    $this->registrerStandServlet = null;
    if ($existingRegistrerStandServlet != null)
    {
      $existingRegistrerStandServlet->delete();
    }
  }

}




//%% NEW FILE ResultServlet BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class ResultServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ResultServlet Associations
  private $stands;
  private $dbHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDbHandler = null)
  {
    if (func_num_args() == 0) { return; }

    $this->stands = array();
    if ($aDbHandler == null || $aDbHandler->getResultServlet() != null)
    {
      throw new Exception("Unable to create ResultServlet due to aDbHandler");
    }
    $this->dbHandler = $aDbHandler;
  }
  public static function newInstance($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aAdminServletForDbHandler)
  {
    $thisInstance = new ResultServlet();
    $this->stands = array();
    $thisInstance->dbHandler = new DbHandler($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $thisInstance, $aAdminServletForDbHandler);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aRegistrerStandServlet, $aAdminServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $this, $aRegistrerStandServlet, $aAdminServlet);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingResultServlet = $aStand->getResultServlet();
    $isNewResultServlet = $existingResultServlet != null && $this !== $existingResultServlet;
    if ($isNewResultServlet)
    {
      $aStand->setResultServlet($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a resultServlet
    if ($this !== $aStand->getResultServlet())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    if ($existingDbHandler != null)
    {
      $existingDbHandler->delete();
    }
  }

}




//%% NEW FILE DbHandler BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class DbHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DbHandler Attributes
  private $url;
  private $user;
  private $password;

  //DbHandler Associations
  private $loginServlet;
  private $standAdminServlet;
  private $registrerStandServlet;
  private $standServlet;
  private $resultServlet;
  private $stands;
  private $standOverviews;
  private $votes;
  private $adminServlet;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aUrl = null, $aUser = null, $aPassword = null, $aLoginServlet = null, $aStandAdminServlet = null, $aRegistrerStandServlet = null, $aStandServlet = null, $aResultServlet = null, $aAdminServlet = null)
  {
    if (func_num_args() == 0) { return; }

    $this->url = $aUrl;
    $this->user = $aUser;
    $this->password = $aPassword;
    if ($aLoginServlet == null || $aLoginServlet->getDbHandler() != null)
    {
      throw new Exception("Unable to create DbHandler due to aLoginServlet");
    }
    $this->loginServlet = $aLoginServlet;
    if ($aStandAdminServlet == null || $aStandAdminServlet->getDbHandler() != null)
    {
      throw new Exception("Unable to create DbHandler due to aStandAdminServlet");
    }
    $this->standAdminServlet = $aStandAdminServlet;
    if ($aRegistrerStandServlet == null || $aRegistrerStandServlet->getDbHandler() != null)
    {
      throw new Exception("Unable to create DbHandler due to aRegistrerStandServlet");
    }
    $this->registrerStandServlet = $aRegistrerStandServlet;
    if ($aStandServlet == null || $aStandServlet->getDbHandler() != null)
    {
      throw new Exception("Unable to create DbHandler due to aStandServlet");
    }
    $this->standServlet = $aStandServlet;
    if ($aResultServlet == null || $aResultServlet->getDbHandler() != null)
    {
      throw new Exception("Unable to create DbHandler due to aResultServlet");
    }
    $this->resultServlet = $aResultServlet;
    $this->stands = array();
    $this->standOverviews = array();
    $this->votes = array();
    if ($aAdminServlet == null || $aAdminServlet->getDbHandler() != null)
    {
      throw new Exception("Unable to create DbHandler due to aAdminServlet");
    }
    $this->adminServlet = $aAdminServlet;
  }
  public static function newInstance($aUrl, $aUser, $aPassword, $aAdminUserForLoginServlet, $aAdminPassForLoginServlet, $aLoginUtilForLoginServlet, $aLoginUtilForStandAdminServlet, $aLoginUtilForRegistrerStandServlet, $aJavaEmailForRegistrerStandServlet, $aLoginUtilForAdminServlet)
  {
    $thisInstance = new DbHandler();
    $thisInstance->url = $aUrl;
    $thisInstance->user = $aUser;
    $thisInstance->password = $aPassword;
    $thisInstance->loginServlet = new LoginServlet($aAdminUserForLoginServlet, $aAdminPassForLoginServlet, $aLoginUtilForLoginServlet, $thisInstance);
    $thisInstance->standAdminServlet = new StandAdminServlet($thisInstance, $aLoginUtilForStandAdminServlet);
    $thisInstance->registrerStandServlet = new RegistrerStandServlet($thisInstance, $aLoginUtilForRegistrerStandServlet, $aJavaEmailForRegistrerStandServlet);
    $thisInstance->standServlet = new StandServlet($thisInstance);
    $thisInstance->resultServlet = new ResultServlet($thisInstance);
    $this->stands = array();
    $this->standOverviews = array();
    $this->votes = array();
    $thisInstance->adminServlet = new AdminServlet($thisInstance, $aLoginUtilForAdminServlet);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setUrl($aUrl)
  {
    $wasSet = false;
    $this->url = $aUrl;
    $wasSet = true;
    return $wasSet;
  }

  public function setUser($aUser)
  {
    $wasSet = false;
    $this->user = $aUser;
    $wasSet = true;
    return $wasSet;
  }

  public function setPassword($aPassword)
  {
    $wasSet = false;
    $this->password = $aPassword;
    $wasSet = true;
    return $wasSet;
  }

  public function getUrl()
  {
    return $this->url;
  }

  public function getUser()
  {
    return $this->user;
  }

  public function getPassword()
  {
    return $this->password;
  }

  public function getLoginServlet()
  {
    return $this->loginServlet;
  }

  public function getStandAdminServlet()
  {
    return $this->standAdminServlet;
  }

  public function getRegistrerStandServlet()
  {
    return $this->registrerStandServlet;
  }

  public function getStandServlet()
  {
    return $this->standServlet;
  }

  public function getResultServlet()
  {
    return $this->resultServlet;
  }

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getStandOverview_index($index)
  {
    $aStandOverview = $this->standOverviews[$index];
    return $aStandOverview;
  }

  public function getStandOverviews()
  {
    $newStandOverviews = $this->standOverviews;
    return $newStandOverviews;
  }

  public function numberOfStandOverviews()
  {
    $number = count($this->standOverviews);
    return $number;
  }

  public function hasStandOverviews()
  {
    $has = $this->numberOfStandOverviews() > 0;
    return $has;
  }

  public function indexOfStandOverview($aStandOverview)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->standOverviews as $standOverview)
    {
      if ($standOverview->equals($aStandOverview))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getVote_index($index)
  {
    $aVote = $this->votes[$index];
    return $aVote;
  }

  public function getVotes()
  {
    $newVotes = $this->votes;
    return $newVotes;
  }

  public function numberOfVotes()
  {
    $number = count($this->votes);
    return $number;
  }

  public function hasVotes()
  {
    $has = $this->numberOfVotes() > 0;
    return $has;
  }

  public function indexOfVote($aVote)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->votes as $vote)
    {
      if ($vote->equals($aVote))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getAdminServlet()
  {
    return $this->adminServlet;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $this, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingDbHandler = $aStand->getDbHandler();
    $isNewDbHandler = $existingDbHandler != null && $this !== $existingDbHandler;
    if ($isNewDbHandler)
    {
      $aStand->setDbHandler($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a dbHandler
    if ($this !== $aStand->getDbHandler())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfStandOverviews()
  {
    return 0;
  }

  public function addStandOverviewVia($aStand)
  {
    return new StandOverview($this, $aStand);
  }

  public function addStandOverview($aStandOverview)
  {
    $wasAdded = false;
    if ($this->indexOfStandOverview($aStandOverview) !== -1) { return false; }
    $existingDbHandler = $aStandOverview->getDbHandler();
    $isNewDbHandler = $existingDbHandler != null && $this !== $existingDbHandler;
    if ($isNewDbHandler)
    {
      $aStandOverview->setDbHandler($this);
    }
    else
    {
      $this->standOverviews[] = $aStandOverview;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStandOverview($aStandOverview)
  {
    $wasRemoved = false;
    //Unable to remove aStandOverview, as it must always have a dbHandler
    if ($this !== $aStandOverview->getDbHandler())
    {
      unset($this->standOverviews[$this->indexOfStandOverview($aStandOverview)]);
      $this->standOverviews = array_values($this->standOverviews);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandOverviewAt($aStandOverview, $index)
  {  
    $wasAdded = false;
    if($this->addStandOverview($aStandOverview))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStandOverviews()) { $index = $this->numberOfStandOverviews() - 1; }
      array_splice($this->standOverviews, $this->indexOfStandOverview($aStandOverview), 1);
      array_splice($this->standOverviews, $index, 0, array($aStandOverview));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandOverviewAt($aStandOverview, $index)
  {
    $wasAdded = false;
    if($this->indexOfStandOverview($aStandOverview) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStandOverviews()) { $index = $this->numberOfStandOverviews() - 1; }
      array_splice($this->standOverviews, $this->indexOfStandOverview($aStandOverview), 1);
      array_splice($this->standOverviews, $index, 0, array($aStandOverview));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandOverviewAt($aStandOverview, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfVotes()
  {
    return 0;
  }

  public function addVoteVia($aId, $aUserName, $aStand, $aScore, $aStandServlet)
  {
    return new Vote($aId, $aUserName, $aStand, $aScore, $this, $aStandServlet);
  }

  public function addVote($aVote)
  {
    $wasAdded = false;
    if ($this->indexOfVote($aVote) !== -1) { return false; }
    $existingDbHandler = $aVote->getDbHandler();
    $isNewDbHandler = $existingDbHandler != null && $this !== $existingDbHandler;
    if ($isNewDbHandler)
    {
      $aVote->setDbHandler($this);
    }
    else
    {
      $this->votes[] = $aVote;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeVote($aVote)
  {
    $wasRemoved = false;
    //Unable to remove aVote, as it must always have a dbHandler
    if ($this !== $aVote->getDbHandler())
    {
      unset($this->votes[$this->indexOfVote($aVote)]);
      $this->votes = array_values($this->votes);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addVoteAt($aVote, $index)
  {  
    $wasAdded = false;
    if($this->addVote($aVote))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfVotes()) { $index = $this->numberOfVotes() - 1; }
      array_splice($this->votes, $this->indexOfVote($aVote), 1);
      array_splice($this->votes, $index, 0, array($aVote));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveVoteAt($aVote, $index)
  {
    $wasAdded = false;
    if($this->indexOfVote($aVote) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfVotes()) { $index = $this->numberOfVotes() - 1; }
      array_splice($this->votes, $this->indexOfVote($aVote), 1);
      array_splice($this->votes, $index, 0, array($aVote));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addVoteAt($aVote, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingLoginServlet = $this->loginServlet;
    $this->loginServlet = null;
    if ($existingLoginServlet != null)
    {
      $existingLoginServlet->delete();
    }
    $existingStandAdminServlet = $this->standAdminServlet;
    $this->standAdminServlet = null;
    if ($existingStandAdminServlet != null)
    {
      $existingStandAdminServlet->delete();
    }
    $existingRegistrerStandServlet = $this->registrerStandServlet;
    $this->registrerStandServlet = null;
    if ($existingRegistrerStandServlet != null)
    {
      $existingRegistrerStandServlet->delete();
    }
    $existingStandServlet = $this->standServlet;
    $this->standServlet = null;
    if ($existingStandServlet != null)
    {
      $existingStandServlet->delete();
    }
    $existingResultServlet = $this->resultServlet;
    $this->resultServlet = null;
    if ($existingResultServlet != null)
    {
      $existingResultServlet->delete();
    }
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
    foreach ($this->standOverviews as $aStandOverview)
    {
      $aStandOverview->delete();
    }
    foreach ($this->votes as $aVote)
    {
      $aVote->delete();
    }
    $existingAdminServlet = $this->adminServlet;
    $this->adminServlet = null;
    if ($existingAdminServlet != null)
    {
      $existingAdminServlet->delete();
    }
  }

}




//%% NEW FILE StandServlet BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class StandServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandServlet Associations
  private $votes;
  private $dbHandler;
  private $stands;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDbHandler = null)
  {
    if (func_num_args() == 0) { return; }

    $this->votes = array();
    if ($aDbHandler == null || $aDbHandler->getStandServlet() != null)
    {
      throw new Exception("Unable to create StandServlet due to aDbHandler");
    }
    $this->dbHandler = $aDbHandler;
    $this->stands = array();
  }
  public static function newInstance($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler)
  {
    $thisInstance = new StandServlet();
    $this->votes = array();
    $thisInstance->dbHandler = new DbHandler($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aLoginServletForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $thisInstance, $aResultServletForDbHandler, $aAdminServletForDbHandler);
    $this->stands = array();
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getVote_index($index)
  {
    $aVote = $this->votes[$index];
    return $aVote;
  }

  public function getVotes()
  {
    $newVotes = $this->votes;
    return $newVotes;
  }

  public function numberOfVotes()
  {
    $number = count($this->votes);
    return $number;
  }

  public function hasVotes()
  {
    $has = $this->numberOfVotes() > 0;
    return $has;
  }

  public function indexOfVote($aVote)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->votes as $vote)
    {
      if ($vote->equals($aVote))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfVotes()
  {
    return 0;
  }

  public function addVoteVia($aId, $aUserName, $aStand, $aScore, $aDbHandler)
  {
    return new Vote($aId, $aUserName, $aStand, $aScore, $aDbHandler, $this);
  }

  public function addVote($aVote)
  {
    $wasAdded = false;
    if ($this->indexOfVote($aVote) !== -1) { return false; }
    $existingStandServlet = $aVote->getStandServlet();
    $isNewStandServlet = $existingStandServlet != null && $this !== $existingStandServlet;
    if ($isNewStandServlet)
    {
      $aVote->setStandServlet($this);
    }
    else
    {
      $this->votes[] = $aVote;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeVote($aVote)
  {
    $wasRemoved = false;
    //Unable to remove aVote, as it must always have a standServlet
    if ($this !== $aVote->getStandServlet())
    {
      unset($this->votes[$this->indexOfVote($aVote)]);
      $this->votes = array_values($this->votes);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addVoteAt($aVote, $index)
  {  
    $wasAdded = false;
    if($this->addVote($aVote))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfVotes()) { $index = $this->numberOfVotes() - 1; }
      array_splice($this->votes, $this->indexOfVote($aVote), 1);
      array_splice($this->votes, $index, 0, array($aVote));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveVoteAt($aVote, $index)
  {
    $wasAdded = false;
    if($this->indexOfVote($aVote) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfVotes()) { $index = $this->numberOfVotes() - 1; }
      array_splice($this->votes, $this->indexOfVote($aVote), 1);
      array_splice($this->votes, $index, 0, array($aVote));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addVoteAt($aVote, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $this, $aStandOverview, $aDbHandler, $aLoginServlet, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingStandServlet = $aStand->getStandServlet();
    $isNewStandServlet = $existingStandServlet != null && $this !== $existingStandServlet;
    if ($isNewStandServlet)
    {
      $aStand->setStandServlet($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a standServlet
    if ($this !== $aStand->getStandServlet())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->votes as $aVote)
    {
      $aVote->delete();
    }
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    if ($existingDbHandler != null)
    {
      $existingDbHandler->delete();
    }
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
  }

}




//%% NEW FILE LoginServlet BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class LoginServlet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoginServlet Attributes
  private $adminUser;
  private $adminPass;

  //LoginServlet Associations
  private $loginUtil;
  private $stands;
  private $dbHandler;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aAdminUser = null, $aAdminPass = null, $aLoginUtil = null, $aDbHandler = null)
  {
    if (func_num_args() == 0) { return; }

    $this->adminUser = $aAdminUser;
    $this->adminPass = $aAdminPass;
    if ($aLoginUtil == null || $aLoginUtil->getLoginServlet() != null)
    {
      throw new Exception("Unable to create LoginServlet due to aLoginUtil");
    }
    $this->loginUtil = $aLoginUtil;
    $this->stands = array();
    if ($aDbHandler == null || $aDbHandler->getLoginServlet() != null)
    {
      throw new Exception("Unable to create LoginServlet due to aDbHandler");
    }
    $this->dbHandler = $aDbHandler;
  }
  public static function newInstance($aAdminUser, $aAdminPass, $aStandAdminServletForLoginUtil, $aRegistrerStandServletForLoginUtil, $aAdminServletForLoginUtil, $aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler)
  {
    $thisInstance = new LoginServlet();
    $thisInstance->adminUser = $aAdminUser;
    $thisInstance->adminPass = $aAdminPass;
    $thisInstance->loginUtil = new LoginUtil($aStandAdminServletForLoginUtil, $aRegistrerStandServletForLoginUtil, $thisInstance, $aAdminServletForLoginUtil);
    $this->stands = array();
    $thisInstance->dbHandler = new DbHandler($aUrlForDbHandler, $aUserForDbHandler, $aPasswordForDbHandler, $thisInstance, $aStandAdminServletForDbHandler, $aRegistrerStandServletForDbHandler, $aStandServletForDbHandler, $aResultServletForDbHandler, $aAdminServletForDbHandler);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setAdminUser($aAdminUser)
  {
    $wasSet = false;
    $this->adminUser = $aAdminUser;
    $wasSet = true;
    return $wasSet;
  }

  public function setAdminPass($aAdminPass)
  {
    $wasSet = false;
    $this->adminPass = $aAdminPass;
    $wasSet = true;
    return $wasSet;
  }

  public function getAdminUser()
  {
    return $this->adminUser;
  }

  public function getAdminPass()
  {
    return $this->adminPass;
  }

  public function getLoginUtil()
  {
    return $this->loginUtil;
  }

  public function getStand_index($index)
  {
    $aStand = $this->stands[$index];
    return $aStand;
  }

  public function getStands()
  {
    $newStands = $this->stands;
    return $newStands;
  }

  public function numberOfStands()
  {
    $number = count($this->stands);
    return $number;
  }

  public function hasStands()
  {
    $has = $this->numberOfStands() > 0;
    return $has;
  }

  public function indexOfStand($aStand)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stands as $stand)
    {
      if ($stand->equals($aStand))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getDbHandler()
  {
    return $this->dbHandler;
  }

  public static function minimumNumberOfStands()
  {
    return 0;
  }

  public function addStandVia($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet)
  {
    return new Stand($aId, $aName, $aImageUrl, $aEpostadmin, $aPin, $aStandAdminServlet, $aStandServlet, $aStandOverview, $aDbHandler, $this, $aResultServlet, $aRegistrerStandServlet, $aAdminServlet);
  }

  public function addStand($aStand)
  {
    $wasAdded = false;
    if ($this->indexOfStand($aStand) !== -1) { return false; }
    $existingLoginServlet = $aStand->getLoginServlet();
    $isNewLoginServlet = $existingLoginServlet != null && $this !== $existingLoginServlet;
    if ($isNewLoginServlet)
    {
      $aStand->setLoginServlet($this);
    }
    else
    {
      $this->stands[] = $aStand;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStand($aStand)
  {
    $wasRemoved = false;
    //Unable to remove aStand, as it must always have a loginServlet
    if ($this !== $aStand->getLoginServlet())
    {
      unset($this->stands[$this->indexOfStand($aStand)]);
      $this->stands = array_values($this->stands);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStandAt($aStand, $index)
  {  
    $wasAdded = false;
    if($this->addStand($aStand))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStandAt($aStand, $index)
  {
    $wasAdded = false;
    if($this->indexOfStand($aStand) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStands()) { $index = $this->numberOfStands() - 1; }
      array_splice($this->stands, $this->indexOfStand($aStand), 1);
      array_splice($this->stands, $index, 0, array($aStand));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStandAt($aStand, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingLoginUtil = $this->loginUtil;
    $this->loginUtil = null;
    if ($existingLoginUtil != null)
    {
      $existingLoginUtil->delete();
    }
    foreach ($this->stands as $aStand)
    {
      $aStand->delete();
    }
    $existingDbHandler = $this->dbHandler;
    $this->dbHandler = null;
    if ($existingDbHandler != null)
    {
      $existingDbHandler->delete();
    }
  }

}

