/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ESDocTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "person";
    public ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testUpdateDoc() throws IOException {
        // 1. 创建一个Map，指定需要修改的内容
        HashMap<String, Object> doc = new HashMap<>();
        doc.put("age", "47");
        String docId = "1";

        // 2. 创建 request 对象，封装数据
        UpdateRequest uReq = new UpdateRequest(index, docId);
        uReq.doc(doc);

        // 3. 通过 client 执行
        UpdateResponse update = client.update(uReq, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println("testUpdateDoc() - " + update.getResult().toString());
    }

    @Test
    public void testCreateDoc() throws JsonProcessingException, IOException {
        // 1. 准备一个json数据
        Person person = new Person(3, "童柏雄", 39, new Date());
        String json = mapper.writeValueAsString(person);

        // 2. 准备 request 对象
        IndexRequest iRequest = new IndexRequest(index);
        iRequest.id(String.valueOf(person.getId()));
        iRequest.source(json, XContentType.JSON);

        // 3. 通过client去操作
        IndexResponse iResp = client.index(iRequest, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println("testCreateDoc() - " + iResp.getResult().toString());
    }

    @Test
    public void testDeleteDoc() throws IOException {
        // 1. 创建 request 对象
        DeleteRequest dReq = new DeleteRequest(index, "3");

        // 2. 通过 client 执行
        DeleteResponse delete = client.delete(dReq, RequestOptions.DEFAULT);

        // 3. 输出结果
        System.out.println("testDeleteDoc() - " + delete.getResult().toString());
    }

    @Test
    public void testBulkCreateDoc() throws JsonProcessingException, IOException {
        // 1. 准备多个json数据
        Person p1 = new Person(4, "任盈盈", 22, new Date());
        Person p2 = new Person(5, "令狐冲", 24, new Date());
        Person p3 = new Person(6, "田伯光", 31, new Date());
        String j1 = mapper.writeValueAsString(p1);
        String j2 = mapper.writeValueAsString(p2);
        String j3 = mapper.writeValueAsString(p3);

        // 2. 创建 request 实例，
        BulkRequest bReq = new BulkRequest();
        bReq.add(new IndexRequest(index).id(String.valueOf(p1.getId())).source(j1, XContentType.JSON));
        bReq.add(new IndexRequest(index).id(String.valueOf(p2.getId())).source(j2, XContentType.JSON));
        bReq.add(new IndexRequest(index).id(String.valueOf(p3.getId())).source(j3, XContentType.JSON));

        // 3. 用 client 执行
        BulkResponse bResp = client.bulk(bReq, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println("testBulkCreateDoc() - " + bResp.toString());
    }

    @Test
    public void testBulkDeleteDoc() throws JsonProcessingException, IOException {
        // 1. 创建 request 实例，
        BulkRequest bReq = new BulkRequest();
        bReq.add(new DeleteRequest(index, "3"));
        bReq.add(new DeleteRequest(index, "5"));

        // 2. 用 client 执行
        BulkResponse bResp = client.bulk(bReq, RequestOptions.DEFAULT);

        // 3. 输出结果
        System.out.println("testBulkDeleteDoc() - " + bResp.toString());
    }

}
