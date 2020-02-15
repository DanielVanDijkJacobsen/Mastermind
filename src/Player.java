//This is a player, and the player keeps track of the number of tries.

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    int tries;
    ArrayList<Code> guessCollection = new ArrayList<>();

    Player () {
        tries = 0;
    }

    //The player makes a guess which is kept for reference.
    public Code makeGuess() {
        String input;
        Scanner in = new Scanner(System.in);
        this.showCollection();
        System.out.println("It is now your turn to make a guess. Please input 4 numerical values between 0 and "+(Main.codeCipherBase-1)+".");
        input = in.nextLine();
        String[] inputArray = input.split(" "); //Separates the input string into an array of strings.
        while (inputArray.length != 4) {//makes sure the input is valid
            System.out.println("Sorry, the program couldn't understand what you meant.");//prompt if the input is invalid
            System.out.println("Please input four digits with spaces in between.");
            input = in.nextLine();
            inputArray = input.split(" ");
        }
        int[] inputValue = new int[4];
        for (int i = 0; i < inputArray.length; i++) {
            inputValue[i] = Integer.parseInt(inputArray[i]);
        } //Changes the array of strings into integers.
        Code guess = new Code(inputValue[0], inputValue[1], inputValue[2], inputValue[3]);//creates full guess code
        this.guessCollection.add(guess);
        this.tries++;
        return guess;
        //Returns the input as a Code object.
    }

    //This method shows the different guesses made by the player and what the result of these guesses are.
    public void showCollection() {
        if (!this.guessCollection.isEmpty()) {
            System.out.println("You have used "+tries+" out of "+Main.numberOfGuesses+" tries up until now.");
            System.out.println("The first four in a row are your guess.");
            System.out.println("The next number shows how many ciphers are correct, but placed wrongly.");
            System.out.println("The last number shows how many ciphers are placed in a correct location.");
            for (int i = 0; i < this.guessCollection.size(); i++) {
                for (int j = 0; j < this.guessCollection.get(i).codePins.size(); j++) {
                    System.out.print(this.guessCollection.get(i).codePins.get(j).pinValue+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void isALoser() {
        System.out.println("Sorry you have lost.");
    }//what happens when you lose

    public void isAWinner() {
        System.out.println("Congratulations, you have guessed the correct sequence!");
    }//what happens when you win
}
