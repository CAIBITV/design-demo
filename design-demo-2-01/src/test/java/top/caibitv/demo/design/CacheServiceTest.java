package top.caibitv.demo.design;

import org.junit.Test;
import top.caibitv.demo.design.cuisine.impl.CacheServiceImpl;

public class CacheServiceTest {

    @Test
    public void test_CacheService() {
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("user_name_01", "小傅哥", 1);
        String val01 = cacheService.get("user_name_01", 1);
        System.out.println(val01);
    }

}