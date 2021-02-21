package jdm.elasticsearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ESTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "person";
    public ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testConnect() {
        RestHighLevelClient client = ESClient.getClient();
        System.out.println("testConnect() - 连接成功");
    }

    @Test
    public void testCreateIndex() throws IOException {
        if (testExistIndex()) {
            System.out.println("createIndex() - 已经存在索引：" + index);
            return;
        }
        // 1. 准备关于索引的settings
        Settings.Builder settings = Settings.builder()
                .put("number_of_shards", 3)
                .put("number_of_replicas", 1);

        // 2. 映射数据结构
        XContentBuilder mappings = JsonXContent.contentBuilder();

        mappings.startObject().startObject("properties")
                .startObject("name")
                .field("type", "text")
                .endObject()
                .startObject("age")
                .field("type", "integer")
                .endObject()
                .startObject("birthday")
                .field("type", "date")
                .field("format", "yyyy-MM-dd")
                .endObject()
                .endObject().endObject();

        // 3. 将settings 与 mappings 封装到一个Request对象；
        CreateIndexRequest ciRequest = new CreateIndexRequest(index);
        ciRequest.settings(settings).mapping(mappings);

        // 4. 通过client对象，去连接ES并执行创建索引
        CreateIndexResponse resp;

        resp = client.indices().create(ciRequest, RequestOptions.DEFAULT);

        // 5. 输出
        System.out.println("创建索引 - " + resp.toString());
    }

    /**
     * 判断索引是否存在
     * @return
     * @throws IOException
     */
    @Test
    public boolean testExistIndex() throws IOException {
        // 1. 准备 request 对象
        GetIndexRequest iRequest = new GetIndexRequest(index);

        // 2. 通过client去操作
        boolean exists = client.indices().exists(iRequest, RequestOptions.DEFAULT);

        // 3. 输出结果
        System.out.println("testExist() - " + exists);
        return exists;
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    public void testDeleteIndex() throws IOException {
        if (testExistIndex()) {
            System.out.println("testDelete() - 不应删除还有用的索引");
            return;
        }

        // 1. 准备 request 对象
        DeleteIndexRequest diRequest = new DeleteIndexRequest("123");

        // 2. 通过client去操作
        AcknowledgedResponse delete = client.indices().delete(diRequest, RequestOptions.DEFAULT);

        // 3. 输出结果
        System.out.println("testDelete() - " + delete.isAcknowledged());
    }

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
        System.out.println("testCreateDoc() - " + iResp.getResult().toString());;
    }

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
    public void testDeleteDoc() throws IOException {
        // 1. 创建 request 对象
        DeleteRequest dReq = new DeleteRequest(index, "3");

        // 2. 通过 client 执行
        DeleteResponse delete = client.delete(dReq, RequestOptions.DEFAULT);

        // 3. 输出结果
        System.out.println("testDeleteDoc() - " + delete.getResult().toString());
    }

}
