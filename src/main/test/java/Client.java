import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Q on 2017/2/7.
 */
public class Client {
    private Socket socket;

    public Client() {
        this.socket=new Socket();
    }

    public static void main(String[] args){
        try {
            new Client().connect("127.0.0.1",8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect(String host,int port) throws IOException {
        socket.connect(new InetSocketAddress(host,port));
        new Thread(new ReadWorker(socket)).start();
        new Thread(new WriteWorker(socket)).start();
    }
}
