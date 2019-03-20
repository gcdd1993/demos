package chapter3.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ReadData {
    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read : ");
            byte[] bytes = new byte[20];
            int readLength = in.read(bytes);
            while (readLength != -1) {
                String newData = new String(bytes,0,readLength);
                System.out.print(newData);
                readLength = in.read(bytes);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
