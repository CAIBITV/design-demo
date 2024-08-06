package top.caibitv.demo.design;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JDBCUtil {

    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);

    private static final String URL = "jdbc:mysql://117.72.64.165:23306/ruoyi_pet";

    private static final String USER = "root";

    private static final String PASSWORD = "yyt14588";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获得数据库连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3.操作数据库，实现增删改查
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sys_role");
        // 如果有数据，rs.next()返回true
        while (resultSet.next()) {
            logger.info("测试结果：{}", resultSet.getString("role_name"));
        }
    }
}
