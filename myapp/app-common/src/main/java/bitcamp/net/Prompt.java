package bitcamp.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.sql.Date;

public class Prompt {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    // 서버에서 출력하는 것을 임시 보관하는 역할
    private StringWriter strWriter = new StringWriter();

    // StringWriter에 문자열을 다양한 형식으로 출력할 수 있도록 도와주는 데코레이터
    // 이 객체를 사용하여 출력한 내용은 모두 위의 StringWriter에 보관된다.
    private PrintWriter printWriter = new PrintWriter(strWriter);

    public Prompt(Socket socket) throws Exception {
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    public int inputInt(String format, Object... args) throws Exception {
        return Integer.parseInt(input(format, args));
    }

    public Date inputDate(String format, Object... args) throws Exception {
        return Date.valueOf(input(format, args));
    }

    public String input(String format, Object... args) throws Exception {
        String promptTitle = String.format(format + " ", args);
        print(promptTitle);
        end();

        return in.readUTF();
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
        // 현재까지 출력한 내용을 꺼낸다.
        String message = strWriter.toString();

        // 클라이언트로 전송한다.
        out.writeUTF(message);
        out.flush();

        // StringWriter의 버퍼를 초기화한다.
        strWriter.getBuffer().setLength(0);
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
