import java.util.Arrays;

public class Block {
    private int previousHash;
    private String[] transactions;
    private int blockHash;

    //Constructor
    public Block(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        calculateBlockHash();
    }

    // Getters
    public int getPreviousHash() {
        return previousHash;
    }

    public String[] getTransaction() {
        return transactions;
    }

    public int getBlockHash() {
        return blockHash;
    }

    @Override public String toString() {
        return "====Block Report====\nPrevious block hash: " + previousHash + "\nBlock transactions: " + Arrays.toString(transactions) + "\nBlock hash: " + blockHash;
    }

    // Setters
    public void setTransaction(int indexNumber, String transactionString) {
        transactions[indexNumber] = transactionString;
        calculateBlockHash();
    }

    public void calculateBlockHash() {
        Object[] contents = {Arrays.hashCode(transactions), previousHash};
        this.blockHash = Arrays.hashCode(contents);
    }

}