package GuessMovie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    public static String[] readMovies() throws FileNotFoundException {
        File file = new File("C:\\javadev\\projects\\Guess the Movie\\src\\movies.txt");
        Scanner scanner = new Scanner(file);

        String[] movies = new String[25];
        int i=0;

        while (scanner.hasNextLine()){
            movies [i] = scanner.nextLine();
//            System.out.println(movies[i]);
            i++;
        }
        return movies;

    }
    public static String selectMovie(String[] movieList){
        int randomNumber = (int) (Math.random()*25);
        return movieList[randomNumber];

    }

}
