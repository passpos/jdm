/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch.sms;

import java.io.IOException;
import jdm.elasticsearch.ESClient;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.BoostingQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.RegexpQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@DisplayName("测试 - SmsLogs - Query")
public class SmsLogsQueryTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "sms-logs";

    @Test
    public void testTermQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testTermQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.from(0);
        ssb.size(5);
        TermQueryBuilder termQuery = QueryBuilders.termQuery("province", "北京市");

        ssb.query(termQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void testTermsQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testTermsQuery()");
        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.from(0);
        ssb.size(5);
        TermsQueryBuilder termsQuery = QueryBuilders.termsQuery("province", "北京市", "海南省", "河北省");

        ssb.query(termsQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    public void testMatchQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testMatchQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("smsContent", "中国公司");

        ssb.query(matchQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    public void testMatchAllQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testMatchAllQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        ssb.size(15);   // 展示超过10条数据；
        MatchAllQueryBuilder matchAllQuery = QueryBuilders.matchAllQuery();
        ssb.query(matchAllQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    public void testBooleanMatchQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testBooleanMatchQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("smsContent", "中国 排行榜").operator(Operator.AND);

        ssb.query(matchQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    public void testMultiMatchQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testMultiMatchQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery("中国公司", "smsContent", "province");

        ssb.query(multiMatchQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    public void testIdQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testIdQuery()");

        // 1. 创建 Request 对象
        GetRequest gr = new GetRequest(index, "1");

        // 3. 执行查询
        GetResponse resp = client.get(gr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        System.out.println(resp.getSourceAsMap());
    }

    @Test
    public void testIdsQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testIdsQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        IdsQueryBuilder idsQuery = QueryBuilders.idsQuery().addIds("1", "2");

        ssb.query(idsQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    @DisplayName("PrefixQuery")
    public void testPrefixQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testPrefixQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        PrefixQueryBuilder prefixQuery = QueryBuilders.prefixQuery("corpName", "中");

        ssb.query(prefixQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    @DisplayName("FuzzyQuery")
    public void testFuzzyQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testFuzzyQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("corpName", "招商银航").prefixLength(2);

        ssb.query(fuzzyQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    @DisplayName("WildcardQuery")
    public void testWildcardQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testWildcardQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        WildcardQueryBuilder wildcardQuery = QueryBuilders.wildcardQuery("corpName", "招商银*");

        ssb.query(wildcardQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    @DisplayName("RangeQuery")
    public void testRangeQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testRangeQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("fee").gte(5).lte(10);

        ssb.query(rangeQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Test
    @DisplayName("RegexpQuery")
    public void testRegexpQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testRegexpQuery()");

        // 1. 创建 Request 对象
        SearchRequest sr = new SearchRequest(index);

        // 2. 指定查询条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        RegexpQueryBuilder regexpQuery = QueryBuilders.regexpQuery("mobile", "139[0-9]{8}");

        ssb.query(regexpQuery);
        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

    @Disabled
    @DisplayName("DeleteByQuery")
    public void testDeleteByQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testDeleteByQuery()");

        // 1. 创建 Request 对象
        DeleteByQueryRequest req = new DeleteByQueryRequest(index);

        // 2. 指定检索条件（和SearchRequest指定的方式不一样）
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("fee").lt(4);
        req.setQuery(rangeQuery);

        // 3. 执行查询与删除操作
        BulkByScrollResponse resp = client.deleteByQuery(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println(resp.toString());
    }

    @Test
    @DisplayName("BoolQuery")
    public void testBoolQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testBoolQuery()");

        // 1. 创建 Request 对象
        SearchRequest req = new SearchRequest(index);

        // 2. 指定检索条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        // 查询省份为河北省或北京市；
        boolQuery.should(QueryBuilders.termQuery("province", "河北省"));
        boolQuery.should(QueryBuilders.termQuery("province", "北京市"));

        // 运营商不是联通；
        boolQuery.mustNot(QueryBuilders.termQuery("operatorId", 2));

        boolQuery.must(QueryBuilders.matchQuery("smsContent", "中国"));
        boolQuery.must(QueryBuilders.matchQuery("smsContent", "排行榜"));

        ssb.query(boolQuery);
        req.source(ssb);

        // 3. 执行查询与删除操作
        SearchResponse resp = client.search(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println(resp.getHits().getHits().length);
    }

    @Test
    @DisplayName("BoostingQuery")
    public void testBoostingQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testBoostingQuery()");

        // 1. 创建 Request 对象
        SearchRequest req = new SearchRequest(index);

        // 2. 指定检索条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        BoostingQueryBuilder boostingQuery = QueryBuilders.boostingQuery(
                QueryBuilders.matchQuery("smsContent", "增长"),
                QueryBuilders.matchQuery("smsContent", "下降"))
                .negativeBoost(0.5f);

        ssb.query(boostingQuery);
        req.source(ssb);

        // 3. 执行查询与删除操作
        SearchResponse resp = client.search(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println(resp.getHits().getHits().length);
    }

    @Test
    @DisplayName("Filter")
    public void testFilter() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testFilter()");

        // 1. 创建 Request 对象
        SearchRequest req = new SearchRequest(index);

        // 2. 指定检索条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.filter(QueryBuilders.termQuery("corpName", "贵州茅台"));
        boolQuery.filter(QueryBuilders.rangeQuery("fee").lte(100));

        ssb.query(boolQuery);
        req.source(ssb);

        // 3. 执行查询与删除操作
        SearchResponse resp = client.search(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println(resp.getHits().getHits().length);
    }

    @Test
    @DisplayName("HighLightQuery")
    public void testHighLightQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testHighLightQuery()");

        // 1. 创建 Request 对象
        SearchRequest req = new SearchRequest(index);

        // 2. 指定检索条件
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("smsContent", "中金公司");

        HighlightBuilder highlight = new HighlightBuilder();
        highlight.field("smsContent", 10)
                .preTags("<font color='red'>")
                .postTags("</font>");

        ssb.query(matchQuery);
        ssb.highlighter(highlight);
        req.source(ssb);

        // 3. 执行查询与删除操作
        SearchResponse resp = client.search(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        for (SearchHit hit : resp.getHits().getHits()) {
            System.out.println(hit.getHighlightFields().get("smsContent"));

        }
    }
}
