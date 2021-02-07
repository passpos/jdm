/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.jsoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class Main {

    // 存储位置在文件系统中必须预先存在，否则报错；
    private static String store = "D:\\Jsoup\\";

    public static void main(String[] args) throws MalformedURLException, IOException {
        // 内容页面地址
        String url = "https://mp.weixin.qq.com/s/YPrqMOYYrAtCni2VT8c4jA?";
        Document doc = Jsoup.parse(new URL(url), 10000);

        // 内容所在父节点
        Element content = doc.getElementById("js_content");

        // 所有的内容元素
        Elements imgs = content.getElementsByTag("img");

        int id = 0;
        for (Element img : imgs) {
            // 取得元素的某个属性
            String attr = img.attr("data-src");

            // 取得图片地址
            URL imgUrl = new URL(attr);

            // 输出到文件
            id++;
            output(imgUrl, id);
        }
    }

    public static void output(URL imgUrl, int id) {
        try {
            URLConnection imgConnection = imgUrl.openConnection();
            InputStream is = imgConnection.getInputStream();

            // 存储路径与文件名
            String path = store + id + ".jpg";
            FileOutputStream fos = new FileOutputStream(path);

            // 读取输入流
            int tmp = 0;
            while ((tmp = is.read()) != -1) {
                // 写下输出流
                fos.write(tmp);
            }

            // 下载提示
            String tip = id + ".jpg - 下载完毕！";
            System.out.println(tip);

            fos.close();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
