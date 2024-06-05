package top.caibitv.demo.design;

import org.junit.Test;

import java.util.Map;

public class ApiTest {

    @Test
    public void test() {
        Map<String, String> cache = Singleton_00.cache;
    }

    @Test
    public void test2() {
        Singleton_07.INSTANCE.test();
    }
}
