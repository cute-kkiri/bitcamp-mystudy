package bitcamp.myapp.util;

import java.util.Scanner;

public class Prompt {
    static Scanner keyboardScanner = new Scanner(System.in);

    static String Input(String title) {
        System.out.printf("%s ", title);
        return keyboardScanner.nextLine();
    }

    static void close() {
        keyboardScanner.close();
    }
}
