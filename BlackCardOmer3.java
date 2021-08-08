package blackcard;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
public class BlackCardOmer3
{
    
    static int numOfPlayers = 0;
    
    public static void main (String[] args)
    {
        
       String playGame;
        String addQuestions="";
        int numOfPlayers = 0;
        Scanner input = new Scanner(System.in);      
        
      
        
        //Initializes the Player class inorder to use in loop
        
        
        //Questions for Black Card Revoked
        String q1 = "Who is Oprah Winfrey's Best Friend?\n"
          + "(a)Gayle King\n(b)Tyler Perry\n(c)Stedman Graham\n(d)Cicely Tyson\n";
        
        String q2 = "According to Kanye, who doesn't have the answers?\n"
          + "(a)Taylor Swift\n(b)Beck\n(c)Jay-Z\n(d)Sway\n";
        
        String q3 = "Which song is a staple at the family cookout?\n"
            + "(a)'Never Too Much' - Luther Vandross\n(b)'Before I Let Go' - MAZE\n(c)'Candy' - Cameo\n(d)'Outstanding' - Gap Band\n";
        
        String q4 = "What might Momma say you need in order to get some McDonald's?\n"
          + "(a)A Job\n(b)A Clue \n(c)Good Grades\n(d)McDonald's Money\n";
        
        String q5 = "If Young Metro don't trust you, what might Future do?\n"
          + "(a)Call the Police\n(b)Shoot you\n(c)Fight you\n(d)Beat you\n";
        
        //Adds the questions q1, q2...qn into the list query, with the Questions class as its type
        ArrayList<Questions> query = new ArrayList<Questions>();
        query.add(new Questions(q1, "a"));
        query.add(new Questions(q2, "d"));
        query.add(new Questions(q3, "b"));
        query.add(new Questions(q4, "d"));
        query.add(new Questions(q5, "b"));
        
      
        System.out.println("Before we begin the game, would the user like to add questions? Enter yes or no.");
        addQuestions=input.nextLine();
        
        if(addQuestions.equals("yes")){
        	AddQuestions(query);
        }
        	
       
        for(int i=0;i<query.size();i++) 
        {
          	System.out.println(query.get(i).getQuestion());
          	
          }
        
        
        
        //Greets the user and ask if they would like to play the game
        System.out.println("Hello, Welcome to black card revoked!");
        System.out.println("Please enter 'yes' or 'no' if you are ready to play: ");
        playGame = input.nextLine();
        
        //Begins the game if the user entered yes
              if(playGame.equals("yes") || playGame.equals("y") || playGame.equals("Yes"))
              {
            
                    System.out.println("Please enter the number of players playing the game. You can only can only be in the range of 3 - 6 players per round. ");
                    numOfPlayers = input.nextInt();
                    input.nextLine();
        
                  
                     //Checks if the number of players is greater than 6
                    if((numOfPlayers < 3) || (numOfPlayers > 6))
                    {
                        
                        System.out.println("Please enter a number that is in the range of 3 - 6");
                        System.out.println("You can not have more than 6 players");
                        numOfPlayers = input.nextInt();
                        input.nextLine();        
                      }
              }
              Player[] player = new Player[numOfPlayers];
             
                
                  
                //Collects all of the participating players name's
                    for(int i = 0; i < numOfPlayers; i++)
                    {
                
                    //Instantiates the player object
                    player[i] = new Player();
                    System.out.println("Hello player " + (i+1) + ", please enter your name: ");   //Prompts user to enter name
                    player[i].setPlayer(input.nextLine());
                
                    //Adds the players entry into the player list
                                                                                       
                  
                    }
                  System.out.println("Participants in the game: ");
                  
                  for(int i = 0; i < numOfPlayers; i++)
                  {        
                      System.out.println(player[i].getPlayer());
                  }
 
                  //Participants in the game
            Collections.shuffle(query);
           
            takeTest(query, player);
         
             //Prompts the user if they would like to play again   
             System.out.println("Would you like to continue playing another round? Enter 'yes' or 'no' ");
             playGame = input.nextLine();
          
        
        System.out.println("Thank you for playing!!");
        input.close();
        
        /*
         //Test to see if the players names were collected
         for(int i = 0; i < playerList.size(); i++){
                System.out.println(playerList.get(i));
            }
         */       
    }
    
     //Allows users to answer the questions from Black Card Revoked
     public static void takeTest(ArrayList<Questions> query, Player[]array)
     {
        String answer = " "; //For the user to store their answer
        double score = 0.0;
        Scanner answerInput = new Scanner(System.in);

         for(int i= 0; i < array.length; i++){
         
         //Prints out a question from the question list
         System.out.println(query.get(i).getQuestion());
                     
        //Traverse the query list to show the player the questions        
        for(int j = 0; j < numOfPlayers; j++)
        {
            
            //Allows user to enter in their answer
            System.out.println("Hello player "+(j+1)+", " + array[j].getPlayer() + ", please enter your answer below: ");            
            answer = answerInput.nextLine();                      
            
            //Checks if the answer is correct
            if(answer.equals(query.get(i).getAnswer()))
            {
                score+=1;
                array[j].setScore(score);                                          //Sets the score of the player         
            }
                              
        } 
      }
         
         System.out.println("Stats for this round: ");
         
         //Prints the players names and score for this round
         for(int i = 0; i < array.length; i++){
             System.out.println(array[i].toString());
         }
         answerInput.close();
    }
     
     public static void AddQuestions(ArrayList<Questions>query) 
     {
    	 Scanner key=new Scanner(System.in);
    	 int numQuestions=0;
    	 
    	 System.out.println("How many questions do you want to add?");
    	 numQuestions=key.nextInt();

         String q;
         String c1,c2,c3,c4;
    	 for(int i=0;i<numQuestions;i++)
    	 {
    		 
    		 //String q;
    		 //String c1,c2,c3,c4;
    		 
    		 String answer="";
    		
    		 System.out.println("Please enter the question:");
    		 q=key.nextLine();											//this line right here. String isn't being picked up correctly. ill run it
             while (!(q = key.nextLine()).isEmpty()) {
                 System.out.println(" "+ q  );
             }
    		 //
    		 //System.out.println(" Testy:"+q);  //this is to check if its being inputted right. it's not...yes

   
    		 
    		 System.out.println("Please enter your first choice\n(a)");
    		 c1=key.next();
    		 key.nextLine();
    		 
    		 System.out.println("Please enter your second choice\n(b)");
    		 c2=key.next();
    		 key.nextLine();
    		
    		 System.out.println("Please enter your third choice\n(c)");
    		 c3=key.next();
    		 key.nextLine();
    		 
    		 System.out.println("Please enter your fourth choice\n(d)");
    		 c4=key.next();
    		 key.nextLine();
    		 
    		 
    		 
    		 String full=new String((q)+"\n(a) "+c1+"\n(b) "+c2+"\n(c) "+c3+"\n(d) "+c4);
    		 System.out.println(c1+" "+c2+" "+c3+" "+c4);
    		 System.out.println(full);
    		
    		 
    		 System.out.println("Which letter is the answer?");
    		 answer=key.nextLine();
    		 
    		
    		 System.out.println(full+" "+answer);
    		 
    		 query.add(new Questions(full,answer));
    	 }
    	 
     }
                                 
  }                            
