//%% NEW FILE VotingSystem BEGINS HERE %%


/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/

class VotingSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VotingSystem State Machines
  private static $StateScanQRCode = 1;
  private static $StateFindStand = 2;
  private static $StateError = 3;
  private static $StateFindUser = 4;
  private static $StateUserExists = 5;
  private static $StateNewUser = 6;
  private static $StateLogin = 7;
  private static $StateFindVote = 8;
  private static $StateNewVote = 9;
  private static $StateUpdateVote = 10;
  private static $StateResultPage = 11;
  private $state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->setState(self::$StateScanQRCode);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getStateFullName()
  {
    $answer = $this->getState();
    return $answer;
  }

  public function getState()
  {
    if ($this->state == self::$StateScanQRCode) { return "StateScanQRCode"; }
    elseif ($this->state == self::$StateFindStand) { return "StateFindStand"; }
    elseif ($this->state == self::$StateError) { return "StateError"; }
    elseif ($this->state == self::$StateFindUser) { return "StateFindUser"; }
    elseif ($this->state == self::$StateUserExists) { return "StateUserExists"; }
    elseif ($this->state == self::$StateNewUser) { return "StateNewUser"; }
    elseif ($this->state == self::$StateLogin) { return "StateLogin"; }
    elseif ($this->state == self::$StateFindVote) { return "StateFindVote"; }
    elseif ($this->state == self::$StateNewVote) { return "StateNewVote"; }
    elseif ($this->state == self::$StateUpdateVote) { return "StateUpdateVote"; }
    elseif ($this->state == self::$StateResultPage) { return "StateResultPage"; }
    return null;
  }

  private function __autotransition52__()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateScanQRCode)
    {
      $this->setState(self::$StateFindStand);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function found()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateFindStand)
    {
      $this->setState(self::$StateFindUser);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateFindUser)
    {
      $this->setState(self::$StateUserExists);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateFindVote)
    {
      $this->setState(self::$StateUpdateVote);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function notFound()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateFindStand)
    {
      $this->setState(self::$StateError);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateFindUser)
    {
      $this->setState(self::$StateNewUser);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateFindVote)
    {
      $this->setState(self::$StateNewVote);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function loggedIn()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateUserExists)
    {
      $this->setState(self::$StateFindVote);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function notLoggedIn()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateUserExists)
    {
      $this->setState(self::$StateLogin);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function sendPin()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateNewUser)
    {
      $this->setState(self::$StateLogin);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function correctPin()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateLogin)
    {
      $this->setState(self::$StateNewVote);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function wrongPin()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateLogin)
    {
      $this->setState(self::$StateLogin);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  public function findTotalScore()
  {
    $wasEventProcessed = false;
    
    $aState = $this->state;
    if ($aState == self::$StateNewVote)
    {
      $this->setState(self::$StateResultPage);
      $wasEventProcessed = true;
    }
    elseif ($aState == self::$StateUpdateVote)
    {
      $this->setState(self::$StateResultPage);
      $wasEventProcessed = true;
    }
    return $wasEventProcessed;
  }

  private function setState($aState)
  {
    $this->state = $aState;

    // entry actions and do activities
    if ($this->state == self::$StateScanQRCode)
    {
      $this->__autotransition52__();
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}

