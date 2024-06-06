package top.caibitv.demo.design.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.caibitv.demo.design.mode.IPayMode;

import java.math.BigDecimal;

public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
