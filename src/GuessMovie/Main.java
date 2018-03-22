package GuessMovie;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

import static GuessMovie.Game.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean gameOver = false;
        boolean playerHasWon = false;
        boolean matchFound = false;
        int wrongGuesses = 0;
        char letterGuessed=' ';

        String[] movies = Game.readMovies();

        String selectedMovie = Game.selectMovie(movies);

        System.out.println(selectedMovie);

        String maskedMovie = selectedMovie.replaceAll("\\S", "_");

        System.out.println(maskedMovie);
//        System.out.println("Guess a letter.You made (" + wrongGuesses + ")wrong guesses so far");
        System.out.println("Total number of letters in the movie: " + maskedMovie.length());

        char[] selectedMovieArray = selectedMovie.toCharArray();
        char[] maskedMovieArray = maskedMovie.toCharArray();


        while ((gameOver == false) && (playerHasWon == false)) {
            matchFound = false;


            System.out.println("Guess a letter.You made (" + wrongGuesses + ")wrong guesses so far");

            letterGuessed = acceptUserInput();

            for (int i = 0; i < selectedMovieArray.length; i++) {
                if (selectedMovieArray[i] == letterGuessed) {
                    maskedMovieArray[i] = letterGuessed;
                    matchFound = true;
                }
            }
            System.out.println(maskedMovieArray);

            if (!matchFound) {
                wrongGuesses++;
            }

            if (Arrays.equals(selectedMovieArray, maskedMovieArray)) {
                playerHasWon = true;
                System.out.println("You have Won the Game..!!");
            }


            if (wrongGuesses == 10) {
                gameOver = true;
                System.out.println("Game Over.. you Lost");
                System.out.println("correct movie name : " + selectedMovie);
            }


        }
    }

    public static char acceptUserInput() {
        Scanner scanLetter = new Scanner(System.in);
        String letter = scanLetter.nextLine();
        return letter.charAt(0);
    }

}
