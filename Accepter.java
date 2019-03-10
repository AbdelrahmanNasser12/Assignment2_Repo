import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Accepter extends Thread {

    private ServerSocket serverSocket;
    public Set<Sender> senders=new HashSet<Sender>();


    Accepter(ServerSocket serverSocket) {
        this.serverSocket=serverSocket;
    }


    public void run() {
        try {
            while (true) {

                Socket socket=serverSocket.accept();
                Sender sender=new Sender(socket,this);
                senders.add(sender);
                sender.start();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}


