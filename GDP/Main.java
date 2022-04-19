

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<ZeichenTool> tools = new ArrayList<ZeichenTool>();
        tools.add(new ZeichenToolLinie());
        tools.add(new ZeichenToolKreis());
        tools.add(new ZeichenToolRechteck());
        tools.add(new ZeichenToolVerschieben());
        ZeichenBlatt zeichenBlatt = new ZeichenBlatt();
        Gui.create(tools, zeichenBlatt);
    }

}
