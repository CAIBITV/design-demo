package top.caibitv.demo.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.caibitv.demo.design.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * 饭店小儿，负责点菜
 */
public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }

}
