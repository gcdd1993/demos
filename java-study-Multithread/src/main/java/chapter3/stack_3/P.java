package chapter3.stack_3;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class P {
    private MyStack myStack;
    public void pushService() {
        myStack.push();
    }
}
