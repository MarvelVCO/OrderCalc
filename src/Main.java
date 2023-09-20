import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder data = new StringBuilder();
        Random rand = new Random();

        try {
            File myObj = new File("Words.txt"); // reading the file and adding all values to `data`
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.append(" " + myReader.nextLine());
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String parsedData[] = data.toString().split(" ");   // parsing the data to a array
        String word = parsedData[rand.nextInt(1001)];   // getting a random word from the array
        String letters[] = word.split("");  // making an array to contain each letter

        System.out.println("Welcome to a word guessing game!");
        System.out.println("Type anything to start");
        scan.nextLine();

        boolean win = false;
        String guess;
        boolean correctLetter = false;

        StringBuilder underscores = new StringBuilder();    // making an array, `found`, to contain all the found letters`
        for (String element : letters) {
            underscores.append("_ ");
        }
        String found[] = underscores.toString().split(" ");

        while (!win) {
            System.out.println("Please guess a letter or word");
            guess = scan.nextLine();

            if (guess.length() > 1) {
                if (guess.equals(word)) {   // sets `win` to true when you win the game
                    win = true;
                } else {
                    System.out.println("Not the word, try again");
                }
            } else {
                for (int i = 0; i < letters.length; i++) {  // sets the underscores to letters when you guess them
                    if (letters[i].equals(guess)) {
                        found[i] = guess;
                    }
                }

                boolean allLettersFound = Arrays.stream(found).noneMatch(s -> s.equals("_"));   // a check for when you guess all the letters
                if (allLettersFound) {
                    win = true;
                }

                System.out.println("Current progress: " + String.join(" ", found));
            }
        }

        System.out.println("Congratulations! You win! The word is: " + word);
    }
}
