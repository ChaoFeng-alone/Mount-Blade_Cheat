package cheat;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import hotkey.HotKey;
import main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GodMod {
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
                if (key == 1) {         //你要做的事
                    flag = !flag;
                    if (flag) {
                        System.out.println("无敌已开启");
                        Main.godStart();
                        thread.start();
                    }
                    else {
                        System.out.println("无敌已关闭");
                        Main.godEnd();
                        thread.interrupt();
                    }
                }
            }
        });
    }

    public static synchronized void register() {
        JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_SHIFT, (int) '2');
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!thread.isInterrupted()) {
                    if (flag) {
                        robot.delay(50);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_H);
                        robot.delay(50);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyRelease(KeyEvent.VK_H);
                    }
                }
            }
        });
        System.out.println("register...");
    }
}
