package study.patterns.ex02.after2;

public class Test04 {
  public static void main(String[] args) {
    ContentPrinter printer0 = new ContentPrinter();
    FooterPrinter printer = new FooterPrinter(printer0, "비트캠프");
    printer.print("안녕하세요!");
  }
}
