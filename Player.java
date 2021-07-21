public class Player{
    String name;     //Players name
    double score;    //Players score
    
    //Defualt Constructor for the Player class
    public Player(){
        this.name = " ";
        this.score = 0.0;
    }
    
    //Constructor for Player class
    public Player(String name, double score){
        this.setPlayer(name);
        this.setScore(score);
    }
    
    
    //Getter methods for the Player class
    public String getPlayer(){
        return this.name;
    }
    
    public double getScore(){
        return score;
    }
    
    //Setter methods for the Player class
    public void setPlayer(String name){
        this.name = name;
    }
    
    public void setScore(double score){
        this.score = score;
    }
    
    
    public String toString(){
        return "Player's name : " + getPlayer() + ", Player's score: " + getScore();
    }
}