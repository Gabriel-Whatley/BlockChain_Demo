import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String[] genesisTransactions = {"bob sent 1 BTC to john", "jim sent 2BTC to jerry", "nigel sent 5BTC to tim"};

        Block genesisBlock = new Block(0, genesisTransactions);

        System.out.println("The hash of Genesis block is : " + genesisBlock.getBlockHash());
    }
}