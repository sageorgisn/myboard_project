//Nikolaos Sageorgis 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HumanPlayer
{
  private int pairsCounter;
  private int score = 0;

  public HumanPlayer(int pairsCounter)
  {
	this.pairsCounter=pairsCounter;
  }

  public int getScore()
  {
	  return this.score;
  }
  
  public void play(Board myBoard) throws IOException
  {
	int firstTry;
	int secondTry;
	BufferedReader readFromTerminal = new BufferedReader(new InputStreamReader(System.in));
	boolean validity;
	
	System.out.print("Insert first card:");
    String first=readFromTerminal.readLine();
	System.out.print("Insert second card:");
    String second=readFromTerminal.readLine();
    firstTry=Integer.parseInt(first);
    secondTry=Integer.parseInt(second);
    validity=myBoard.checkPositions(firstTry, secondTry);
    System.out.print("The table after your try is:\n");
    myBoard.print(firstTry, secondTry);
    System.out.print("\nThe table is:\n");
	myBoard.print();
    if(validity==true)
    {
    	score=score+1;
    }
    
    System.out.print("Score: "+score+"\n");
  }	
}
