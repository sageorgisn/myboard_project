//Nikolaos Sageorgis 
import java.io.IOException;


public class ChinesePairs
{
  public static void main(String[] args) throws IOException
  {
	Board board=new Board(4);
	HumanPlayer human=new HumanPlayer(4);
	ComputerPlayer computer=new ComputerPlayer(4);
	
	boolean endOfGame=board.allOpen();
	System.out.println("Game begins!");
	int i=0;
	while (endOfGame==false){
		System.out.println("-------");
		computer.play(board);
		human.play(board);
		i++;
	}
	int yourScore = human.getScore();
	int computerScore = computer.getScore();
	if (yourScore>computerScore) {
		System.out.println("YOU WON!!!");
	}
	else if (yourScore<computerScore) {
		System.out.println("YOU LOST!!!");
	}
	else{
		System.out.println("NO WINNER");
	}
  }
}
