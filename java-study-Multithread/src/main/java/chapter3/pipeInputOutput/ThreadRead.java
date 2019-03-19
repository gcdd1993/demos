package chapter3.pipeInputOutput;

import lombok.AllArgsConstructor;

import java.io.PipedInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadRead extends Thread {
    private ReadData readData;
    private PipedInputStream in;

    @Override
    public void run() {
        readData.readMethod(in);
    }
}
