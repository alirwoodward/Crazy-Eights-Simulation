//Ali Woodward
//2385718
//alwoodward@chapman.edu
//CPSC 231-02
//MP3: Crazy Eights

import java.util.LinkedList;
import java.util.Random;

public class Player{

  private int m_playerID;
  private Deck m_currStock;
  LinkedList<Card> ownedCards = new LinkedList<Card>();
  public int m_eightCount;

//creates a player!
  public Player(int playerID, Deck stock){
    m_playerID = playerID;
    m_currStock = stock;
    for(int c = 0; c<5; c++){
      ownedCards.add(m_currStock.deal());
    }
  }

//returns a players ID
  public int getPlayerID(){
    return m_playerID;
  }

  public String toString(){
    return "Player " + m_playerID;
  }

//this method finds and returns an appropriate playable card

  public Card takeTurn(Card currentCard){

    //10% chance to play an eight if they have one

    for(int o = 0; o < ownedCards.size(); o++){
      Card findEight = ownedCards.get(o);
      if(findEight.getValue() == "8"){
        int randomNum = new Random().nextInt(10);
        if(randomNum == 8){
          ownedCards.remove(findEight);
          return newSuit(findEight);
        }
      }
    }


    //finds a playable card and returns it if they have one

    for(int h = 0; h < ownedCards.size(); h++){
      Card cardInHand = ownedCards.get(h);
      if(cardInHand.equals(currentCard)){
        ownedCards.remove(cardInHand);
        return cardInHand;
      }
    }

    //plays an eight if they have one and do not have another valid card

    for(int x = 0; x < ownedCards.size(); x++){
      Card current = ownedCards.get(x);
      if(current.getValue() == "8"){
        ownedCards.remove(current);
        return newSuit(current);
      }

    }

    //no playable card: draws a new card and runs the entire method again
    if(m_currStock.getDeckSize() > 0){
      ownedCards.add(m_currStock.deal());
      return takeTurn(currentCard);
    }else{
      return null;
    }
  }

//returns the size of the players hand
  public int playerHandSize(){
    return ownedCards.size();
  }

//returns the size of the stock
  public int stockSize(){
    return m_currStock.getDeckSize();
  }

  public LinkedList<Card> playerHand(){
    return ownedCards;
  }

//changes the suit of eights at random
  public Card newSuit(Card eightToPlay){
    int randomSuit = new Random().nextInt(4);
    if(randomSuit == 0){
      eightToPlay.changeSuit("Clubs");
    }else if(randomSuit == 1){
      eightToPlay.changeSuit("Diamonds");
    }else if(randomSuit == 2){
      eightToPlay.changeSuit("Hearts");
    }else{
      eightToPlay.changeSuit("Spades");
    }

    m_eightCount++;
    return eightToPlay;
  }

  //keeps track of number of eights played
  public int getNumEights(){
    return m_eightCount;
  }
}
