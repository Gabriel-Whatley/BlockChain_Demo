import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("============ New Run ============");

        String[] genesisTransactions = {"bob sent 1 BTC to john", "jim sent 2BTC to jerry", "nigel sent 5BTC to tim"};
        Block genesisBlock = new Block(0, genesisTransactions);
        System.out.println("The hash of Genesis block is : " + genesisBlock.getBlockHash());

        String[] block2Transactions = {"jim sent 5BTC to tim", "bob sent 3BTC to jerry", "jerry sent 4BTC to tim"};
        Block block2 = new Block(genesisBlock.getBlockHash(), block2Transactions);
        System.out.println("The hash of block2 is : " + block2.getBlockHash());

        String[] block3Transactions = {"jim sent 5BTC to tim", "bob sent 3BTC to jerry", "jerry sent 4BTC to tim"};
        Block block3 = new Block(block2.getBlockHash(), block3Transactions);
        System.out.println("The hash of block3 is : " + block3.getBlockHash());
    }
}