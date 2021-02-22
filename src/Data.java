import java.util.Scanner;

public class Data {
    int key;
    String value;
    Data()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter key: ");
        key = in.nextInt();
        System.out.println("Enter value: ");
        value = in.next();
    }
}
