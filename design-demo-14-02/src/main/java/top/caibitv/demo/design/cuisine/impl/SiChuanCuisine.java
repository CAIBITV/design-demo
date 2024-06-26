package top.caibitv.demo.design.cuisine.impl;

import top.caibitv.demo.design.cook.ICook;
import top.caibitv.demo.design.cuisine.ICuisine;

public class SiChuanCuisine implements ICuisine {

    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}