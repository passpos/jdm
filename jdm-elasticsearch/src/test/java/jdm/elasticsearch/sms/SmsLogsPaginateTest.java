/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch.sms;

import java.io.IOException;
import jdm.elasticsearch.ESClient;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.ClearScrollResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@DisplayName("@DisplayName测试 - SmsLogs - 分页查询")
public class SmsLogsPaginateTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "sms-logs";

    @Test
    @DisplayName("Scroll")
    public void testScroll() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testScroll()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定scroll信息
        sr.scroll(TimeValue.timeValueMinutes(1));

        // 3. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.size(2);
        ssb.sort("fee", SortOrder.DESC);
        ssb.query(QueryBuilders.matchAllQuery());

        sr.source(ssb);

        // 4. 执行查询，获取返回结果以及scrollId
        SearchResponse resp1 = client.search(sr, RequestOptions.DEFAULT);
        String scrollId = resp1.getScrollId();
        System.out.println("--------------------first--------------------");
        System.out.println(resp1.getHits().getHits().length);

        while (true) {
            // 5. 循环 - 创建 SearchScrollRequest
            SearchScrollRequest ssr = new SearchScrollRequest(scrollId);

            // 6. 指定 scrollId 的生存时间
            ssr.scroll(TimeValue.timeValueMinutes(1L));

            // 7. 执行查询，获取返回结果
            SearchResponse nextResp = client.scroll(ssr, RequestOptions.DEFAULT);
            SearchHit[] hits = nextResp.getHits().getHits();

            // 8. 判断是否查询到了数据，输出
            if (hits != null && nextResp.getHits().getHits().length > 0) {
                System.out.println("-----------------next----------------");
                System.out.println(hits.length);
            } else {
                // 9. 判断没有查询到数据就——退出循环
                System.out.println("-----------------over----------------");
                break;
            }
        }
        // 10. 创建 ClearScrollRequest
        ClearScrollRequest csr = new ClearScrollRequest();
        csr.addScrollId(scrollId);

        // 11. 删除ScrollId
        ClearScrollResponse csResp = client.clearScroll(csr, RequestOptions.DEFAULT);

        // 12. 输出结果
        System.out.println("删除scroll：" + csResp.isSucceeded());
    }

}
