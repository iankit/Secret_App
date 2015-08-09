package secretballcom.example.zion.secretball;

import java.util.Random;

/**
 * Created by Zion on 09/08/15.
 */
public class SecretBall {
    public  String[] mAnswers = {
            "Hello, How are You?",
            "I know, what you wanna do",
            "You will do good today.",
            "You will be the happiest person.",
            "Will kick you",
            "I love you",
            "Huhh...What the hell are you doing",
            "Super strong man",
            "Have a beer today"};
    
    public String getAnswer(){

        //When the button is clicked Update the label with answer

        Random randamGenerator = new Random();//Constructor
        int randamNumber = randamGenerator.nextInt(mAnswers.length);

        String answer = mAnswers[randamNumber];
        return answer;
    }
}
