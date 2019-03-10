import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Accepter extends Thread {

    private ServerSocket serverSocket;


    Accepter(ServerSocket serverSocket) {
        this.serverSocket=serverSocket;
    }


    public void run() {
        try {
            while (true) {
                Socket socket=serverSocket.accept();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}


