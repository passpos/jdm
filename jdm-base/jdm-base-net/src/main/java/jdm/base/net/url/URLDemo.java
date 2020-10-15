/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.base.net.url;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdm.utils.demo.AbstractDemo;

/**
 * 注意URL与File的区别。
 * 要将文件路径当做URL参数，需要在文件路径前加“file:”或“file:/”前缀；
 *
 * URL支持的协议：http、https、file、jar
 *
 * @author realpai <paiap@outlook.com>
 */
public class URLDemo extends AbstractDemo {

    public static void main(String[] args) {
        new URLDemo().index();
    }

    @Override
    public void index() {
        try {
            baseDemo();
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URLDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ant项目中，“相对路径”是相对于“包”的根；
     * Maven项目中，不能单独使用相对路径，必须搭配“file:”，相对于项目的根；
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    public void baseDemo() throws MalformedURLException, IOException {
        URL url1 = new URL("http://www.baidu.com/index.html");
        URL url2 = new URL("file:D:/stylus-2020-04-18.json");
        URL url3 = new URL("file:src/fav.jpg");
        URL url4 = getClass().getClassLoader().getResource("src/3.jpg");
    }
}
