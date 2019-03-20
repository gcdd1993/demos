package chapter3.pipeInputOutput;

import lombok.AllArgsConstructor;

import java.io.PipedOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedOutputStream out;

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
