import Bean.BookLost;
import Bean.CardLost;
import Bean.Lost;

import java.util.Calendar;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Lost[] losts = new Lost[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            losts[i] = new BookLost();
            losts[i].setDate(new Calendar.Builder().build());
            Calendar date = losts[i].getDate();
            date.set(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }



    }
}
