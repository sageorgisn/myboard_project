//Nikolaos Sageorgis 
import java.awt.font.NumericShaper.Range;
import java.lang.annotation.ElementType;
import java.util.Random;


public class Board {
	
  private int pairsCounter;
  private int[] openedCards;
  private int[] chineseTable;
	
  private void delay(final int sec){
    try {
	  Thread.currentThread().sleep(1000*sec);
    }
    catch (InterruptedException e) {
	  e.printStackTrace();
    }	
  }

  public Board(int pairsCounter){
    Random number=new Random();
    this.pairsCounter=pairsCounter;
    chineseTable=new int[pairsCounter*2];
    openedCards=new int[pairsCounter*2];
    int randomCard;
    int restart=0;
    int temp;
    
    for(int i=0;i<pairsCounter*2;i++)
    {
	  chineseTable[i] = restart;
	  openedCards[i] = 0;
	  restart++;
	  if(restart==pairsCounter)
		restart=0;
    }

    for(int i=0;i<pairsCounter*2;i++)
    {
      randomCard=number.nextInt(pairsCounter*2-1);
	  temp=chineseTable[i];
	  chineseTable[i]=chineseTable[randomCard];
	  chineseTable[randomCard]=temp;
    }
  }

  public void print(){
	  
    for(int i=0;i<pairsCounter*2;i++)
    {
	  if(openedCards[i]==1 || openedCards[i]!=0)
	  {
		System.out.println(i+":"+chineseTable[i]);
	  }
	  else
	  {
		System.out.println(i+":*");
	  }
    }
    
  }

  public void print(int positionA, int positionB){
    for(int i=0;i<pairsCounter*2;i++)
    {
	  if(i==positionA)
	  {
		System.out.println(i+":"+chineseTable[i]);
	  }
	  else if (i==positionB)
	  {
		System.out.println(i+":"+chineseTable[i]);
	  }
	  else
	  {
		System.out.println(i+":*");
	  }
    }
    delay(5);
  }

  public boolean checkPositions(int positionA, int positionB){
    boolean hit;

    if((openedCards[positionA]==1)||(openedCards[positionB]==1))
    {
	  hit=false;
    }
    else
    {
	  if(chineseTable[positionA]==chineseTable[positionB])
	  {
		openedCards[positionA]=1;
		openedCards[positionB]=1;
		hit=true;
	  }
	  else
	  {
		hit=false;
	  }
    }

    return hit;
  }
  
  public int getRandomPosition(){
    Random number = new Random();
    int position=0;
    boolean rightPosition;

    rightPosition = false;
    while(rightPosition==false)
    {
	  position = number.nextInt(pairsCounter*2-1);
	  if(openedCards[position]==0)
	  {
		  rightPosition=true;
		  break;
	  }
	  else
	  {
		  rightPosition=false;
	  }
    }

    return position;
  }

  public int getCard(int position){
	return chineseTable[position];
  }

  public boolean allOpen(){
	boolean areAllOpenedCards;
	int sameCards;
	
	sameCards=0;
	for(int i=0;i<pairsCounter*2;i++)
	{
		if(openedCards[i]==1 || openedCards[i]!=0)
		{
			sameCards++;
		}
	}
	
	if(sameCards==(pairsCounter*2 - 1))
	{
		areAllOpenedCards=true;
	}
	else
	{
		areAllOpenedCards=false;
	}
	
	return areAllOpenedCards;
  }
}
