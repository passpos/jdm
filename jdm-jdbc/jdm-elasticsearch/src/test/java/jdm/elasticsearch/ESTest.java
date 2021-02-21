package jdm.elasticsearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ESTest {

    @Test
    public void testConnect() {
        RestHighLevelClient client = ESClient.getClient();
        System.out.println("OK - 连接成功");
    }
}
