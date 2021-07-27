public class Questions{
    String question;
    String answer;

    
    public Questions(String question, String answer){
        this.setQuestion(question);
        this.setAnswer(answer);
        
    }
    
    //Getter methods for the Questions class
    public String getQuestion(){
        return this.question;
    }
    
    public String getAnswer(){
        return this.answer;
    }
    
    //Setter methods for the Questions class
    public void setQuestion(String question){
        this.question = question;
    }
    
    public void setAnswer(String answer){
        this.answer = answer;
    }
    
}