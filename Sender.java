import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender extends Thread {
    Socket socket;
    public PrintWriter printWriter;

    Sender(Socket socket) throws IOException {
        this.socket=socket;
        this.printWriter=new PrintWriter(socket.getOutputStream(), true);
    }


    public void run() {
      
    }


}
