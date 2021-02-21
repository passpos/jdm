/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ESClient {

    public static RestHighLevelClient getClient() {
        HttpHost httpHost = new HttpHost("127.0.0.1", 9602);
        RestClientBuilder rcb = RestClient.builder(httpHost);
        RestHighLevelClient client = new RestHighLevelClient(rcb);
        return client;
    }
}
