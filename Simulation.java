//Ali Woodward
//2385718
//alwoodward@chapman.edu
//CPSC 231-02
//MP3: Crazy Eights

public class Simulation{

  public static int m_player1Won = 0;
  public static int m_player2Won = 0;
  private static int m_player1Points = 0;
  private static int m_player2Points = 0;
  private static int m_TotalCardsLeft = 0;
  private static int stockEmptyNum = 0;
  private static int eightsPlayed = 0;
  private static int m_numOfGames;
  private Player winner;

  //main method
  public static void main (String[] args){

    m_numOfGames = Integer.parseInt(args[0]);
    simulate(m_numOfGames);
  }

  //simulates the correct number of games being played
  public static String simulate(int numGames){
    if(numGames > 0){
      Game game = new Game();
      numGames = numGames-1;
      game.play();
      calculate(game.getWinner(), game);
      return "Next game" + simulate(numGames);
    }else{
      report(m_numOfGames, m_player1Won, m_player2Won, m_player1Points, m_player2Points, m_TotalCardsLeft, stockEmptyNum, eightsPlayed);
      return "DONE";

    }
  }

//calculates statistics of each game and as a whole
  public static void calculate(Player winner, Game currentGame){
    Player p1 = currentGame.getPlayer(1);
    Player p2 = currentGame.getPlayer(2);

    if(winner == null){
      m_player1Points += currentGame.getPoints(p1.getPlayerID());
      m_player2Points += currentGame.getPoints(p2.getPlayerID());
      m_TotalCardsLeft += p1.playerHand().size();
      m_TotalCardsLeft += p2.playerHand().size();
    }else{
      if(winner.getPlayerID() == 1){
        m_player1Won ++;
        m_player1Points += currentGame.getPoints(winner.getPlayerID());
        m_TotalCardsLeft += p2.playerHand().size();
      }
      if (winner.getPlayerID() == 2){
        m_player2Won ++;
        m_player2Points += currentGame.getPoints(winner.getPlayerID());
        m_TotalCardsLeft += p1.playerHand().size();
      }
    }
    if(currentGame.stockEmpty()){
      stockEmptyNum++;
    }

    eightsPlayed += currentGame.numEightsPlayed();
  }

//prints the report of all total statistics
  public static void report(int numberGames, int p1Wins, int p2Wins, int p1Points, int p2Points, int numLoserCards, int stockEmptied, int numEights){
    System.out.println("A total of " + numberGames + " games of Crazy Eights was just played by this program.\nIn these games:");
    System.out.println("\nPlayer 1 won a total of " + p1Wins + " games.");
    System.out.println("Player 2 won a total of " + p2Wins + " games.");
    System.out.println("\nPlayer 1 collected a total of " + p1Points + " points.");
    System.out.println("Player 2 collected a total of " + p2Points + " points.");
    System.out.println("\nThe average number of cards held by the losing player was " + numLoserCards/numberGames);
    System.out.println("\nThe stock became empty " + stockEmptied + " times.");
    System.out.println("\nAnd an Eight was played as a wild card in each game an average of " + numEights/numberGames + " times.");
    System.out.println("\nThank you for playing Crazy Eights!!");
  }

}
