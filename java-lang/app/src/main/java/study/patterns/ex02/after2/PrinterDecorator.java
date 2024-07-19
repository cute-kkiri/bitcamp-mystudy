package study.patterns.ex02.after2;

public abstract class PrinterDecorator implements Printer {
  protected Printer origin;

  public PrinterDecorator(Printer printer) {
    origin = printer;
  }
}
