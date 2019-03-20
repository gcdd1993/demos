package chapter3.pipeReaderWriter;

import lombok.AllArgsConstructor;

import java.io.PipedReader;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadRead extends Thread {
    private ReadData readData;
    private PipedReader in;

    @Override
    public void run() {
        readData.readMethod(in);
    }
}
