package io.github.adrianulbona.kata.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingTest {

    // tests for summing all 10 frames

    @Test
    public void zeroSum() {
        assertEquals(0, BowlingComputer.scoreAll("-- -- -- -- -- -- -- -- -- --"));
    }

    @Test
    public void partiallyZeroSum() {
        assertEquals(16, BowlingComputer.scoreAll("15 -- -- -- -- -- -- 11 44 --"));
    }

    @Test
    public void halfZeroSum() {
        assertEquals(46, BowlingComputer.scoreAll("1- 2- 3- 4- 5- 6- 7- 8- 9- 1-"));
    }

    @Test
    public void nonFinalSpareSum() {
        assertEquals(38, BowlingComputer.scoreAll("5/ 11 11 2/ 11 11 11 11 11 11"));
    }

    @Test
    public void nonFinalSimpleStrikeSum() {
        assertEquals(40, BowlingComputer.scoreAll("11 X 11 11 11 X 11 11 11 11"));
    }

    @Test
    public void nonFinalDoubleStrikeSum() {
        assertEquals(106, BowlingComputer.scoreAll("11 X X 11 11 X X X 11 11"));
    }

    @Test
    public void finalZeroSpareSum() {
        assertEquals(28, BowlingComputer.scoreAll("11 11 11 11 11 11 11 11 11 1/ -"));
    }

    @Test
    public void finalSimpleSpareSum() {
        assertEquals(29, BowlingComputer.scoreAll("11 11 11 11 11 11 11 11 11 1/ 1"));
    }

    @Test
    public void finalStrikeSpareSum() {
        assertEquals(38, BowlingComputer.scoreAll("11 11 11 11 11 11 11 11 11 1/ X"));
    }

    @Test
    public void finalSimpleStrikeSum() {
        assertEquals(30, BowlingComputer.scoreAll("11 11 11 11 11 11 11 11 11 X 11"));
    }

    @Test
    public void finalDoubleStrikeSum() {
        assertEquals(39, BowlingComputer.scoreAll("11 11 11 11 11 11 11 11 11 X X 1"));
    }

    @Test
    public void finalTripleStrikeSum() {
        assertEquals(48, BowlingComputer.scoreAll("11 11 11 11 11 11 11 11 11 X X X"));
    }

    @Test
    public void allSpareSum() {
        assertEquals(110, BowlingComputer.scoreAll("1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1/ 1"));
    }

    @Test
    public void allStrikeSum() {
        assertEquals(300, BowlingComputer.scoreAll("X X X X X X X X X X X X"));
    }


    // tests for summing a singular frame (together with first and second roll)

    @Test
    public void zeroFrameSum() {
        assertEquals(0, BowlingComputer.scoreFrame("--", null, null));
    }

    @Test
    public void simpleSum() {
        assertEquals(6, BowlingComputer.scoreFrame("24", null, null));
    }

    @Test
    public void zeroSpareSum() {
        assertEquals(10, BowlingComputer.scoreFrame("2/", '-', null));
    }

    @Test
    public void simpleSpareSum() {
        assertEquals(14, BowlingComputer.scoreFrame("2/", '4', null));
    }

    @Test
    public void strikeSpareSum() {
        assertEquals(20, BowlingComputer.scoreFrame("2/", 'X', null));
    }

    @Test
    public void zeroStrikeSum() {
        assertEquals(10, BowlingComputer.scoreFrame("X", '-', '-'));
    }

    @Test
    public void simpleAndZeroStrikeSum() {
        assertEquals(15, BowlingComputer.scoreFrame("X", '5', '-'));
    }

    @Test
    public void simpleStrikeSum() {
        assertEquals(16, BowlingComputer.scoreFrame("X", '5', '1'));
    }

    @Test
    public void doubleStrikeSum() {
        assertEquals(25, BowlingComputer.scoreFrame("X", 'X', '5'));
    }

    @Test
    public void tripleStrikeSum() {
        assertEquals(30, BowlingComputer.scoreFrame("X", 'X', 'X'));
    }

    // tests for parsing the special characters

    @Test
    public void parseDash() {
        assertEquals(0, BowlingComputer.parseSpecial('-'));
    }

    @Test
    public void parseZero() {
        assertEquals(0, BowlingComputer.parseSpecial('0'));
    }

    @Test
    public void parseStrike() {
        assertEquals(10, BowlingComputer.parseSpecial('X'));
    }

    @Test
    public void parseDigit() {
        assertEquals(7, BowlingComputer.parseSpecial('7'));
    }

}
