package com.amyliascarlet.javademo.elasticsearch;

import com.amyliascarlet.lib.log.Log;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Elasticsearch {

    private final static String HOST = "127.0.0.1";
    private final static int PORT = 9300;

    public Elasticsearch()
    {
        // 创建客户端
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                                .addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (client != null) {
            Log.d("Elasticsearch connect info:" + client.toString());
        }


        //创建文档
        //{id:"1",title:"xxx",content:"xxxxxx"}
        XContentBuilder builder= null;
        try {
            builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("id","1")
                    .field("name","nick")
                    .field("talk","hello world")
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建索引库及添加文档
        if (client != null) {
            IndexResponse response = client.prepareIndex("class","classmate","1").setSource(builder).get();

            //查询全部对象
            SearchResponse searchResponse=client.prepareSearch("class").setTypes("classmate").setQuery(QueryBuilders.matchAllQuery())
                    .get();

            //字符串查询
            SearchResponse searchResponse2 = client.prepareSearch("class").setTypes("classmate")
                    .setQuery(QueryBuilders.queryStringQuery("nick")).get();

            //词条查询
            SearchResponse searchResponse3 = client.prepareSearch("class").setTypes("classmate")
                    .setQuery(QueryBuilders.termQuery("id","1")).get();

            //词条查询
            SearchResponse searchResponse4 = client.prepareSearch("class").setTypes("classmate")
                    .setQuery(QueryBuilders.wildcardQuery("des","*hello*")).get();

            printAll(searchResponse);
            printAll(searchResponse2);
            printAll(searchResponse3);
            printAll(searchResponse4);


            // 关闭客户端
            client.close();



        }



    }

    private void printAll(SearchResponse searchResponse){
        SearchHits hits=searchResponse.getHits();//表示查询到的文档
        for (SearchHit hit : hits) {
            Log.d(hit.getSourceAsString());
            Log.d(hit.getSource().get("id"));
            Log.d("=================================");
        }

    }

}
