package top.caibitv.demo.design;

import org.junit.Test;
import top.caibitv.demo.design.util.Topic;
import top.caibitv.demo.design.util.TopicRandomUtil;

import java.util.HashMap;
import java.util.Map;

public class QuestionBankControllerTest {

    @Test
    public void test_QuestionBank() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
    }

    @Test
    public void test1() {
        Map<String, String> map01 = new HashMap<String, String>();
        map01.put("哈", "JAVA2 EE");
        map01.put("你", "JAVA2 Card");
        map01.put("吗", "JAVA2 ME");
        map01.put("拉", "JAVA2 SE");
        map01.put("哦", "JAVA2 HE");
        System.out.println(map01);
        Topic d = TopicRandomUtil.random(map01, "吗");
        System.out.println(d.getOption());
        System.out.println(d.getKey());
    }
}