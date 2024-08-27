package bitcamp.net;

import java.io.*;
import java.net.Socket;
import java.sql.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prompt {

  private Socket socket;
  private DataInputStream in;
  private DataOutputStream out;

  private StringWriter stringWriter = new StringWriter();
  private PrintWriter printWriter = new PrintWriter(stringWriter);

  public Prompt(Socket socket, DataInputStream in, DataOutputStream out) throws Exception {
    this.socket = socket;
    this.in = new DataInputStream(socket.getInputStream());
    this.out = new DataOutputStream(socket.getOutputStream());
  }

  public String input(String format, Object... args) throws Exception {
    String promptTitle = String.format(format + " ", args);
    print(promptTitle);
    end();

    return in.readUTF();
  }

  public int inputInt(String format, Object... args) throws Exception {
    return Integer.parseInt(input(format, args));
  }

  public Date inputDate(String format, Object... args) throws Exception {
    return Date.valueOf(input(format, args));
  }

  public void print(String str) {
    printWriter.print(str);
  }

  public void printf(String format, Object... args) {
    printWriter.printf(format, args);
  }

  public void println(String str) {
    printWriter.println(str);
  }

  public void end() throws Exception {
    String message = stringWriter.toString();

    out.writeUTF(message);
    out.flush();

    stringWriter.getBuffer().setLength(0);
  }

  public void close() {
    try {
      in.close();
    } catch (Exception e) {
    }
    try {
      out.close();
    } catch (Exception e) {
    }
    try {
      socket.close();
    } catch (Exception e) {
    }
  }
}
