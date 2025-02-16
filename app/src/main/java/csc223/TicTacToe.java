package csc223;

import java.util.Scanner;

public class TicTacToe implements Game{

    String[] colA;
    String[] colB;
    String[] colC;
    Scanner scanner = new Scanner(System.in);
    String currPlayer;
    String winningPlayer;

    public TicTacToe(){
        this.colA = new String[3];
        this.colB = new String[3];
        this.colC = new String[3];
        this.currPlayer = "X";
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
        System.out.println("    A   B   C");
        System.out.println("");
        System.out.println("0   " + this.colA[0] + " | " + this.colB[0] + " | " + this.colC[0]);
        System.out.println("   ---|---|---");
        System.out.println("1   " + this.colA[1] + " | " + this.colB[1] + " | " + this.colC[1]);
        System.out.println("   ---|---|---");
        System.out.println("2   " + this.colA[2] + " | " + this.colB[2] + " | " + this.colC[2]);
    }

    public void takeTurn(){
        System.out.println("Player " + this.currPlayer + "'s turn");
        System.out.print("Enter square: ");
        String response = this.scanner.nextLine();
        if (response.equals("A0")){
            if (!colA[0].equals("X") || !colA[0].equals("O")){
                colA[0] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("A1")){
            if (!colA[1].equals("X") || !colA[1].equals("O")){
                colA[1] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("A2")){
            if (!colA[2].equals("X") || !colA[2].equals("O")){
                colA[2] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("B0")){
            if (!colB[0].equals("X") || !colB[0].equals("O")){
                colB[0] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("B1")){
            if (!colB[1].equals("X") || !colB[1].equals("O")){
                colB[1] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("B2")){
            if (!colB[2].equals("X") || !colB[2].equals("O")){
                colB[2] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("C0")){
            if (!colC[0].equals("X") || !colC[0].equals("O")){
                colC[0] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("C1")){
            if (!colC[1].equals("X") || !colC[1].equals("O")){
                colC[1] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else if (response.equals("C2")){
            if (!colC[2].equals("X") || !colC[2].equals("O")){
                colC[2] = currPlayer;
            }
            else {
                System.out.println("invalaid response");
                return;
            }
        }
        else {
            System.out.println("invalaid response");
            return;
        }
        if (currPlayer.equals("X")){
            currPlayer = "O";
        }
        else {
            currPlayer = "X";
        }
    }

    public boolean isGameOver(){
        if (colA[0].equals("X") && colA[1].equals("X") && colA[2].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colB[0].equals("X") && colB[1].equals("X") && colB[2].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colC[0].equals("X") && colC[1].equals("X") && colC[2].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colA[0].equals("X") && colB[0].equals("X") && colC[0].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colA[1].equals("X") && colB[1].equals("X") && colC[1].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colA[2].equals("X") && colB[2].equals("X") && colC[2].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colA[0].equals("X") && colB[1].equals("X") && colC[2].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colA[2].equals("X") && colB[1].equals("X") && colC[0].equals("X")){
            this.winningPlayer = "X";
            return true;
        }
        if (colA[0].equals("O") && colA[1].equals("O") && colA[2].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colB[0].equals("O") && colB[1].equals("O") && colB[2].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colC[0].equals("O") && colC[1].equals("O") && colC[2].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colA[0].equals("O") && colB[0].equals("O") && colC[0].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colA[1].equals("O") && colB[1].equals("O") && colC[1].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colA[2].equals("O") && colB[2].equals("O") && colC[2].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colA[0].equals("O") && colB[1].equals("O") && colC[2].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        if (colA[2].equals("O") && colB[1].equals("O") && colC[0].equals("O")){
            this.winningPlayer = "O";
            return true;
        }
        boolean boardFilled = true;
        for (int i = 0; i < 3; i++){
            if (!colA[i].equals("X") || !colA[i].equals("O")){
                boardFilled = false;
            }
            if (!colB[i].equals("X") || !colB[i].equals("O")){
                boardFilled = false;
            }
            if (!colC[i].equals("X") || !colC[i].equals("O")){
                boardFilled = false;
            }
        }
        if (boardFilled == true){
            winningPlayer = "N";
            return true;
        }
        return false;
    }

    public void endGame(){
        if (winningPlayer.equals("N")){
            System.out.println("No winner");
        }
        else{
            System.out.println("Player " + this.winningPlayer + " won!");
        }
        startGame();
    }

    public void playGame(){
        for (int i = 0; i < 3; i++){
            this.colA[i] = " ";
            this.colB[i] = " ";
            this.colC[i] = " ";
        }
        currPlayer = "X";
        while (isGameOver() == false){
            printBoard();
            takeTurn();
        }
        printBoard();
        endGame();
    }

    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        t.playGame();
    }
}
