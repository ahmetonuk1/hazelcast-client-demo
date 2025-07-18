package org.i2i.kotam;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.i2i.kotam.utils.configurations.Configuration;

public class Main {
    public static void main(String[] args) {
        try {
            HazelcastInstance client = Configuration.getHazelcastInstance();
            System.out.println("Hazelcast client connected successfully!");

            IMap<String, String> testMap = client.getMap("test-map");

            testMap.put("message", "Hazelcast connection successful!");
            String result = testMap.get("message");

            System.out.println("Data received from Map: " + result);
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}