package chapter3.pipeReaderWriter;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 * 打印的结果和前一个示例基本一样,此实验是在两个线程中通过管道流进行字符数据的传输。
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedReader inputStream = new PipedReader();
            PipedWriter outputStream = new PipedWriter();
            //使用代码inputStream.connect(outputStream)或outputStream.connect(inputStream)的作用
            //使两个Stream之间产生通信链接,这样才可以将数据进行输出与输入。
            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData,inputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData,outputStream);
            threadWrite.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
