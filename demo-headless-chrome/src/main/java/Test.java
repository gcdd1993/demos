import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author gaochen
 * @date 2019/3/22
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe --headless --disable-gpu --print-to-pdf=D:\\2.pdf https://www.baidu.com";
        String homeDirectory = System.getProperty("user.home");
        Process process;
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        if (isWindows) {
            process = Runtime.getRuntime()
                    .exec(cmd);
        } else {
            process = Runtime.getRuntime()
                    .exec(cmd);
        }
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        new Thread(streamGobbler).start();
        int exitCode = process.waitFor();
        System.out.println(exitCode);
    }
}
