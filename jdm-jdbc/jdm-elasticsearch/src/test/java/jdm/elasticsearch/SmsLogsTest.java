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
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.ClearScrollResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.BoostingQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
@DisplayName("测试 - SmsLogs")
public class SmsLogsTest {

    public RestHighLevelClient client = ESClient.getClient();
    public String index = "sms-logs";
    public ObjectMapper mapper = new ObjectMapper();
    public boolean isCreated = true;
    public SmsLogs s1;
    public SmsLogs s2;
    public SmsLogs s3;
    public SmsLogs s4;
    public SmsLogs s5;
    public SmsLogs s6;
    public SmsLogs s7;
    public SmsLogs s8;
    public SmsLogs s9;
    public SmsLogs s10;
    public SmsLogs s11;
    public SmsLogs s12;

    @Test
    @DisplayName("AddIndex")
    public void testAddIndex() throws IOException {
        if (exist(index)) {
            System.out.println("----------------------------------------");
            System.out.println("testAddIndex() - 已经存在该索引");
            return;
        }

        Settings.Builder settings = Settings.builder()
                .put("number_of_shards", 3)
                .put("number_of_replicas", 1);
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject().startObject("properties")
                .startObject("createDate").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss")
                .endObject()
                .startObject("sendDate").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss")
                .endObject()
                .startObject("longCode").field("type", "keyword")
                .endObject()
                .startObject("mobile").field("type", "keyword")
                .endObject()
                .startObject("corpName").field("type", "keyword")
                // .field("analyzer", "ik_smart") // keyword类型不需要指定分析器
                .endObject()
                .startObject("smsContent").field("type", "text").field("analyzer", "ik_max_word")
                .endObject()
                .startObject("state").field("type", "integer")
                .endObject()
                .startObject("operatorId").field("type", "integer")
                .endObject()
                .startObject("province").field("type", "keyword")
                .endObject()
                .startObject("ipAddr").field("type", "ip")
                .endObject()
                .startObject("replyTotal").field("type", "integer")
                .endObject()
                .startObject("fee").field("type", "integer")
                .endObject()
                .endObject().endObject();

        // 准备创建索引的请求
        CreateIndexRequest ciRequest = new CreateIndexRequest(index);
        ciRequest.settings(settings).mapping(mappings);

        CreateIndexResponse cir = client.indices().create(ciRequest, RequestOptions.DEFAULT);

        System.out.println("创建索引 - " + cir.toString());
    }

    @Disabled
    private boolean exist(String indices) throws IOException {
        GetIndexRequest iRequest = new GetIndexRequest(indices);
        boolean exists = client.indices().exists(iRequest, RequestOptions.DEFAULT);
        return exists;
    }

    @Test
    public void testAddData() throws JsonProcessingException, IOException {
        if (isCreated) {
            System.out.println("----------------------------------------");
            System.out.println("testAddData() - 已经创建了所有的文档！");
            return;
        }
        fillData();

        String j1 = mapper.writeValueAsString(s1);
        String j2 = mapper.writeValueAsString(s2);
        String j3 = mapper.writeValueAsString(s3);
        String j4 = mapper.writeValueAsString(s4);
        String j5 = mapper.writeValueAsString(s5);
        String j6 = mapper.writeValueAsString(s6);
        String j7 = mapper.writeValueAsString(s7);
        String j8 = mapper.writeValueAsString(s8);
        String j9 = mapper.writeValueAsString(s9);
        String j10 = mapper.writeValueAsString(s10);
        String j11 = mapper.writeValueAsString(s11);
        String j12 = mapper.writeValueAsString(s12);

        BulkRequest br = new BulkRequest();
        br.add(new IndexRequest(index).id(s1.getId()).source(j1, XContentType.JSON));
        br.add(new IndexRequest(index).id(s2.getId()).source(j2, XContentType.JSON));
        br.add(new IndexRequest(index).id(s3.getId()).source(j3, XContentType.JSON));
        br.add(new IndexRequest(index).id(s4.getId()).source(j4, XContentType.JSON));
        br.add(new IndexRequest(index).id(s5.getId()).source(j5, XContentType.JSON));
        br.add(new IndexRequest(index).id(s6.getId()).source(j6, XContentType.JSON));
        br.add(new IndexRequest(index).id(s7.getId()).source(j7, XContentType.JSON));
        br.add(new IndexRequest(index).id(s8.getId()).source(j8, XContentType.JSON));
        br.add(new IndexRequest(index).id(s9.getId()).source(j9, XContentType.JSON));
        br.add(new IndexRequest(index).id(s10.getId()).source(j10, XContentType.JSON));
        br.add(new IndexRequest(index).id(s11.getId()).source(j11, XContentType.JSON));
        br.add(new IndexRequest(index).id(s12.getId()).source(j12, XContentType.JSON));

        BulkResponse bResp = client.bulk(br, RequestOptions.DEFAULT);
        System.out.println("testAddData() - " + bResp.toString());
    }

    @Disabled
    private void fillData() throws JsonProcessingException {
        s1 = new SmsLogs("1", new Date(), new Date(),
                "663-79663-1111", "137-791-37791", "贵州茅台",
                "本榜由中金公司财富管理部与《财富》(中文版)合作编制完成。中金公司财富管理业务致力于为高端个人及企业投资者提供具有国际水准的财富管理服务，依托专业的财富研究团队，为客户提供全方位的资本市场综合解决方案，并多次荣获“中国最佳财富管理机构”等专业奖项。",
                0, 1, "北京市",
                "192.168.1.2", 0, 56);
        s2 = new SmsLogs("2", new Date(), new Date(),
                "663-79663-2222", "137-791-37792", "工商银行",
                "本排行榜覆盖范围包括在中国境内外上市的所有中国公司，按2019年财务年度的营业收入对公司进行排名。 ",
                0, 2, "河北省",
                "192.168.0.7", 0, 10);
        s3 = new SmsLogs("3", new Date(), new Date(),
                "663-79663-3333", "137-791-37793", "招商银行",
                "本榜所依据数据为上市公司在各证券交易所正式披露的2019年年报。 ",
                0, 1, "黑龙江省",
                "192.168.0.6", 0, 45);
        s4 = new SmsLogs("4", new Date(), new Date(),
                "663-79663-4444", "137-791-37794", "农业银行",
                "本榜以人民币为统一计价标准；除另有注明外，营收与利润所涉及人民币汇率均按2019年平均汇率（中国人民银行公布的交易中间价）换算，其中：1港币= 0.8805元人民币；1美元= 6.8985元人民币；1新加坡元= 5.0596元人民币；总资产与股东权益所涉及人民币汇率均按2019年最后一个交易日中国人民银行公布的交易中间价换算。 ",
                0, 3, "云南省",
                "192.168.3.55", 0, 0);
        s5 = new SmsLogs("5", new Date(), new Date(),
                "663-79663-5555", "137-791-37795", "中国平安",
                "本榜所采用财务数据，以该公司公布的中国国内会计准则核算之数据为首选，以国际会计准则核算之数据为候选。 ",
                0, 1, "贵州省",
                "192.168.126.2", 0, 87);
        s6 = new SmsLogs("6", new Date(), new Date(),
                "663-79663-6666", "137-791-37796", "中国人寿",
                "本榜所采用的市值数据以该公司2019年最后一个交易日收盘价数据为准，对于多地上市公司，区分不同地区上市的股份价格和股份数量分别计算市值，然后加总。 2020年新上市公司，采用上市首日收盘价计算市值。 ",
                0, 2, "",
                "192.168.0.33", 0, 121);
        s7 = new SmsLogs("7", new Date(), new Date(),
                "663-79663-7777", "137-791-37797", "中国石油",
                "本榜排名不构成对相关公司二级市场的任何操作建议。",
                0, 3, "宁夏回族自治区",
                "192.168.6.48", 0, 12);
        s8 = new SmsLogs("8", new Date(), new Date(),
                "663-79663-8888", "137-791-37798", "中国银行",
                "凡财务年度截至日非12月31日的公司均按其季报及中报数据调整为自然年度对应数据，如阿里巴巴和玖龙纸业。 ",
                1, 3, "吉林省",
                "192.168.44.15", 0, 4);
        s9 = new SmsLogs("9", new Date(), new Date(),
                "663-79663-9999", "137-791-37799", "中国中免",
                "本排行榜统计截止日为2020年5月15日，部分去年上榜公司，如中国燃气，北大资源和中国金属利用等因未发年报未纳入统计范围。 ",
                0, 2, "福建省",
                "192.168.1.64", 0, 0);
        s10 = new SmsLogs("10", new Date(), new Date(),
                "663-79663-0000", "137-791-37700", "海天味业",
                "中金公司财富管理股票研究团队解读了榜单中所反映的行业趋势。",
                0, 2, "海南省",
                "192.168.56.58", 0, 9);
        s11 = new SmsLogs("11", new Date(), new Date(),
                "663-79664-1111", "137-791-37701", "中国建筑股份有限公司",
                "2020年中国500强上榜公司总收入达到了50.5万亿元，收入同比增长11%，同时榜单的净利润率水平受到宏观经济环境企稳和中美贸易摩擦略有缓和等因素的拉动，从去年的8.0%上升到本年的8.4%。从行业角度看，地产行业仍然是入榜公司最多的行业，今年共有53家地产公司上榜，收入总额达到4.5万亿元，较去年的3.7万亿元有显著增长。但受到地产周期的影响，地产行业的净利率从去年的10.2%下降至今年的9.7%。另外在2019年货币政策中性偏松的背景下，上榜金融企业的收入达到9.4万亿元，较去年的8.3万亿元增长了13%，净利润角度也实现了同步的增长。",
                0, 1, "四川省",
                "192.168.156.156", 0, 5);
        s12 = new SmsLogs("12", new Date(), new Date(),
                "663-79664-2222", "137-791-37702", "中国中铁股份有限公司",
                "2019年是中央经济工作会议部署“新基建”后的元年，但因其在固定资产投资中的绝对占比较低，因此在实现经济“稳增长”的过程中，“老基建”仍发挥着不可或缺的作用。根据《财富》（中文版）杂志的行业分类标准，2020年中国500强榜单里“老基建”的相关行业基建、建筑、电力、工程机械、港口、物流的收入总额达到8.6万亿元，较去年的7.4万亿元同比增长17.7%，表明该行业仍是经济稳定增长的重要支柱之一。",
                0, 2, "江西省",
                "192.16.0.45", 0, 23);

    }

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
        ssb.query(QueryBuilders.termQuery("province", "北京市"));

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
        ssb.query(QueryBuilders.termsQuery("province", "北京市", "海南省", "河北省"));

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
        ssb.query(QueryBuilders.matchQuery("smsContent", "中国公司"));

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
        ssb.query(QueryBuilders.matchAllQuery());
        ssb.size(15);   // 展示超过10条数据；
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
        ssb.query(QueryBuilders.matchQuery("smsContent", "中国 排行榜").operator(Operator.AND));

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
        ssb.query(QueryBuilders.multiMatchQuery("中国公司", "smsContent", "province"));

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
        ssb.query(QueryBuilders.idsQuery().addIds("1", "2"));

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
        ssb.query(QueryBuilders.prefixQuery("corpName", "中"));

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
        ssb.query(QueryBuilders.fuzzyQuery("corpName", "招商银航").prefixLength(2));

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
        ssb.query(QueryBuilders.fuzzyQuery("corpName", "招商银航").prefixLength(2));

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
        ssb.query(QueryBuilders.rangeQuery("fee").gte(5).lte(10));

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
        ssb.query(QueryBuilders.regexpQuery("mobile", "139[0-9]{8}"));

        sr.source(ssb);

        // 3. 执行查询
        SearchResponse resp = client.search(sr, RequestOptions.DEFAULT);

        // 4. 获取到 _source 中的数据并展示
        SearchHit[] hits = resp.getHits().getHits();
        System.out.println("hits.length - " + hits.length);
    }

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
            if (nextResp.getHits().getHits() != null && nextResp.getHits().getHits().length > 0) {
                System.out.println("-----------------next----------------");
                System.out.println(resp1.getHits().getHits().length);
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

    @Disabled
    @DisplayName("DeleteByQuery")
    public void testDeleteByQuery() throws IOException {
        System.out.println("--------------------------------------------");
        System.out.println("testDeleteByQuery()");

        // 1. 创建 Request 对象
        DeleteByQueryRequest req = new DeleteByQueryRequest(index);

        // 2. 指定检索条件（和SearchRequest指定的方式不一样）
        req.setQuery(QueryBuilders.rangeQuery("fee").lt(4));

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
        BoolQueryBuilder bqb = QueryBuilders.boolQuery();

        // 查询省份为河北省或北京市；
        bqb.should(QueryBuilders.termQuery("province", "河北省"));
        bqb.should(QueryBuilders.termQuery("province", "北京市"));

        // 运营商不是联通；
        bqb.mustNot(QueryBuilders.termQuery("operatorId", 2));

        bqb.must(QueryBuilders.matchQuery("smsContent", "中国"));
        bqb.must(QueryBuilders.matchQuery("smsContent", "排行榜"));

        ssb.query(bqb);
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
        BoostingQueryBuilder bqb = QueryBuilders.boostingQuery(
                QueryBuilders.matchQuery("smsContent", "增长"),
                QueryBuilders.matchQuery("smsContent", "下降"))
                .negativeBoost(0.5f);

        ssb.query(bqb);
        req.source(ssb);

        // 3. 执行查询与删除操作
        SearchResponse resp = client.search(req, RequestOptions.DEFAULT);

        // 4. 输出结果
        System.out.println(resp.getHits().getHits().length);
    }
}
