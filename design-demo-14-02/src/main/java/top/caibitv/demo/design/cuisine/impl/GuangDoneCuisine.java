package top.caibitv.demo.design.cuisine.impl;

import top.caibitv.demo.design.cook.ICook;
import top.caibitv.demo.design.cuisine.ICuisine;

public class GuangDoneCuisine implements ICuisine {

    private ICook cook;

    public GuangDoneCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
