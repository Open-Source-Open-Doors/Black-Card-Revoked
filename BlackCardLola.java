package blackcard;
import java.io.IOException;
import java.util.*;

public class BlackCardLola {

    static int numOfPlayers = 0;

    static int width = 100;
   static int height = 30;
    public static void main (String[] args) throws IOException {

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



        //Greets the user and ask if they would like to play the game
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~Hello, Welcome to black card revoked!~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~Please enter 'yes' or 'no' if you are ready to play: ~~~~~~~~~");
        playGame = input.nextLine();

        //Begins the game if the user entered yes
        while(playGame.equals("yes") || playGame.equals("y") || playGame.equals("Yes")){

            System.out.println("Please enter the number of players playing the game. You can only can only be in the range of 3 - 6 players per round. ");
            numOfPlayers = input.nextInt();
            input.nextLine();


            //Checks if the number of players is greater than 6
            while(numOfPlayers < 3 || numOfPlayers > 6){

                System.out.println("Please enter a number that is in the range of 3 - 6");
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

                //Checks to see if the name is entered in the right format
                String regex1 = "\\d+";
                while(player.name.matches(regex1)){

                    System.out.println("That is the incorrect, Please enter name in the right format");
                    player.setPlayer(input.nextLine());
                    playerList.add(player);
                }


            }

            System.out.println("Participants in the game: ");

            for(int i = 0; i < playerList.size(); i++){
                System.out.println(playerList.get(i).getPlayer());
            }


            //Participants in the game

            //Shuffles the questions in the query arraylist
            Collections.shuffle(query);
            takeTest(query, playerList);

            //Prompts the user if they would like to play again
            System.out.println("Would you like to continue playing another round? Enter 'yes' or 'no' ");
            playGame = input.nextLine();
        }

        System.out.println("Thank you for playing!!");

        /*
         //Test to see if the players names were collected
         for(int i = 0; i < playerList.size(); i++){
                System.out.println(playerList.get(i));
            }
         */
    }

    //Allows users to answer the questions from Black Card Revoked
    public static void takeTest(ArrayList<Questions> query, ArrayList<Player> playerList){
        String answer = " ";         //For the user to store their answer
        double score = 0.0;
        double highScore = 0.0;
        String winner = " ";


        Scanner answerInput = new Scanner(System.in);

        for(int i= 0; i < numOfPlayers; i++){

            //Prints out a question from the question list
            System.out.println(query.get(i).getQuestion());

            //Traverse the query list to show the player the questions
            for(int j = 0; j < numOfPlayers; j++){

                //Allows user to enter in their answer
                System.out.println("Hello player " + playerList.get(j).getPlayer() + ", please enter your answer below: ");
                answer = answerInput.nextLine();

                //Checks if the answer is correct
                if(answer.equals(query.get(i).getAnswer())){
                    playerList.get(j).score += 1;                                                //Increments the score by one point if the user gets the answer correct
                    score = playerList.get(j).score;
                    playerList.get(j).setScore(score);                                           //Sets the score of the player
                }
            }

            System.out.println("The answer for this question is: " + query.get(i).getAnswer());
        }

        System.out.println("Stats for this round: ");

        //Prints the players names and score for this round
        for(int i = 0; i < playerList.size(); i++){
            System.out.println(playerList.get(i));
        }

        //Checks for the highest score
        for(int i = 0; i < playerList.size(); i++){
            if(i == 0){
                highScore = playerList.get(i).getScore();
            }
            if(playerList.get(i).getScore() > highScore){
                highScore = playerList.get(i).getScore();                 //Saves the highest score
                winner = playerList.get(i).getPlayer();                   //Saves the player with the highest score in the winner variable
            }


        }



        //Prints the winner
        System.out.println("Congrats " + winner + ", you won this round!");

        //Prints the person with the max score
        Player maxScoredPerson = Collections.max(playerList, Comparator.comparing(Player::getScore));
        System.out.println("The person with the highest score is " + maxScoredPerson);



    }

}





