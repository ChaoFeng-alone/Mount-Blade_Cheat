package main;

import hotkey.HotKey;
import win.Window;

import javax.swing.*;

public class Main {
    public static Object lock = 1;
    public static HotKey hotKey;
    public static Window window;
    public static void main(String[] args) {
        hotKey = new HotKey();

        window = new Window();
    }

    public static void killStart(){
        window.setKillCheckBox(true);
    }
    public static void killEnd(){
        window.setKillCheckBox(false);
    }

    public static void godStart(){
        window.setGodCheckBox(true);
    }
    public static void godEnd(){
        window.setGodCheckBox(false);
    }
}
