package blackcard;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;



public class BlackCardLola {

    static int numOfPlayers = 0;

    public static void main (String[] args){

        String playGame = " ";
        //int numOfPlayers = 0;
        Scanner input = new Scanner(System.in);


        //Defines the ArrayList playerList
        ArrayList<Player> playerList = new ArrayList<Player>();

        //Initializes the Player class inorder to use in loop
        Player player = null;

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

        //Shuffles the arraylist of questions
        Collections.shuffle(query);

        //Greets the user and ask if they would like to play the game
        System.out.println("Hello, Welcome to black card revoked!");
        System.out.println("Please enter 'yes' or 'no' if you are ready to play: ");
        playGame = input.nextLine();

        //Begins the game if the user entered yes
        while(playGame.equals("yes") || playGame.equals("y")){

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

            //takeTest(query, playerList);

            //Prompts the user if they would like to play again
            //Change for switch
            System.out.println("Are you ready ");
            playGame = input.nextLine();

            takeTest(query, playerList);
        }


        //Test to see if the players names were collected
        for(int i = 0; i < playerList.size(); i++){
            System.out.println(playerList.get(i));
        }

    }

    //Allows users to answer the questions from Black Card Revoked
    public static void takeTest(ArrayList<Questions> query, ArrayList<Player> playerList){
        String answer = " "; //For the user to store their answer
        double score = 0;
        Scanner answerInput = new Scanner(System.in);

        //Traverse the query list to show the player the questions
        for(int i = 0; i < numOfPlayers; i++){
            //Prints out the question
            System.out.println("Hello player " + playerList.get(i).getPlayer() + ", answer the following question: ");
            System.out.println(query.get(i).getQuestion());
            answer = answerInput.nextLine();


            //Checks if the answer is correct
            if(answer.equals(query.get(i).getAnswer())){
                score  += 1;                                                    //Increments the score by one point if the user gets the answer correct
                playerList.get(i).setScore(score);                              //Sets the score of the player
                System.out.println("That's correct!");
                System.out.println("You're score is: " + playerList.get(i).getScore());
            }
            else{
                System.out.println("That's incorrect!");                       //Tells the user the answer is incorrect
                System.out.println("You're score is: " + playerList.get(i).getScore());
            }
        }


    }

}

