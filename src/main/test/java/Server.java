import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Q on 2017/2/7.
 */
public class Server {
    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket=new ServerSocket();
    }

    public static void main(String[] args){
        try {
            new Server().listen(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(int port) throws IOException {
        serverSocket.bind(new InetSocketAddress(port));
        while (true){
            Socket socket=serverSocket.accept();
            new Thread(new ReadWorker(socket)).start();
            new Thread(new WriteWorker(socket)).start();
        }
    }
}
