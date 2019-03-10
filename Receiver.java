import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver extends Thread {

    private BufferedReader bufferedReader;
    Receiver(Socket socket) throws IOException {

        this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }


    public void run() {
        while (true) {
            String msg= null;
            try {
                msg = bufferedReader.readLine();
                System.out.println(msg);
            }
            catch (IOException e) {interrupt();}

        }
    }
}
