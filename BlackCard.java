import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
public class practice
{
    
    static int numOfPlayers = 0;
    
    public static void main (String[] args)
    {
        
        String playGame=" ";
        String addQuestions=" ";
        int numOfPlayers = 0;
        int userOptions = 0;
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
        
        System.out.println("Hello, Welcome to black card revoked!");
        System.out.println("Please enter 1, if you would like to see the instructions for the game.");
        System.out.println("Please enter 2, if you would like to add questions to the game");
        System.out.println("Please enter 3, if you would like to begin playing the game.");
                
        userOptions = input.nextInt();
        
        //If user choics option 1
        
        if(userOptions == 1){
             System.out.println(" ----Black Card Revoked Game Rules ----");
                System.out.println();
                System.out.println(" OBJECT OF BLACK CARD REVOKED: ");
                System.out.println(" The objective of Black Card Revoked \n is to not lose all ten of your points. "
                        + "\n The first player to lose all ten points \n is the loser! \n");
                System.out.println(" NUMBER OF PLAYERS: 3 to 6 Players \n");
                System.out.println(" MATERIALS: 54 Question Cards, 15 Answer Cards \n");
                System.out.println(" TYPE OF GAME: PARTY CARD GAME \n");
                System.out.println(" AUDIENCE: 13+ \n");

                System.out.println(" SETUP \n ");
                System.out.println(" To begin setup, give each player response cards. " + "Each \n player should have " +
                        "four response cards A, B, C, and D in \n their hand. The Question Cards are then shuffled " +
                        "displayed \n randomly for each player to make their response (A, B, C, or D). \n");
                System.out.println(" GAMEPLAY \n");
                System.out.println(" Each card will determine if the answer has a correct answer or \n " +
                        "if the majority will rule. " + "Players have six (6) to ten (10) \n seconds to decide " +
                        "on an answer. The players will then " + "be prompted \n to reveal their answers at once. \n");
                System.out.println(" MAJORITY WINS: \n Determined by the answer selected by the majority of players \n " +
                        "(4 Players, 3 say 'A' then 'A' wins). \n\n If there is a tie, the game randomly makes the call on " +
                        "which \n answer wins.");
                System.out.println(" \n If the card has a correct answer, the players who chose the \n wrong answer lose a point. " +
                        "Players begin the game with ten \n (10) points. \n");
                System.out.println(" END OF GAME \n");
                System.out.println(" The game comes to an end when a player loses all ten points! \n This player instantly " +
                        "gets their Black Card Revoked and they \n are the loser! \n");
        }
        
         //If user choics option 2
        
        if(userOptions == 2){       
        //Ask the user if they would like to add a question
        System.out.println("Before we begin the game, would the user like to add questions? Enter yes or no.");
        addQuestions=input.nextLine();
        
        if(addQuestions.equals("yes")){
        	AddQuestions(query);
        }
        	
        //Prints the updated list of questions
        for(int i=0;i<query.size();i++) 
        {
          	System.out.println(query.get(i).getQuestion());
          	
          }
        }
        
        //If user choics option 1
        
        
        //Greets the user and ask if they would like to play the game
        //System.out.println("Hello, Welcome to black card revoked!");
        System.out.println("Please enter 'yes' or 'no' if you are ready to play: ");
        playGame = input.next();
        
        
        
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
    
        
    }
    
     
    
    //Allows users to answer the questions from Black Card Revoked
     private static void takeTest(ArrayList<Questions> query, Player[]array)
     {
        String answer = " "; //For the user to store their answer
        double score = 0.0;
        Scanner answerInput = new Scanner(System.in);

         for(int i= 0; i < array.length; i++)
         {
         
         //Prints out a question from the question list
         System.out.println(query.get(i).getQuestion());
                     
        //Traverse the query list to show the player the questions        
        for(int j = 0; j < array.length; j++)
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
     
     
     
     private static void AddQuestions(ArrayList<Questions>query) 
     {
    	 Scanner key=new Scanner(System.in);
    	 int numQuestions=0;
    	 
    	 System.out.println("How many questions do you want to add?");
    	 numQuestions=key.nextInt();
    	 
    	 
    	 String q;
    	 String c1,c2,c3,c4;
    	 String full;
    	 String answer;
    	 Questions[]question=new Questions[numQuestions];
    	 for(int i=0;i<numQuestions;i++)
    	 {
   
    		
    		 System.out.println("Please enter question number "+(i+1)+".");
    		 key.nextLine();                                                //This is pretty much what i added
    		 q=key.nextLine();
    		
    		
    		
    		   
    		 
    		 
   
    		 
    		 System.out.println("Please enter your first choice\n(a)");
    		 c1=key.nextLine();
    		
    		 
    		 System.out.println("Please enter your second choice\n(b)");
    		 c2=key.nextLine();
    		 
    		
    		 System.out.println("Please enter your third choice\n(c)");
    		 c3=key.nextLine();
    		 
    		 
    		 System.out.println("Please enter your fourth choice\n(d)");
    		 c4=key.nextLine();
    		
    		 
    		 
    		 full=((q)+"\n(a) "+c1+"\n(b) "+c2+"\n(c) "+c3+"\n(d) "+c4);
    		 
    		 System.out.println(full);
    		
    		 
    		 System.out.println("Which letter is the answer?");
    		 answer=key.nextLine();
    		 
    		question[i]=new Questions(full,answer);
    		 System.out.println(full+"  answer:"+answer);
    		 
    		 query.add(question[i]);
    	 }
    	 
     }
                                 
}      