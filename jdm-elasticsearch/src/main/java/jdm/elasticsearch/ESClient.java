/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ESClient {

    public static RestHighLevelClient getClient() {
        // 目标主机
        HttpHost httpHost = new HttpHost("127.0.0.1", 9602);

        RestClientBuilder rcb = RestClient.builder(httpHost);

        // 添加用户认证（如果未开启x-pack安全性，可以省略）
        UsernamePasswordCredentials upc = new UsernamePasswordCredentials("elastic", "elasticpw");
        BasicCredentialsProvider bcp = new BasicCredentialsProvider();
        bcp.setCredentials(AuthScope.ANY, upc);

        rcb.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                httpClientBuilder.disableAuthCaching();
                return httpClientBuilder.setDefaultCredentialsProvider(bcp);
            }
        });

        // REST客户端
        RestHighLevelClient client = new RestHighLevelClient(rcb);
        return client;
    }
}
