/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch.sms;

import java.io.IOException;
import java.util.ArrayList;
import jdm.elasticsearch.ESClient;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.GeoPolygonQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@DisplayName("测试 - SmsLogs - 经纬度查询")
public class SmsLogsGeoTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "sms-logs";

    public void testAddData() {

    }

    @Test
    public void testGeo() throws IOException {
        // 1. 创建 SearchRequest
        SearchRequest req = new SearchRequest(index);

        // 2. 指定检索方式
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ArrayList<GeoPoint> points = new ArrayList<>();
        points.add(new GeoPoint(0, 0));
        points.add(new GeoPoint(0, 0));
        points.add(new GeoPoint(0, 0));
        GeoPolygonQueryBuilder geoPolygonQuery = QueryBuilders.geoPolygonQuery("location", points);

        ssb.query(geoPolygonQuery);
        req.source(ssb);

        // 3. 执行检索
        SearchResponse resp = client.search(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        for (SearchHit hit : resp.getHits().getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

}
