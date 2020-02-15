//This sets the premises for creating the secret code by making an array of 4 pins without assigned values.

import java.util.ArrayList;

public class Code {
    ArrayList<Pin> codePins = new ArrayList<>();

    Code (int a, int b, int c, int d) {
        Pin[] pinArray = {new Pin(a), new Pin(b), new Pin(c), new Pin(d)};
        for (int i = 0; i < pinArray.length; i++) {
            codePins.add(pinArray[i]);
        }
    }

}
