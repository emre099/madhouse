import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Madhouse");
        String word = "Програмиране";
        int maxGuesses = 7;
        int wrongGuesses = 0;
        StringBuilder guessedLetters = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Нека да започнем с играта Бесеница!");
        System.out.println("Трябва да познаите думата, като въвеждате по една буква всеки път.");
        System.out.println("Можете да кажете само " + maxGuesses + " грешни букви, преди да загубите.");

    }
}