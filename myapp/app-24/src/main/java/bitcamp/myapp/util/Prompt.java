package bitcamp.myapp.util;

import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScanner = new Scanner(System.in);
  static Queue inputQueue = new Queue();

  public static String input(String format, Object... args) {
    String promptTitle = String.format(format + " ", args);
    System.out.print(promptTitle);
    
    String input = keyboardScanner.nextLine();
    if (format.endsWith(">")) {
      inputQueue.offer(promptTitle + input); // 최근 명령어를 큐의 맨 뒤에 넣는다.
      if (inputQueue.size() > 20) {
        inputQueue.poll(); // 가장 오래된 값을 큐에서 꺼낸다.
      }
    }
    return input;
  }

  public static int inputInt(String format, Object... args) {
    return Integer.parseInt(input(format, args));
  }

  public static void close() {
    keyboardScanner.close();
  }

  public static void printHistory() {
    System.out.println("[명령 내역]----------------");
    for (int i = 0; i < inputQueue.size(); i++) {
      System.out.println(inputQueue.get(i));
    }
    System.out.println("------------------------ 끝");
  }
}
