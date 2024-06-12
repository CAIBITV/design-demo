package top.caibitv.demo.design;

import org.junit.Test;
import top.caibitv.demo.design.cook.impl.GuangDongCook;
import top.caibitv.demo.design.cook.impl.JiangSuCook;
import top.caibitv.demo.design.cook.impl.ShanDongCook;
import top.caibitv.demo.design.cook.impl.SiChuanCook;
import top.caibitv.demo.design.cuisine.ICuisine;
import top.caibitv.demo.design.cuisine.impl.GuangDoneCuisine;
import top.caibitv.demo.design.cuisine.impl.JiangSuCuisine;
import top.caibitv.demo.design.cuisine.impl.ShanDongCuisine;
import top.caibitv.demo.design.cuisine.impl.SiChuanCuisine;

import static org.junit.Assert.*;

public class ApiTest {

    @Test
    public void test() {

        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }

}