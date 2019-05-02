package io.github.adrianulbona.kata.bowling;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.XMLFormatter;

/**
 * Created by bis on 02/05/2019.
 */
public class BowlingComputer {

    public static int parseSpecial(Character value){
        switch (value) {
            case 'X':
                return 10;
            case '-':
                return 0;
            default:
                return Integer.parseInt(value.toString());
        }
    }

    public static int scoreFrame(String frame, Character secondRoll, Character thirdRoll) {

        int result = 0;

        try {
            if (frame.equals("X")) {
                if (secondRoll == 'X') {
                    result = 10 + 10 + parseSpecial(thirdRoll);
                } else {
                    if (thirdRoll == '/') {
                        result = 10 + 10;
                    } else {
                        result = 10 + parseSpecial(secondRoll) + parseSpecial(thirdRoll);
                    }
                }
            } else if (frame.charAt(1) == '/') {
                result = 10 + parseSpecial(secondRoll);
            } else {
                result = parseSpecial(frame.charAt(0))
                            + parseSpecial(frame.charAt(1));
            }
        } catch (Exception e) {
            System.out.println("Unexpected exception, probably invalid data");
        }

        return result;
    }

    public static int scoreAll(String frames) {

        Integer result = 0;

        LinkedList<String> framesArray = new LinkedList<String>(Arrays.asList(frames.split(" ")));
        if (framesArray.size() == 10) {
            framesArray.add("");
        } else if (framesArray.size() == 11) {
            framesArray.add("");
        }

        for (int i=0; i<10; i++) {
            result = result + scoreFrame(framesArray.get(i),
                                framesArray.get(i+1).charAt(0),
                                (framesArray.get(i+1).length() == 2 ?
                                        framesArray.get(i+1).charAt(1) : framesArray.get(i+2).charAt(0)));
        }

        return result;
    }
}
