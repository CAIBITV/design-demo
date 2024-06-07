package top.caibitv.demo.design;
import org.junit.Test;
import org.springframework.util.StringUtils;
import top.caibitv.demo.design.door.config.StarterService;

import java.util.Arrays;

public class ApiTest {

    @Test
    public void test_StarterService() {
        String str = "1001,aaaa,ccc";
        String[] split = str.split(",");
        System.out.println("split = " + Arrays.toString(split));
    }
}
