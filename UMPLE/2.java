//%% NEW FILE VotingSystem BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!*/



// line 2 "model.ump"
public class VotingSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VotingSystem State Machines
  public enum State { scanQRCode, findStand, Error, findUser, userExists, newUser, login, findVote, newVote, updateVote, resultPage }
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VotingSystem()
  {
    setState(State.scanQRCode);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  private boolean __autotransition53__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case scanQRCode:
        setState(State.findStand);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean found()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case findStand:
        setState(State.findUser);
        wasEventProcessed = true;
        break;
      case findUser:
        setState(State.userExists);
        wasEventProcessed = true;
        break;
      case findVote:
        setState(State.updateVote);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean notFound()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case findStand:
        setState(State.Error);
        wasEventProcessed = true;
        break;
      case findUser:
        setState(State.newUser);
        wasEventProcessed = true;
        break;
      case findVote:
        setState(State.newVote);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean loggedIn()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case userExists:
        setState(State.findVote);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean notLoggedIn()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case userExists:
        setState(State.login);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean sendPin()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case newUser:
        setState(State.login);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean correctPin()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case login:
        setState(State.newVote);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean wrongPin()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case login:
        setState(State.login);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean findTotalScore()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case newVote:
        setState(State.resultPage);
        wasEventProcessed = true;
        break;
      case updateVote:
        setState(State.resultPage);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case scanQRCode:
        __autotransition53__();
        break;
    }
  }

  public void delete()
  {}

}
