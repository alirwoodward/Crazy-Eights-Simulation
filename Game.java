//Ali Woodward
//2385718
//alwoodward@chapman.edu
//CPSC 231-02
//MP3: Crazy Eights

import java.util.LinkedList;

public class Game{
    public Player player1;
    public Player player2;
    public Deck stock;
    public LinkedList<Card> playedPile;
    public Card topCard;
    public boolean cantPlay1;
    public boolean cantPlay2;
    public boolean gameOver = false;
    public Player winner;
    public int player1points = 0;
    public int player2points = 0;

    public Game(){
      stock = new Deck();
      player1 = new Player(1, stock);
      player2 = new Player(2, stock);
      playedPile = new LinkedList<Card>();
      topCard = stock.deal();
      playedPile.add(topCard);
    }

    public Player getPlayer(int ID){
      if(ID ==1){
        return player1;
      }else{
        return player2;
      }
    }

    public Deck getDeck(){
      return stock;
    }

    public Card getTopCard(){
      return topCard;
    }

    public void setTopCard(Card playedCard){
      topCard = playedCard;
    }

    public String play(){
      Card player1Play;
      Card player2Play;


      while(gameOver == false){

        cantPlay1 = false;
        cantPlay2 = false;

        //System.out.println("TOP CARD: " + topCard);
        player1Play = player1.takeTurn(topCard);
        if(player1Play == null){
          cantPlay1 = true;
        }else{
          setTopCard(player1Play);
        }
        //System.out.println("TOP CARD: " + topCard);

        if(player1.playerHandSize() == 0){
          winner = player1;
          gameOver();
          break;
          //return "The winner is " + winner;
        }

        player2Play = player2.takeTurn(topCard);
        if(player2Play == null){
          cantPlay2 = true;
        }else{
          setTopCard(player2Play);
        }

        if(player2.playerHandSize() == 0){
          winner = player2;
          gameOver();
          break;
          //return "The winner is " + winner;
        }

        if(cantPlay1 && cantPlay2){
          gameOver();
          if(player2.playerHandSize() > player1.playerHandSize()){
            winner = player1;
          }else if(player1.playerHandSize() > player2.playerHandSize()){
            winner = player2;
          }else{
            winner = null;
          }
        }
      }

      if(winner == null){
        return "The winner is nobody";
      }else{
        return "The winner is " + winner;
      }
    }

    public boolean gameOver(){
      gameOver = true;
      return gameOver;
    }

    public Player getWinner(){
      return winner;
    }

    public Player getLoser(){
      if(player1 == winner){
        return player2;
      }else if (player2 == winner){
        return player1;
      }else{
        return null;
      }
    }

    public int getPoints(int player){
      LinkedList<Card> cardsLeftPlayer1 = player1.playerHand();
      LinkedList<Card> cardsLeftPlayer2 = player2.playerHand();

      if(player == 1){
        for(int i = 0; i < cardsLeftPlayer2.size(); i++)
        {
          Card currCard = cardsLeftPlayer2.get(i);
          player1points += cardPoint(currCard);
        }
      return player1points;
      }else{
        for(int i = 0; i < cardsLeftPlayer1.size(); i++)
        {
          player2points += cardPoint(cardsLeftPlayer1.get(i));
        }
        return player2points;
      }
    }

    public int cardPoint(Card currentCard){
      String cardVal = currentCard.getValue();
      switch( cardVal ){
        case "Ace":
          return 1;
        case "2":
          return 2;
        case "3":
          return 3;
        case "4":
          return 4;
        case "5":
          return 5;
        case "6":
          return 6;
        case "7":
          return 7;
        case "8":
          return 50;
        case "9":
          return 9;
        case "10":
          return 10;
        case "Jack":
          return 10;
        case "Queen":
          return 10;
        case "King":
          return 10;
        default:
          return 0;

      }

    }

    public boolean stockEmpty(){
      if(stock.getDeckSize() > 0)
      {
        return false;
      }else{
        return true;
      }
    }

    public int numEightsPlayed(){
      return player1.getNumEights() + player2.getNumEights();
    }
}
