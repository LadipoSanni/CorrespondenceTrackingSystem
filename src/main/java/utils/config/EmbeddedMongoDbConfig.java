package utils.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class EmbeddedMongoDbConfig {

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "correspondence");
    }

    @Bean
    public MongoClient mongoClient() throws IOException {
        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(
                                builder ->
                                        builder.hosts(List.of(new ServerAddress("localhost", 27017))))
                        .build());
    }
}
