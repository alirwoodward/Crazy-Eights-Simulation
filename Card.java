//Ali Woodward
//2385718
//alwoodward@chapman.edu
//CPSC 231-02
//MP3: Crazy Eights

public class Card{
  private String m_suit;
  private String m_value;
  private String[] cardValues = {"null", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

  public Card(int value){
    m_value = cardValues[value];
    m_suit = null;
  }

  public Card(int value, String suit){
    m_value = cardValues[value];
    m_suit = suit;
  }

  public String getSuit()
  {
    return m_suit;
  }

  public void changeSuit(String newSuit){
    m_suit = newSuit;
  }

  public String getValue(){
    return m_value;
  }

  public String toString(){
    return(m_value + " of " + m_suit);
  }

  public boolean equals(Card topCard){
    return ((m_value == topCard.m_value || m_suit == topCard.m_suit) && (m_value != "8"));
  }

  public boolean isAnEight(){
    return (m_value == "8");
  }

}
