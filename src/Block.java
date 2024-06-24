import java.util.Arrays;

public class Block {
    private int previousHash;
    private String[] transactions;
    private int blockHash;

    //Constructor
    public Block(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        setBlockHash();
    }

    // Getters
    public int getPreviousHash() {
        return previousHash;
    }

    public String[] getTransaction() {
        return transactions;
    }

    public int getNumberOfTransactions() {
        return transactions.length;
    }

    public int getBlockHash() {
        return blockHash;
    }

    @Override public String toString() {
        return "\tPrevious hash: " + previousHash + "\n\tCurrent hash: " + blockHash + "\n\tTransactions: " + Arrays.toString(transactions);
    }

    // Setters
    public void setTransaction(int indexNumber, String transactionString) {
        transactions[indexNumber] = transactionString;
        setBlockHash();
    }

    public void setBlockHash() {
        Object[] contents = {Arrays.hashCode(transactions), previousHash};
        this.blockHash = Arrays.hashCode(contents);
    }

    public void editTransaction(int index, String transaction) {
        index--;
        transactions[index] = transaction;
        setBlockHash();
    }

}