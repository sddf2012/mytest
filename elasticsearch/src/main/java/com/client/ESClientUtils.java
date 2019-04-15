package com.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author liu peng bo
 * @date 2018/8/1
 */
public class ESClientUtils {
    private ESClientUtils() {

    }

    private static class Inner {
        private static final Client CLIENT = getTransportClient();

        private static TransportClient getTransportClient() {
            Settings settings = Settings.builder()
                    .put("cluster.name", "myElasticSearch").put("client.transport.sniff", true).build();
            TransportClient client = null;
            try {
                client = new PreBuiltTransportClient(settings)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            return client;

        }
    }

    public static Client getTransportClient() {
        return Inner.CLIENT;
    }

}
