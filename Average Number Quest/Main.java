package Game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int numPlayers = sc.nextInt();
        sc.nextLine();
        String[] playerNames = new String[numPlayers];
        int[] scores = new int[numPlayers];
        int[] numbers = new int[numPlayers];
        int[] roundNumber = new int[numPlayers];
        int avg;
        int minIndex;
        int minScore;
        int maxIndex = -1;
        int maxScore = 0;

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name: ");
            playerNames[i] = sc.nextLine();
        }
        while (numPlayers > 1) {
            for (int round = 1; round <= 3; round++) {
                System.out.println("Welcome to round " + round + " of the game...");
                for (int i = 0; i < numPlayers; i++) {
                    if (playerNames[i] != null) {
                        System.out.println(playerNames[i] + ", choose any number between 1 to 100: ");
                        numbers[i] = sc.nextInt();
                        sc.nextLine();
                        roundNumber[i] = round;

                        try {
                            try (FileWriter writer = new FileWriter("scores.txt", true)) {
                                for (i = 0; i < playerNames.length; i++) {
                                    if (playerNames[i] != null) {
                                        writer.write(playerNames[i] + " scored " + scores[i] + "in round "
                                                + roundNumber[i] + "\n");
                                    }
                                }
                                writer.close();
                                // System.out.println("Scores saved to scores.txt");
                            }
                        } catch (IOException e) {
                            System.out.println("An error occurred while saving scores to scores.txt");
                            e.printStackTrace();
                        }
                    }
                }
                avg = 0;
                for (int i = 0; i < numPlayers; i++) {
                    avg += numbers[i];
                }
                avg /= numPlayers;
                for (int i = 0; i < numPlayers; i++) {
                    int diff = Math.abs(numbers[i] - avg);
                    scores[i] += 100 - diff;
                    if (scores[i] > maxScore) {
                        maxScore = scores[i];
                    }
                }
            }
            minIndex = 0;
            minScore = Integer.MAX_VALUE;
            for (int i = 0; i < numPlayers; i++) {
                if (scores[i] < minScore) {
                    minScore = scores[i];
                    minIndex = i;
                }
            }
            if (playerNames[minIndex] != null) {
                System.out.println(
                        "Player " + playerNames[minIndex] + " has been eliminated with a score of " + scores[minIndex]);
                for (int i = 0; i < numPlayers; i++) {
                    if (playerNames[i] != null) {
                        System.out.println(playerNames[i] + " has a score of " + scores[i]);
                    }
                }
            }
            for (int i = 0; i < numPlayers; i++) {
                if (playerNames[i] != null && scores[i] == maxScore) {
                    System.out.println("The winner is " + playerNames[i] + " with a score of " + scores[i]);
                }
            }
            playerNames[minIndex] = null;
            scores[minIndex] = 0;
            roundNumber[minIndex] = 0;
            numPlayers--;
        }

        sc.close();
    }
}
