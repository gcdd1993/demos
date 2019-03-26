package base;

import org.springframework.context.Lifecycle;

/**
 * @author gaochen
 * @date 2019/3/21
 */
public class LifecycleBean implements Lifecycle {
    @Override
    public void start() {
        System.out.println("start ...");
    }

    @Override
    public void stop() {
        System.out.println("stop ...");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
