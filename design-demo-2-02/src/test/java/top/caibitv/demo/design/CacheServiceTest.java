package top.caibitv.demo.design;


import org.junit.Test;
import top.caibitv.demo.design.factory.JDKProxy;
import top.caibitv.demo.design.factory.impl.EGMCacheAdapter;
import top.caibitv.demo.design.factory.impl.IIRCacheAdapter;
import top.caibitv.demo.design.impl.CacheServiceImpl;

public class CacheServiceTest {

    @Test
    public void test_CacheService() throws Exception {

        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);

    }
}