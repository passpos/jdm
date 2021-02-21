package jdm.elasticsearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ESTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "man";

    @Test
    public void testConnect() {
        RestHighLevelClient client = ESClient.getClient();
        System.out.println("testConnect() - 连接成功");
    }

    @Test
    public void testExist() throws IOException {
        // 1. 准备request对象
        GetIndexRequest iRequest = new GetIndexRequest(index);

        // 2. 通过client去操作
        boolean exists = client.indices().exists(iRequest, RequestOptions.DEFAULT);

        // 3. 输出
        System.out.println("testExist() - " + exists);
    }
}
