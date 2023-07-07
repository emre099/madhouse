import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Madhouse");
        String word = "програмиране";
        int maxGuesses = 7;
        int wrongGuesses = 0;
        StringBuilder guessedLetters = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Нека да започнем с играта Бесеница!");
        System.out.println("Трябва да познаите думата, като въвеждате по една буква всеки път.");
        System.out.println("Можете да кажете само " + maxGuesses + " грешни букви, преди да загубите.");

        while (wrongGuesses < maxGuesses) {
            System.out.println("Дума: " + getWordWithDashes(word, guessedLetters));

            System.out.print("Въведете буква: ");
            String letter = scanner.nextLine();

            if (letter.length() != 1) {
                System.out.println("Невалиден вход. Моля, въведете една буква.");
                continue;
            }

            char guessedLetter = letter.charAt(0);

            if (guessedLetters.toString().contains(letter)) {
                System.out.println("Вече сте опитали тази буква. Опитайте отново.");
                continue;
            }

            guessedLetters.append(guessedLetter);

            if (word.contains(letter)) {
                System.out.println("Верен отговор!");
            } else {
                System.out.println("Грешен отговор!");
                wrongGuesses++;
                drawHangman(wrongGuesses);
            }

            if (isWordGuessed(word, guessedLetters)) {
                System.out.println("Честито! Познахте думата: " + word);
                break;
            }

            System.out.println("Имате още " + (maxGuesses - wrongGuesses) + " грешни опитвания.");
        }

        if (wrongGuesses >= maxGuesses) {
            System.out.println("Край на играта! Достигнахте максималния брой грешни опитвания.");
            System.out.println("Думата беше: " + word);
        }
    }
}
