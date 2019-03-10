import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender extends Thread {
    Accepter accepter;
    Socket socket;
    public PrintWriter printWriter;

    Sender(Socket socket,Accepter accepter) throws IOException {
        this.socket=socket;
        this.accepter=accepter;
        this.printWriter=new PrintWriter(socket.getOutputStream(), true);
    }


    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true) { bufferedReader.readLine(); }
        }
        catch (IOException e) { this.accepter.senders.remove(this); }
    }

}