import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Peer extends Thread {
    public static void main(String[] args) throws IOException {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter Your Port: ");


        int port=scanner.nextInt();


        ServerSocket serverSocket=new ServerSocket(Integer.valueOf(port));
        Accepter accepter=new Accepter(serverSocket);
        accepter.start();

        new Peer().Requester();
        new Peer().Message(accepter);

    }

    public void Requester() throws IOException {
        System.out.println("enter (space separate) hostname:port");
        System.out.println("peer to receive from:");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input=bufferedReader.readLine();
        String []inputValues=input.split(" ");

        for(int i=0;i<inputValues.length;i++) {
            String[] address = inputValues[i].split(":");
            Socket socket = null;
            socket = new Socket(address[0], Integer.valueOf(address[1]));
            new Receiver(socket).start();
        }
    }


    public void Message (Accepter accepter) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write Messages (or press 'e' to end): ");
        while (true){
            String message=bufferedReader.readLine();
            if(message.equals("e")) {break;}
            else
            {
                StringWriter stringwriter=new StringWriter();
                accepter.SendMsg(message);
            }
        }
        System.exit(0);
    }
}


