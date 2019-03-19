package chapter3.pipeReaderWriter;

import lombok.AllArgsConstructor;

import java.io.PipedWriter;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedWriter out;

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
