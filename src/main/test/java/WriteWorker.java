import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Q on 2017/2/7.
 */
public class WriteWorker implements Runnable {
    private Socket socket;
    private OutputStream outputStream;
    public void run() {
        Scanner scanner=new Scanner(System.in);
        String msg=null;
        StringBuffer stringBuffer=new StringBuffer();
        int start=0;
        int end=0;
        while (!(msg=scanner.nextLine()).equals("close")){
            System.out.println("send bytes count ["+msg.getBytes().length+"]");
            stringBuffer.append(msg);
            for(int index=0;index<msg.length();){
                int size=0;
                for(;index<msg.length();index++){
                    byte[] bytes=new Character(msg.charAt(index)).toString().getBytes();
                    if(size+bytes.length>140){
                        break;
                    }
                    size+=bytes.length;
                    end+=1;
                }
                try {
                    String str=stringBuffer.substring(start,end);
                    byte[] bytes=str.getBytes();
                    System.out.println("send bytes ["+bytes.length+"],content:"+str);
                    byte[] bytessss=new byte[140];
                    for(int i=0;i<bytes.length;i++){
                        bytessss[i]=bytes[i];
                    }
                    outputStream.write(bytessss);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                start=end;
            }
            stringBuffer.setLength(0);
            start=0;
            end=0;
        }
        //通话结束
        scanner.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WriteWorker(Socket socket) throws IOException {
        this.socket=socket;
        outputStream=socket.getOutputStream();
    }
}
