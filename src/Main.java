import java.lang.String;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    // Generate a transaction string between two distinct parties with a random value between 1 - 50
    public static String generateTransaction() {
        Random randomizer = new Random();
        int firstNameIndex;
        int secondNameIndex;
        String[] namesList = {"Jim", "Bob", "John", "Tim", "Albert", "Nigel", "Patrick", "Daniel", "Justin", "Gabe", "Satoshi", "Diana"};
        // Generate first name index.
        firstNameIndex = randomizer.nextInt(namesList.length);
        // Generate second name index to ensure that the two name indexes do not match.
        do {
            secondNameIndex = randomizer.nextInt(namesList.length);
        }
        while (firstNameIndex == secondNameIndex);
        // Generate random amount of bitcoin between 1 and 50
        int bitcoinAmount = randomizer.nextInt(1, 50);
        // Build the string and return it.
    return namesList[firstNameIndex] + " pays " + bitcoinAmount + "BTC to " + namesList[secondNameIndex];
    }

    public static String[] generateTransactionArray() {
        // Return a String array of three random transactions.
        return new String[]{generateTransaction(), generateTransaction(), generateTransaction()};
    }

    public static void main(String[] args) {
        Block genesisBlock = new Block(0, generateTransactionArray());
        System.out.println(genesisBlock.toString());
    }
}