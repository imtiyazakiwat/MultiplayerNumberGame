import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int numPlayers = sc.nextInt();
        sc.nextLine();
        String[] playerNames = new String[numPlayers];
        int[] scores = new int[numPlayers];
        int[] numbers = new int[numPlayers];
        int round;
        int avg;
        int minIndex;
        int minScore;
        int maxIndex = 0;
        int maxScore = 0;
        BufferedWriter bw = null;
        FileWriter fw = null;

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name: ");
            playerNames[i] = sc.nextLine();
        }
        try {
            fw = new FileWriter("scores.txt");
            bw = new BufferedWriter(fw);
            while (numPlayers > 1) {
                for (round = 1; round <= 3; round++) {
                    System.out.println("Welcome to round " + round + " of the game...");
                    for (int i = 0; i < numPlayers; i++) {
                        System.out.println(playerNames[i] + ", choose any number between 1 to 100: ");
                        numbers[i] = sc.nextInt();
                        sc.nextLine();
                    }
                    avg = 0;
                    for (int i = 0; i < numPlayers; i++) {
                        avg += numbers[i];
                    }
                    avg /= numPlayers;
                    for (int i = 0; i < numPlayers; i++) {
                        int diff = Math.abs(numbers[i] - avg);
                        scores[i] += 100 - diff;
                    }
                    for (int i = 0; i < numPlayers; i++) {
                        bw.write(playerNames[i] + " : Round " + round + " : " + scores[i] + "\n");
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
                System.out.println(
                        "Player " + playerNames[minIndex] + " has been eliminated with a score of " + scores[minIndex]);
                // Shift the remaining players in the array to the left
                System.arraycopy(playerNames, minIndex + 1, playerNames, minIndex, numPlayers - minIndex - 1);
                System.arraycopy(scores, minIndex + 1,scores, minIndex, numPlayers - minIndex - 1);
                numPlayers--;
                // Find the index of the maximum score
                maxIndex = 0;
                maxScore = 0;
                for (int i = 0; i < numPlayers; i++) {
                if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
                }
                }
                }
                System.out.println("The winner is " + playerNames[maxIndex] + " with a score of " + maxScore);
                bw.write("The winner is " + playerNames[maxIndex] + " with a score of " + maxScore);
                } catch (IOException e) {
                e.printStackTrace();
                } finally {
                try {
                if (bw != null)
                bw.close();
                if (fw != null)
                fw.close();
                } catch (IOException ex) {
                ex.printStackTrace();
                }
                sc.close();
                }
                }
                }
                
                
