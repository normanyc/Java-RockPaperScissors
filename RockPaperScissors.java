/*Normany Chan
CS 21 - Intro to Computer Science-Java - 50963
7-26-2020
*/
import java.util.*;
import java.io.*;
public class RockPaperScissors
{
    public static void main (String[] arg)
    {
    //initialization
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    boolean start = true;

    int PlayerWins = 0;
    int CPUWins = 0;
    int Ties = 0; 
    
       while(start)
       {
       int CPU = rand.nextInt(3)+1;
       
       System.out.println("The rock, paper, scissors game.");
       System.out.print("Select number  1)rock  2)paper  3)scissors  : ");
       //while loop to check for invalidation
                while(!input.hasNextInt())
                {
                System.out.print("Invalid response. Try again\n");
                System.out.print("Select number  1)rock  2)paper  3)scissors  : ");
                input.next();
                System.out.println();
                }
                
       //Taking user's input and matching CPU random guess
       int Player = input.nextInt();
       System.out.println();
           if(Player == CPU)    
           {
               printResults(Player, CPU);
               System.out.println("Results: Tie");
               Ties++;
           }
           
           else if(Player == 1 && CPU == 3 || Player == 2 && CPU == 1 || Player == 3 && CPU == 2  ) 
           {                     
               printResults(Player, CPU);
               System.out.println("Results: Player wins");
               PlayerWins++;
           }
                
           else if(CPU == 1 && Player == 3 || CPU == 2 && Player == 1 || CPU == 3 && Player == 2  )    
           {
                printResults(Player, CPU);
                System.out.println("Results: CPU wins");
                CPUWins++;
           }
           
           else
           System.out.print("Invalid response.\n");
       
       //asking user to play again    
       boolean test = true;
       System.out.print("\nPlay again (yes or no): ");  
                
                while(test)
                {
                String again = input.next();    
                    if(again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes"))
                    {
                        start = true; 
                        test =  false;
                        System.out.println();
                    }
                
                    else if (again.equalsIgnoreCase("n") || again.equalsIgnoreCase("no"))
                    {
                        start = false; 
                        test =  false;
                        System.out.println();
                    }
                    else
                    {
                        System.out.print("Invalid response. Try again\n");    
                        System.out.print("\nPlay again (yes or no): ");     
                        test = true;    
                    }
                }
    }
    System.out.println("Player number of wins: " + PlayerWins);
    System.out.println("CPU number of wins: " + CPUWins);
    System.out.println("Ties: " + Ties);
    }    

    //converting numbers to strings
    public static void numTostring(int x)
    {
    if(x == 1)
    System.out.print("rock");
        
    else if (x == 2)
    System.out.print("paper");
        
    else if (x == 3)
    System.out.print("scissors");
    }

    //printing player and cpu outcomes
    public static void printResults(int p, int c)
    {
    System.out.print("Player: "); 
    numTostring(p);
    System.out.println();
                    
    System.out.print("CPU: ");
    numTostring(c); 
    System.out.println();
    }
}