import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Peer extends Thread {
    public static void main(String[] args) throws IOException {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter Your Port: ");

        int port=scanner.nextInt();

        ServerSocket serverSocket=new ServerSocket(Integer.valueOf(port));
        Accepter accepter=new Accepter(serverSocket);
        accepter.start();

    }


}