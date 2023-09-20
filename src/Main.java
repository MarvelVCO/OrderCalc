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
            File myObj = new File("Words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.append(" " + myReader.nextLine());
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String parsedData[] = data.toString().split(" ");
        String word  = parsedData[rand.nextInt(1001)];
        String letters[] = word.split("");
        System.out.println(word);

        System.out.println("Welcome to a word guessing game!");
        System.out.println("Type anything to start");
        scan.nextLine();

        boolean win = false;
        String guess;
        boolean correctLetter = false;
        while (win == false) {
            System.out.println("Please guess a letter or word");
            guess = scan.nextLine();
            if (guess.length() > 1) {
                if (guess.equals(word)) {
                    win = true;
                }
                else {
                    System.out.println("Not the word, try again");
                }
            }
            else {
                for (String element : letters) {
                    if (element.equals(guess)) {
                        correctLetter = true;
                    }
                }
                if (correctLetter == true) {
                    System.out.println("That letter is in the word!");
                    correctLetter = false;
                }
                else {
                    System.out.println("That letter is not in the word!");
                }

            }
        }
        System.out.println("You win!");
    }
}