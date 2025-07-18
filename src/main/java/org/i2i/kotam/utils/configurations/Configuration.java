package org.i2i.kotam.utils.configurations;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;

public class Configuration {
    private static HazelcastInstance hazelcastInstance;

    public static HazelcastInstance getHazelcastInstance() {
        if (hazelcastInstance == null) {
            try {
                ClientConfig config = new XmlClientConfigBuilder().build(); // src/main/resources içindeki XML'i okur
                hazelcastInstance = HazelcastClient.newHazelcastClient(config);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Hazelcast client didn't start.", e);
            }
        }
        return hazelcastInstance;
    }
}
