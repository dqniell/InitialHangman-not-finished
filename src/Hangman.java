import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    private String[] topicList = {"SCHOOL SUBJECT", "COLOR", "HOLIDAY", "ANIMAL", "FRUIT"};
    private String[] subjWords = {"MATH", "SCIENCE", "ENGLISH", "PHYSICAL EDUCATION"};
    private String[] colorWords = {"PURPLE", "PINK", "BLUE", "RED", "YELLOW", "ORANGE"};
    private String[] holidayWords = {"CHRISTMAS", "HALLOWEEN", "THANKSGIVING", "NEW YEARS", "LUNAR NEW YEAR"};
    private String[] animalWords = {"CHICKEN", "ELEPHANT", "ALLIGATOR", "CROCODILE"};
    private String[] fruitWords = {"APPLE", "BANANA", "TOMATO", "POMEGRANATE", "DRAGONFRUIT"};
    private String topic;
    private String word;

    public Hangman(){}

    Scanner scan = new Scanner(System.in);

    private void randomWord(){
        topic = topicList[new Random().nextInt(topicList.length)].toUpperCase();
        if(topic.equals("SCHOOL SUBJECT")){
            word = subjWords[new Random().nextInt(subjWords.length)].toUpperCase();
        } else if(topic.equals("COLOR")){
            word = colorWords[new Random().nextInt(colorWords.length)].toUpperCase();
        } else if(topic.equals("HOLIDAY")){
            word = holidayWords[new Random().nextInt(holidayWords.length)].toUpperCase();
        } else if(topic.equals("ANIMAL")){
            word = animalWords[new Random().nextInt(animalWords.length)].toUpperCase();
        } else if(topic.equals("FRUIT")){
            word = fruitWords[new Random().nextInt(fruitWords.length)].toUpperCase();
        }
    }

    public void play(){
        randomWord();
        String wrongGuesses = "";
        String blankWord = "";
        for (int i = 1; i <= word.length(); i++){
            blankWord += "-";
        }

        boolean winOrLoss = false;

        int wrongCount = 0;
        String guess = "";
        hangman(wrongCount);
        System.out.println("Your hint is " + topic);
        while (wrongCount < 5){
            System.out.println("The word is: " + blankWord);
            System.out.print("Enter your guess (wrong guesses: " + wrongGuesses + "): ");
            guess = scan.nextLine();
            if (!guessCheck(guess)){
                System.out.println("Wrong guess!");
                wrongGuesses += guess.toUpperCase() + " ";
                wrongCount ++;
                hangman(wrongCount);
                if (wrongCount == 5){
                    winOrLoss = false;
                }
            } else {
                System.out.println("Right guess!");
                int idx = word.indexOf(guess.toUpperCase());
                if (guess.length() > 1) {
                    blankWord = guess;
                    wrongCount = 6;
                    winOrLoss = true;
                } else {
                    if(word.contains(guess)){
                        blankWord.replace(blankWord.substring(idx,idx+1), guess);
                    }
                }
            }
        }
        if (winOrLoss){
            System.out.println("Congrats! You guessed the word");
        } else {
            System.out.println("You failed to guess the word. Game over");
        }
    }

    private boolean guessCheck(String guess){
        guess = guess.toUpperCase();
        boolean check = false;
        if (guess.length() == 1){
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals(guess)){
                    check = true;
                }
            }
        } else {
            check = true;
            if (guess.length() > word.length()) {
                for (int j = 0; j < word.length() - 1; j++) {
                    if (!word.substring(j, j + 1).equals(guess.substring(j, j + 1))) {
                        check = false;
                    }
                }
            } else {
                for (int j = 0; j < guess.length() - 1; j++) {
                    if (!word.substring(j, j + 1).equals(guess.substring(j, j + 1))) {
                        check = false;
                    }
                }
            }
        }
        return check;
    }

    public void hangman(int numWrong) {
        if (numWrong == 0) {
            System.out.println("   ____________");
            System.out.println("   |          |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }

        if(numWrong == 1){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if(numWrong == 2){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }

        if(numWrong == 3){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          /  ");
            System.out.println("___|___      /   ");
        }

        if(numWrong == 4){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

        if(numWrong == 5){
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }

    }
}

