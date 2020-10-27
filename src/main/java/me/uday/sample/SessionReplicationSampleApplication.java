package me.uday.sample;

import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.web.WebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class SessionReplicationSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionReplicationSampleApplication.class, args);
	}

	@Bean
	public Config config() {
		return new Config();
	}

	@Bean
	public WebFilter webFilter(HazelcastInstance hazelcastInstance) {

		Properties properties = new Properties();
		properties.put("instance-name", hazelcastInstance.getName());
		properties.put("sticky-session", "false");

		return new WebFilter(properties);
	}

}
