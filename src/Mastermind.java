//This is the Mastermind, and it makes a secret random code.

public class Mastermind {
    Code secretCode;

    Mastermind () {
        secretCode = makeSecretCode();
    }

    public Code makeSecretCode() {//This makes the code by assigning the values of the pins in code();
        Code secretCode = new Code(makeRandom(),makeRandom(),makeRandom(),makeRandom());//We call on the method makeRandom();
        return secretCode;
    }

    //Will compare to codes of the mastermind and the player and give feedback
    public void compareCode (Code playerGuess) {
        Code tempSecret = new Code(secretCode.codePins.get(0).pinValue,secretCode.codePins.get(1).pinValue,
                secretCode.codePins.get(2).pinValue,secretCode.codePins.get(3).pinValue);
        Code tempGuess = new Code(playerGuess.codePins.get(0).pinValue,playerGuess.codePins.get(1).pinValue,
                playerGuess.codePins.get(2).pinValue,playerGuess.codePins.get(3).pinValue);
        int correct1 = 0;
        int correct2 = 0;
        for (int i = 0; i < tempGuess.codePins.size(); i++) {
            if (tempGuess.codePins.get(i).pinValue == tempSecret.codePins.get(i).pinValue) {
                correct2++;
                tempGuess.codePins.get(i).pinValue = -1;
            }
        }

        for (int i = 0; i < tempGuess.codePins.size(); i++) {
            for (int j = 0; j < tempSecret.codePins.size(); j++) {
                if (tempGuess.codePins.get(i).pinValue == tempSecret.codePins.get(j).pinValue) {
                    correct1++;
                    tempGuess.codePins.get(i).pinValue = -1;
                }
            }
        }
        playerGuess.codePins.add(new Pin(correct1));
        playerGuess.codePins.add(new Pin(correct2));
    }


    private int makeRandom() {
        return (int) (Math.random()*Main.codeCipherBase);
    }//creates a random number between 0 and codeCipherBase

    //Displays the secret code. Only call on for debugging
    public void showCode() {
        System.out.println("The true code is this:");
        System.out.println(secretCode.codePins.get(0).pinValue+" "+
                           secretCode.codePins.get(1).pinValue+" "+
                           secretCode.codePins.get(2).pinValue+" "+
                           secretCode.codePins.get(3).pinValue);
    }

}
