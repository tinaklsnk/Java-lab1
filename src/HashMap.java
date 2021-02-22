import java.util.Arrays;
import java.util.Scanner;

public class HashMap {
    public static int size = 100;
    public static int quantity = 0;
    static  Data [] map = new Data[size];

    public static void main(String[] args) {
        for ( ; ; ) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter command... ");
            String command = in.next();
            switch (command) {
                case "add":
                    Data ob = new Data();
                    put(ob);
                    break;
                case "del":
                    delete();
                    break;
                case "find":
                    find();
                    break;
                case "exit":
                    System.exit(0);
                case "show":
                    show();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    public static int hashFunc (int key) {
        return (key % size);
    }

    public static void check() {
        if (quantity!=0 && (size/quantity < 2)) {
            map = Arrays.copyOf(map, size+1);
            size++;
            check();
        }
    }

    public static void put (Data ob) {
        boolean done = false;
        int num = hashFunc(ob.key);
        check();
        if (map[num] == null) {
            map[num] = ob;
            System.out.println("Index - " + num);
            quantity++;
            done = true;
        }
        else  {
            for (int i = num + 1; i < map.length; i++) {
                if (map[i] == null) {
                    map[i] = ob;
                    System.out.println("Index - " + i);
                    quantity++;
                    done = true;
                    break;
                }
            }
        }
        if (!done) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] == null) {
                    map[i] = ob;
                    System.out.println("Index - " + i);
                    quantity++;
                    done = true;
                    break;
                }
            }
        }
        check();
    }

    public static void delete () {
        System.out.println("Enter index: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num < map.length) {
            map[num] = null;
            System.out.println("Deleted");
        }
        else
            System.out.println("Error");
    }

    public static void find () {
        boolean found = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter key: ");
        int key = in.nextInt();
        int hash = hashFunc(key);
        if (map[hash] != null && map[hash].key == key) {
            System.out.println("Found: index - " + hash + "  key - " + map[hash].key + "  value - " + map[hash].value);
            found = true;
        }
        else {
            for (int i = hash + 1; i < map.length; i++) {
                if (map[i] != null && map[i].key == key) {
                    System.out.println("Found: index - " + i + "  key - " + map[i].key + "  value - " + map[i].value);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] != null && map[i].key == key) {
                    System.out.println("Found: index - " + i + "  key - " + map[i].key + "  value - " + map[i].value);
                    found = true;
                    break;
                }
                else {
                    System.out.println("Not found");
                    break;
                }
            }
        }
    }

    public static void show ()
    {
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null) {
                System.out.println("index - " + i + "  key - " + map[i].key + "  value - " + map[i].value);
            }
        }
    }

}
