//Nikolaos Sageorgis 
public class ComputerPlayer
{
  private int pairsCounter;
  private int score = 0;	
  private int[] showedCardsArray;

  public ComputerPlayer(int pairsCounter)
  {
	showedCardsArray = new int[pairsCounter];
	this.pairsCounter = pairsCounter;
	
	for (int i=0;i<pairsCounter;i++)
	{
		showedCardsArray[i]=0;
	}
  }

  public int getScore()
  {
	  return this.score;
  }
  
  public void play(Board myBoard)
  {
	int position1=myBoard.getRandomPosition();
	int position=myBoard.getCard(position1);
	boolean validCard;
	int position2;
	
	if (showedCardsArray[position]!=0)
	{
		validCard=myBoard.checkPositions(position1, showedCardsArray[position]);
		if (validCard==true)
		{
			score=score+1;
        }
        System.out.print("Opponent score: "+score+"\n");
	}
	else
	{
		position2=myBoard.getRandomPosition();
		validCard=myBoard.checkPositions(position1, position2);
		if(validCard==true)
		{
			score=score+1;
        }
        System.out.print("Opponent score: "+score+"\n");
	}
	myBoard.print();
  }
}
