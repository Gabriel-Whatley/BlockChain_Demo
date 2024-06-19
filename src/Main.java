import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String[] list1 = {"gabe", "daniel", "justin", "patrick"};
        String[] list2 = {"mom", "dad", "brother", "sister"};

        System.out.println(Arrays.hashCode(list1));
        System.out.println(Arrays.hashCode(list2));
    }
}