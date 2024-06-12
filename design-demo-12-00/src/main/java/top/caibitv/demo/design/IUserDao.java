package top.caibitv.demo.design;

import top.caibitv.demo.design.agent.Select;

public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
