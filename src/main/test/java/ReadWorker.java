import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Q on 2017/2/7.
 */
public class ReadWorker implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    public void run() {
        byte[] data=new byte[140];
        try {
            String msg=null;
            while ((inputStream.read(data))!=-1){
                msg=new String(data,"UTF-8");
                System.out.println(new Date());
                System.out.println(msg);
                System.out.println("**********************************************");
                data=new byte[140];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReadWorker(Socket socket) throws IOException {
        this.socket=socket;
        inputStream=socket.getInputStream();
    }
}
