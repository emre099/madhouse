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
        System.out.println("Трябва да познаете думата, като въвеждате по една буква всеки път.");
        System.out.println("Можете да кажете само " + maxGuesses + " грешни букви, преди да загубите.");

        while (wrongGuesses < maxGuesses) {
            System.out.println("Дума: " + getWordWithDashes(word, guessedLetters));

            System.out.print("Въведете буква: ");
            String letter = scanner.nextLine();

            if (letter.length() != 1) {
                System.out.println("Не можете да въвеждате две букви. Моля, въведете една буква.");
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
        public static String getWordWithDashes(String word, StringBuilder guessedLetters) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);

                if (guessedLetters.toString().contains(Character.toString(letter))) {
                    result.append(letter);
                } else {
                    result.append("-");
                }
            }

            return result.toString();
        }
    public static boolean isWordGuessed(String word, StringBuilder guessedLetters) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (!guessedLetters.toString().contains(Character.toString(letter))) {
                return false;
            }
        }
        return true;
    }
    public static void drawHangman(int wrongGuesses){
        switch (wrongGuesses) {
            case 1 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
            }
            case 2 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |      |");
                System.out.println(" |");
                System.out.println("_|_");
            }
            case 3 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|");
                System.out.println(" |");
                System.out.println("_|_");
            }
            case 4 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|\\");
                System.out.println(" |");
                System.out.println("_|_");
            }
            case 5 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|\\");
                System.out.println(" |     /");
                System.out.println("_|_");
            }
            case 6 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|\\");
                System.out.println(" |     / \\");
                System.out.println("_|_");
            }
            case 7 -> {
                System.out.println("  ______");
                System.out.println(" |      |");
                System.out.println(" |      X");
                System.out.println(" |     /|\\");
                System.out.println(" |     / \\");
                System.out.println("_|_");
            }
        }
    }
}