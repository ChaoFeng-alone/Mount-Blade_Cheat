package cheat;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KillAll {
    private static boolean flag = false;
    private static Robot robot;
    private static Thread thread;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void addListener() {
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int key) {
                if (key == 0) {         //你要做的事
                    flag = !flag;
                    if (flag) {
                        System.out.println("杀人已开启");
                        Main.killStart();
                        thread.start();
                    }
                    else {
                        System.out.println("杀人已关闭");
                        Main.killEnd();
                        thread.interrupt();
                    }
                }
            }
        });
    }

    public static synchronized void register() {
        JIntellitype.getInstance().registerHotKey(0, JIntellitype.MOD_SHIFT, (int) '1');
       thread= new Thread(new Runnable() {
            @Override
            public void run() {
                while (!thread.isInterrupted()) {
                    if (flag) {
                        robot.delay(50);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_F4);
                        robot.delay(50);
                        robot.keyRelease(KeyEvent.VK_F4);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                    }
                }
            }
        });
        System.out.println("register...");
    }
}
