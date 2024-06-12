package top.caibitv.demo.design.cook.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.caibitv.demo.design.cook.ICook;

public class JiangSuCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
    }

}
