package top.caibitv.demo.design;

import top.caibitv.demo.design.ui.Player;
import top.caibitv.demo.design.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
