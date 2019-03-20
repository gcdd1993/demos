package chapter6.singleton_7_1;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 */
public class SaveAndRead {
    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("myObjectFile.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
            System.out.println(myObject.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fisRef = new FileInputStream(new File("myObjectFile.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject myObject = (MyObject) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObject.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
