package jp.co.seamark.example.neo4j.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages="jp.co.seamark")
public class Neo4jConfig {

}
