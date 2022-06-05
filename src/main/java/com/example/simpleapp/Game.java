package com.example.simpleapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {
    private final int[] guessNum;

    public Game() {
        guessNum = generateNums();
        System.out.println(Arrays.toString(guessNum));
    }

    public String getGuessNum() {
        return " " + guessNum[0] + + guessNum[1]+ guessNum[2]+ guessNum[3];
    }

    public static class BullsAndCowsCounter  {
private int bulls;
private int cows;

        public BullsAndCowsCounter(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }
    }
    public BullsAndCowsCounter calculateBullsAndCows(String input) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            if (guessNum[i] == input.charAt(i) - '0') {
                bulls++;
            } else if (input.contains(String.valueOf(guessNum[i]))) {
                cows++;
            }
        }
        return new BullsAndCowsCounter(bulls, cows);
    }

    private int[] generateNums() {
        ArrayList<Integer> numData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numData.add(i);
        }
        Collections.shuffle(numData);
        return new int[] {numData.get(0),numData.get(1),numData.get(2),numData.get(3)};
    }
}
