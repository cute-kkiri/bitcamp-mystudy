package bitcamp.myapp;

import bitcamp.context.ApplicationContext;
import bitcamp.listener.ApplicationListener;
import bitcamp.myapp.listener.InitApplicationListener;
import bitcamp.util.Prompt;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientApp {

    List<ApplicationListener> listeners = new ArrayList<>();
    ApplicationContext appCtx = new ApplicationContext();

    public static void main(String[] args) {
        ClientApp app = new ClientApp();

        // 애플리케이션이 시작되거나 종료될 때 알림 받을 객체의 연락처를 등록한다.
        app.addApplicationListener(new InitApplicationListener());

        app.execute();
    }

    private void addApplicationListener(ApplicationListener listener) {
        listeners.add(listener);
    }

    private void removeApplicationListener(ApplicationListener listener) {
        listeners.remove(listener);
    }

    void execute() {

        try {
            // 상대편과 연결을 시도한다. 연결되면 객체를 리턴한다.
            Socket socket = new Socket("127.0.0.1", 8888);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // appCtx.setAttribute("socket", socket);
            appCtx.setAttribute("inputStream", in);
            appCtx.setAttribute("outputStream", out);

            // 애플리케이션이 시작될 때 리스너에게 알린다.
            for (ApplicationListener listener : listeners) {
                try {
                    listener.onStart(appCtx);
                } catch (Exception e) {
                    System.out.println("리스너 실행 중 오류 발생!");
                }
            }

            System.out.println("[프로젝트 관리 시스템]");

            appCtx.getMainMenu().execute();


            // 상대편과 편리하게 입출력할 수 있도록 데코레이터를 붙인다.
            // ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            // ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            // 서버에게 보낼 문자열을 네트워크 카드 메모리로 전송한다. 그리고 즉시 리턴한다.
            // out.writeUTF("users");
            // out.writeUTF("list");
            // out.flush();

            // 서버에서 문자열을 받을 때까지 기다리다가 문자열이 완전하게 모두 도착하면
            // String 객체를 만들어 리턴한다.
            // String status = in.readUTF();
            // System.out.println("응답 기다림!");

            // if (status.equals(FAILURE)) {
            //     System.out.println("실행 오류 입니다!");
            //     return;
            // }
            // List<User> list = (List<User>) in.readObject();
            // for (User user : list) {
//                System.out.println(user);
//            }

            out.writeUTF("quit");
            out.flush();
        } catch (Exception ex) {
            System.out.println("실행 오류!");
            ex.printStackTrace();

        }

        System.out.println("종료합니다.");

        Prompt.close();

        // 애플리케이션이 종료될 때 리스너에게 알린다.
        for (ApplicationListener listener : listeners) {
            try {
                listener.onShutdown(appCtx);
            } catch (Exception e) {
                System.out.println("리스너 실행 중 오류 발생!");
            }
        }
    }
}
