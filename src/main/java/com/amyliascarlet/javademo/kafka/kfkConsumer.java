package com.amyliascarlet.javademo.kafka;

import com.amyliascarlet.lib.log.Log;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class kfkConsumer {
    private static kafka.javaapi.consumer.ConsumerConnector consumer = null;

    public static void main(String[] args) {
        Properties props = new Properties();
        // zookeeper 配置
        props.put("zookeeper.connect", "127.0.0.1:2188");
        // group 代表一个消费组
        props.put("group.id", "jd-group");
        // zk连接超时
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        // 序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        ConsumerConfig config = new ConsumerConfig(props);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put("test", new Integer(1));
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
        Map<String, List<KafkaStream<String, String>>> consumerMap =
                consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get("test").get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext())
            Log.i(it.next().message());

    }
}
