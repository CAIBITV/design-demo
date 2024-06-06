package top.caibitv.demo.design;

import org.junit.Test;
import top.caibitv.demo.design.channel.Pay;
import top.caibitv.demo.design.channel.WxPay;
import top.caibitv.demo.design.channel.ZfbPay;
import top.caibitv.demo.design.mode.PayFaceMode;
import top.caibitv.demo.design.mode.PayFingerprintMode;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void test_pay() {
        System.out.println("\r\n模拟测试场景：微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景：支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }
}
