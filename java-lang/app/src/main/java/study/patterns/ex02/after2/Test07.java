package study.patterns.ex02.after2;

public class Test07 {
  public static void main(String[] args) {
    ContentPrinter printer0 = new ContentPrinter();
    SignPrinter printer1 = new SignPrinter(printer0, "홍길동");
    HeaderPrinter printer2 = new HeaderPrinter(printer1, "편지");
    FooterPrinter printer = new FooterPrinter(printer2, "비트캠프");
    printer.print("안녕하세요!");
  }
}
