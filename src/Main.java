// This is the main code, here the game will be run.

public class Main {

    public static int numberOfGuesses = 10;
    public static int codeCipherBase = 6;

    public static void main(String[] args) {
        intro(); //Runs an intro sequence, and tells the object of the game.
        Player player1 = new Player();
        Mastermind overlord = new Mastermind();

        //overlord.showCode(); //Used only in debugging.
        while (player1.guessCollection.size() < numberOfGuesses) {
            overlord.compareCode(player1.makeGuess());
            if (player1.guessCollection.get(player1.tries-1).codePins.get(5).pinValue == 4) {
                player1.isAWinner();
                System.exit(1);
            }
        }
        player1.isALoser();
        System.exit(1);
    }

    private static void intro() {
        System.out.println("Hello and welcome to Mastermind.");
        System.out.println("The object of the game is for you to guess a secret code, chosen by the Mastermind!");
    }


}
