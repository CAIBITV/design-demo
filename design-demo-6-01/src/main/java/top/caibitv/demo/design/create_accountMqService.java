package top.caibitv.demo.design;

import com.alibaba.fastjson.JSON;
import top.caibitv.demo.design.mq.create_account;

public class create_accountMqService {

    public void onMessage(String message) {

        create_account mq = JSON.parseObject(message, create_account.class);

        mq.getNumber();
        mq.getAccountDate();

        // ... 处理自己的业务
    }

}
