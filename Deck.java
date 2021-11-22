//Ali Woodward
//2385718
//alwoodward@chapman.edu
//CPSC 231-02
//MP3: Crazy Eights

import java.util.LinkedList;
import java.util.Random;

public class Deck{

  public LinkedList<Card> fullDeck = new LinkedList<Card>();

  public Deck(){

    for(int i = 1; i <= 4; i++){
      for(int n = 1; n <= 13; n++){
        if(i == 1){
          fullDeck.add(new Card(n, "Clubs"));
        }else if(i == 2){
          fullDeck.add(new Card(n, "Diamonds"));
        }else if(i == 3){
          fullDeck.add(new Card(n, "Hearts"));
        }else{
          fullDeck.add(new Card(n, "Spades"));
        }
      }
    }
  }

  public Card deal(){
    int randomCard = new Random().nextInt(fullDeck.size());
    Card dealtCard = fullDeck.get(randomCard);
    fullDeck.remove(dealtCard);
    return dealtCard;
  }

  public String toString(){
    return "full deck of cards:\n" + fullDeck + "\nSize of deck: " + fullDeck.size();
  }

  public int getDeckSize(){
    return fullDeck.size();

  }

}
