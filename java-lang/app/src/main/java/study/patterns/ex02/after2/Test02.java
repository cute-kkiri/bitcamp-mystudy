package study.patterns.ex02.after2;

public class Test02 {
  public static void main(String[] args) {
    ContentPrinter printer0 = new ContentPrinter();
    HeaderPrinter printer = new HeaderPrinter(printer0, "공지사항");
    printer.print("안녕하세요!");
  }
}
