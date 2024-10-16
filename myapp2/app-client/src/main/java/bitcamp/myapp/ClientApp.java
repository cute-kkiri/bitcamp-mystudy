package bitcamp.myapp;

import bitcamp.util.Prompt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientApp {

  public static void main(String[] args) {
    ClientApp app = new ClientApp();

    app.execute();
  }

  void execute() {
    String host = Prompt.input("서버? ");
    int port = Prompt.inputInt("포트번호? ");

    try (Socket socket = new Socket(host, port);
         DataInputStream in = new DataInputStream(socket.getInputStream());
         DataOutputStream out = new DataOutputStream(socket.getOutputStream())
    ) {
      while (true) {
        String message = in.readUTF();
        System.out.println(message);

        String input = Prompt.input("");
        out.writeUTF(input);
        out.flush();
      }
    } catch (Exception ex) {
      System.out.println("실행 오류!");
      ex.printStackTrace();
    }

    Prompt.close();
  }
}
