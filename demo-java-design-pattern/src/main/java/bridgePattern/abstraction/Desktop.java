package bridgePattern.abstraction;

/**
 * @author: gaochen
 * Date: 2019/1/15
 */
public class Desktop implements Computer {
    @Override
    public void info() {
        System.out.println("台式电脑！");
    }
}
