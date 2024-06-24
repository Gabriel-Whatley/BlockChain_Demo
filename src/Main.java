import java.lang.String;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

    private static int userInterfaceHandler(Scanner input, String[] menuItems, String menuName) {
        int menuOption = 0; // Will be assigned based on user input later.
        System.out.println("-- " + menuName + " -- "); // Print the main title of the menu based on parameter.
        for (int i = 0; i < menuItems.length; i++) { // Iterates through the array printing the menu items.
            System.out.println((i + 1) + ".\t" + menuItems[i]); // Generates item numbers automatically.
        }
        System.out.println((menuItems.length + 1) + ".\tExit"); // Generate entry for "Exit" option automatically.
        do { // Start looping
            System.out.print("Enter an option: "); // Prompt user for input
            if (input.hasNextInt()) { // If the scanner's next token is an int.
                menuOption = input.nextInt(); // Assign it to menuOption
                if (menuOption < 1 || menuOption > (menuItems.length + 1)) { // If the int isn't one of the menu options warn the user and re-prompt.
                    System.out.println("Please enter a choice from the list");
                }
            } else { // If the next scanner token isn't an int, warn the user and re-prompt.
                System.out.println("Please enter a choice from the list");
                input.next(); // Consume the next scanner token to prevent uncontrolled looping.
            }
        } while (menuOption < 1 || menuOption > (menuItems.length + 1)); // Keep prompting until the user input is the correct type and range.
        return menuOption; // Return the parsed input to the caller.
    }

    public static void mainMenu(Scanner input, ArrayList<Block> blockChain) {
        String[] mainMenuItems = {"Add a block", "Display a block", "Edit a block", "Display the whole blockchain"};
        String mainMenuTitle = "Main Menu";
        int userInput;
        do {
            userInput = userInterfaceHandler(input, mainMenuItems, mainMenuTitle);
            switch (userInput) {
                case 1:
                    addBlock(input, blockChain);
                    break;
                case 2:
                    displayBlock(input, blockChain);
                    break;
                case 3:
                    editBlock(input, blockChain);
                    break;
                case 4:
                    displayBlockChain(blockChain);
                    break;
                case 5: // Quit the program.
                    System.out.println("Goodbye!");
                    break;
            }
        } while (userInput != 5);
    }

    public static void addBlock(Scanner input, ArrayList<Block> blockChain) {
        System.out.println("How many transactions would you like to add to the new block?: ");
        int transactionsNumber = input.nextInt();
        input.nextLine();
        String[] newBlockTransactions = new String[transactionsNumber];
        for (int i = 0; i < transactionsNumber; i++) {
            newBlockTransactions[i] = generateTransaction();
        }
        Block newBlock = new Block(blockChain.get(blockChain.size() - 1).getBlockHash(), newBlockTransactions);
        System.out.println("Added a new block with " + transactionsNumber + " transactions to the chain.");
        System.out.println(newBlock);
        blockChain.add(newBlock);
    }

    public static void displayBlock(Scanner input, ArrayList<Block> blockChain) {
        int blockNum = 0;
        do { // Start looping
            System.out.print("Enter the number of the block you would like to view: "); // Prompt user for input
            if (input.hasNextInt()) { // If the scanner's next token is an int.
                blockNum = input.nextInt(); // Assign it to blockNum.
                if (blockNum < 1 || blockNum > blockChain.size()) { // If the int isn't one of the blocks warn the user and re-prompt.
                    System.out.println("the block does not exist in this Blockchain");
                }
            } else { // If the next scanner token isn't an int, warn the user and re-prompt.
                System.out.println("Please enter a number");
                input.next(); // Consume the next scanner token to prevent uncontrolled looping.
            }
        } while (blockNum < 1 || blockNum > blockChain.size()); // Keep prompting until the user input is the correct type and range.
        System.out.println("Displaying block #" + blockNum);
        System.out.println(blockChain.get(blockNum - 1).toString());
    }

    public static void editBlock(Scanner input, ArrayList<Block> blockChain) {
        int blockNum = 0;
        do { // Start looping
            System.out.print("Enter the number of the block you would like to edit: "); // Prompt user for input
            if (input.hasNextInt()) { // If the scanner's next token is an int.
                blockNum = input.nextInt(); // Assign it to menuOption
                if (blockNum < 1 || blockNum > blockChain.size()) { // If the int isn't one of the blocks warn the user and re-prompt.
                    System.out.println("the block does not exist in this Blockchain");
                }
            } else { // If the next scanner token isn't an int, warn the user and re-prompt.
                System.out.println("Please enter a number");
                input.next(); // Consume the next scanner token to prevent uncontrolled looping.
            }
        } while (blockNum < 1 || blockNum > blockChain.size());// Keep prompting until the user input is the correct type and range.
        blockNum --;
        Block editedBlock = blockChain.get(blockNum);
        int transactionNum = 1;
        for (String transaction: editedBlock.getTransaction()) {
            System.out.println(transactionNum + " - " + transaction);
            transactionNum++;
        };
        int editingTransactionNumber = 0;
        do { // Start looping
            System.out.print("Enter the number of the transaction you would like to edit: "); // Prompt user for input
            if (input.hasNextInt()) { // If the scanner's next token is an int.
                editingTransactionNumber = input.nextInt(); // Assign it to menuOption
                if (editingTransactionNumber < 1 || editingTransactionNumber > blockChain.get(blockNum).getNumberOfTransactions()) { // If the int isn't one of the transactions warn the user and re-prompt.
                    System.out.println("The transaction does not exist in this block");
                }
            } else { // If the next scanner token isn't an int, warn the user and re-prompt.
                System.out.println("Please enter a number");
                input.next(); // Consume the next scanner token to prevent uncontrolled looping.
            }
        } while (editingTransactionNumber < 1 || editingTransactionNumber > blockChain.get(blockNum).getNumberOfTransactions()); // Keep prompting until the user input is the correct type and range.
        input.nextLine();
        System.out.println("enter the text to replace transaction #" +  editingTransactionNumber + " with: ");
        String newTransaction = input.nextLine();
        blockChain.get(blockNum).editTransaction(editingTransactionNumber, newTransaction);
        System.out.println("Transaction #" +  editingTransactionNumber + " has been replaced.");
    }

    public static void displayBlockChain(ArrayList<Block> blockChain) {
        int blockNum = 1;
        for (Block block : blockChain) {
            System.out.println("-- Block #" + blockNum + " --");
            System.out.println(block);
            blockNum++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Create a scanner to get user input.
        ArrayList<Block> blockChain = new ArrayList<>();
        System.out.println("====== Blockchain Demonstrator ======");
        blockChain.add(new Block(0, generateTransactionArray())); // Create the genesis block.
        mainMenu(input, blockChain);
    }
}