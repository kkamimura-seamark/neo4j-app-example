package jp.co.seamark.example.neo4j;

import org.springframework.data.neo4j.repository.GraphRepository;

import jp.co.seamark.example.neo4j.node.SimpleNode;

public interface SimpleNodeRepository extends GraphRepository<SimpleNode> {

}
