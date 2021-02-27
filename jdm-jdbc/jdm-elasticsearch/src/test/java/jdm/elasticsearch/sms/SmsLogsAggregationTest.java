/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch.sms;

import java.io.IOException;
import jdm.elasticsearch.ESClient;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.range.Range;
import org.elasticsearch.search.aggregations.metrics.Cardinality;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ExtendedStats;
import org.elasticsearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@DisplayName("测试 - SmsLogs - 聚合查询")
public class SmsLogsAggregationTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "sms-logs";

    @Test
    @DisplayName("Cardinality - 去重计数查询")
    public void testCardinality() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testCardinality()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        CardinalityAggregationBuilder cadAgg = AggregationBuilders.cardinality("agg").field("province");

        ssb.aggregation(cadAgg);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 aggregations 中的数据并展示
        Cardinality agg = resp.getAggregations().get("agg");
        long value = agg.getValue();
        System.out.println(value);
    }

    @Test
    @DisplayName("Range - 范围统计查询")
    public void testRange() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testRange()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        IpRangeAggregationBuilder ipRangeAgg = AggregationBuilders.ipRange("agg").field("ipAddr").addUnboundedTo("192.168.5.0").addUnboundedFrom("192.168.5.0");

        ssb.aggregation(ipRangeAgg);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 aggregations 中的数据并展示
        Range agg = resp.getAggregations().get("agg");
        for (Range.Bucket bucket : agg.getBuckets()) {
            String key = bucket.getKeyAsString();
            Object from = bucket.getFrom();
            Object to = bucket.getTo();
            long docCount = bucket.getDocCount();
            System.out.println(String.format("key：%s, from：%s, to：%s, docCount：%s", key, from, to, docCount));
        }
    }

    @Test
    @DisplayName("Statistic - 统计聚合查询")
    public void testStat() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testRange()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ExtendedStatsAggregationBuilder extendedStatsAgg = AggregationBuilders.extendedStats("agg").field("fee");

        ssb.aggregation(extendedStatsAgg);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 aggregations 中的数据并展示
        ExtendedStats agg = resp.getAggregations().get("agg");
        double max = agg.getMax();
        double min = agg.getMin();
        System.out.println("最大值最小值是：" + max + " - " + min);
    }
}
