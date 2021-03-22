/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.advance;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import test.basic.UserDaoTest;

/**
 * 逆向工程
 *
 * @author passpos <paiap@outlook.com>
 */
public class GenaratorTest {

    public void generator() {
        // 加载配置
        String genConf = "generator.xml";
        File conf = new File(UserDaoTest.class.getClassLoader().getResource(genConf).getFile());

        ArrayList<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);

        // 解析配置
        Configuration config = null;
        try {
            config = cp.parseConfiguration(conf);
        } catch (IOException | XMLParserException ex) {
            Logger.getLogger(UserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (config == null) {
            return;
        }

        // 为注册对象生成回调；
        boolean overwrite = true;
        DefaultShellCallback dsCallback = new DefaultShellCallback(overwrite);

        // 生成注册对象
        MyBatisGenerator mbGenerator = null;
        try {
            mbGenerator = new MyBatisGenerator(config, dsCallback, warnings);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(UserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mbGenerator == null) {
            return;
        }

        // 执行注册
        try {
            mbGenerator.generate(null);
        } catch (SQLException | IOException | InterruptedException ex) {
            Logger.getLogger(UserDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
