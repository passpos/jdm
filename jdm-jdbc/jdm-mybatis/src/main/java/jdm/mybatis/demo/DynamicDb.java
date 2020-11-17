/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class DynamicDb {

    private SqlSessionFactory ssf;

    public void method() throws IOException {
        String resource = "mybatis/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 这里的属性配置被写死了，实际中可以动态获取；
        Properties properties = new Properties();
        properties.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
        properties.setProperty(
                "jdbc.url",
                "jdbc:mysql://localhost:3306/qmxtest1?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true");
        properties.setProperty("jdbc.username", "root");
        properties.setProperty("jdbc.password", "root");

        ssf = new SqlSessionFactoryBuilder().build(inputStream, properties);

        SqlSession session = ssf.openSession();
        try {
            // GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            // Goods goods = mapper.selectGoods(1);
            // System.out.println("good description:" + goods.getDescription());
        } finally {
            session.close();
        }
    }
}
