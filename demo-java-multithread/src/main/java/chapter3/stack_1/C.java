package chapter3.stack_1;

import lombok.AllArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/16
 */
@AllArgsConstructor
public class C {
    private MyStack myStack;
    public void popService() {
        System.out.println("pop = " + myStack.pop());
    }
}
