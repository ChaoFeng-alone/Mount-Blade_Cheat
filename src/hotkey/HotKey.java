package hotkey;

import cheat.GodMod;
import cheat.KillAll;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class HotKey {

    public HotKey() {
        JIntellitype.getInstance();
        KillAll.addListener();
        GodMod.addListener();
        KillAll.register();
        GodMod.register();
    }

    public void release(){
        JIntellitype.getInstance().cleanUp();
    }
}
