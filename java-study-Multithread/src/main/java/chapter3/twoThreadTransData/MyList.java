package chapter3.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/15
 */
public class MyList {
    private List list = new ArrayList();
    public void add() {
        list.add("高红艳");
    }
    public int size() {
        return list.size();
    }
}
