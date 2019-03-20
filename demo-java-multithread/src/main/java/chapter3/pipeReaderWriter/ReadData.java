package chapter3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedReader;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
public class ReadData {
    public void readMethod(PipedReader in) {
        try {
            System.out.println("read : ");
            char[] bytes = new char[20];
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
