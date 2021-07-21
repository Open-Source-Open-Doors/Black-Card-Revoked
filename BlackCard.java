import java.util.Scanner;
import java.util.ArrayList;

public class BlackCard{
    
    public static void main (String[] args){
        
        String playGame = " ";
        int numOfPlayers = 0;
        Scanner input = new Scanner(System.in);
        
        //Defines the ArrayList playerList
        ArrayList<Player> playerList = new ArrayList<Player>();
        
        //Initializes the Player class inorder to use in loop
        Player player = null;
        
        
        //Greets the user and ask if they would like to play the game
        System.out.println("Hello, Welcome to black card revoked!");
        System.out.println("Please enter 'yes' or 'no' if you are ready to play: ");
        playGame = input.nextLine();
        
        //Begins the game if the user entered yes
        while(playGame.equals("yes")){
            
        System.out.println("Please enter the number of players playing the game. You can only have 6 play per round. ");
        numOfPlayers = input.nextInt();
        input.nextLine();
        
        //Checks if the number of players is greater than 6
        if(numOfPlayers > 6){
            System.out.println("Please enter a number that is less or equal to 6");
            System.out.println("You can not have more than 6 players");
            numOfPlayers = input.nextInt();
            input.nextLine();        
        }
            //Collects all of the participating players name's
            for(int i = 1; i <= numOfPlayers; i++){
                
                //Instantiates the player object
                player = new Player();
                System.out.println("Hello player " + i + ", please enter your name: ");   //Prompts user to enter name
                player.setPlayer(input.nextLine());
                
                //Adds the players entry into the player list
                playerList.add(player);                                                
                
            }
         
         //Prompts the user if they would like to play again   
         System.out.println("Would you like to continue playing? Enter 'yes' or 'no' ");
         playGame = input.nextLine();
      }
         //Test to see if the players names were collected
         for(int i = 0; i < playerList.size(); i++){
                System.out.println(playerList.get(i));
            }
        
    }
                                 
  }                              
                                 


