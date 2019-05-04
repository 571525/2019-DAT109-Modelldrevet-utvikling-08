//%% NEW FILE VotingSystem BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4450.6749b7105 modeling language!



CREATE TABLE IF NOT EXISTS `voting_system`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*VotingSystem State Machines*/
  state ENUM('scan_qr_code', 'find_stand', 'error', 'find_user', 'user_exists', 'new_user', 'login', 'find_vote', 'new_vote', 'update_vote', 'result_page'),
  PRIMARY KEY(state)

);
