# Multiplayer Number Game

Welcome to the Multiplayer Number Game repository! This command-line game is designed for multiple players, challenging them to strategically pick numbers and compete to win. Players take turns, and after several rounds of play, the player with the highest score emerges victorious.

## Description

The Multiplayer Number Game is an engaging competition that combines strategy and probability. Each player must select a number between 1 and 100 in every round, aiming to score points based on their chosen number's proximity to the round's average. As the game progresses, players need to adapt their strategies to maximize their scores and outperform their opponents.

## How to Play

1. **Setup**: To begin, input the number of players participating in the game. Each player will be prompted to enter their name.

2. **Rounds of Play**: The game is divided into multiple rounds. In each round, players take turns secretly selecting a number within the range of 1 to 100.

3. **Scoring**: After all players have made their selections for a round, the average of the chosen numbers is calculated. Players earn points based on how close their chosen number is to this average. The smaller the difference, the higher the score.

4. **Elimination and Winner Determination**: As rounds progress, the player with the lowest cumulative score is eliminated after a set number of rounds. This process continues until a single player remains, determined by their overall score.

5. **Recording Scores**: The scores for each player and round are recorded in the "scores.txt" file.

## Features

- **Interactive Multiplayer**: Engage in friendly competition with friends or fellow players.
- **Strategic Decision-Making**: Make calculated decisions to maximize your scores.
- **Automated Scoring**: Scores are calculated based on proximity to the round's average.
- **Elimination Rounds**: Players with the lowest cumulative scores are eliminated over rounds.
- **Winner Declaration**: The player with the highest total score emerges as the ultimate winner.

## Getting Started

1. Compile and run the `Main.java` file using your Java compiler.
2. Follow the on-screen prompts to set up the game and guide player interactions.
3. Enjoy the competitive experience as players make calculated choices to win.

## Contribution

Contributions to this repository are welcome! Whether you want to improve the game's functionality, enhance the user experience, or add additional features, feel free to contribute by opening pull requests.

## License

This project is open-source and is governed by the [MIT License](LICENSE).

