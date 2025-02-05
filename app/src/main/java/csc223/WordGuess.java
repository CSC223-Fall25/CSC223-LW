package csc223;
import java.util.Random;
import java.util.Scanner;

public class WordGuess implements Game{
    
    String[] wordBank;
    String word;
    int guesses;
    String[] wordProgress;
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    boolean wordGuessed = true;

    public WordGuess(){
        this.wordBank = new String[5]; 
        this.wordBank[0] = "frog";
        this.wordBank[1] = "lemon";
        this.wordBank[2] = "furman";
        this.wordBank[3] = "music";
        this.wordBank[4] = "computer";
        this.guesses = 10;
    }

    public void startGame(){
        System.out.print("do you want to play(y/n): ");
        String response = scanner.nextLine();
        System.out.println(response);
        if (response.equals("y")){
            playGame();
        }
        else if (response.equals("n")){
            System.out.println("goodbye");
            scanner.close();
        }
        else{
            System.out.println("please enter valid response");
            startGame();
        }
    }

    public void printBoard(){
        for (int i = 0; i < this.word.length(); i++){
            System.out.print(this.wordProgress[i] + " ");
        }
        System.out.println(" ");
    }

    public void takeTurn(){
        System.out.print("Enter a letter or guess the word: ");
        String response = this.scanner.nextLine();
        boolean correctGuess = false;
        if (response.length() == 1){
            for (int i = 0; i < this.word.length(); i++){
                if (response.equals(this.word.substring(i, i+1))){
                    wordProgress[i] = response;
                    correctGuess = true;
                }
            }
            if (correctGuess == false){
                this.guesses -= 1;
                System.out.println("wrong guess, guesses remaining: " + this.guesses);
            }
        }
        else if (response.equals(this.word)){
            for (int i = 0; i < this.word.length(); i++){
                this.wordProgress[i] = this.word.substring(i, i+1);
            }
        }
        else{
            this.guesses -= 1;
            System.out.println("wrong guess, guesses remaining: " + this.guesses);
        }
    }

    public boolean isGameOver(){
        if (this.guesses == 0){
            this.wordGuessed = false;
            return true;
        }
        this.wordGuessed = true;
        for (int i = 0; i < this.word.length(); i++){
            if (!this.wordProgress[i].equals(this.word.substring(i, i+1))){
                this.wordGuessed = false;
            }
        }
        return this.wordGuessed;
    }

    public void endGame(){
        if (this.wordGuessed == true){
            System.out.println("Correct! The word is: " + this.word);
        }
        else{
            System.out.println("Incorrect, the word is: " + this.word);
        }
        startGame();
    }

    public void playGame(){
        this.word = wordBank[this.rand.nextInt(5)];
        this.wordProgress = new String[this.word.length()];
        this.guesses = 10;
        for (int i = 0; i < this.word.length(); i++){
            this.wordProgress[i] = "_";
        }
        while (isGameOver() == false){
            printBoard();
            takeTurn();
        }
        printBoard();
        endGame();
    }

    public static void main(String[] args){
        WordGuess w = new WordGuess();
        w.startGame();
    }
}
