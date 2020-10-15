/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.dom4j;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class Test {

    private static Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        //error级别的信息，参数就是你输出的信息
        logger.error("Did it again!");

        //info级别的信息
        logger.info("我是info信息");

        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.fatal("我是fatal信息");
        //这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        logger.log(Level.TRACE, "我是debug信息");
    }

}
