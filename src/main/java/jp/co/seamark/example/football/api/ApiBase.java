package jp.co.seamark.example.football.api;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

import jp.co.seamark.example.neo4j.SimpleNodeRepository;
import jp.co.seamark.example.neo4j.node.SimpleNode;

public abstract class ApiBase {
	@Autowired
	protected SimpleNodeRepository neo4jRepo;

	@Autowired
	private Neo4jOperations template;

	@SuppressWarnings("unchecked")
	protected <T extends SimpleNode> T get(Long id){
		return (T)neo4jRepo.findOne(id);
	}
	protected <T extends SimpleNode> T put(T node){
		return neo4jRepo.save(node);
	}
	protected void remove(Long id){
		neo4jRepo.delete(id);
	}
	protected <T> Iterable<T> findAll(Class<T> claz){
		Map<String, String> params = Collections.emptyMap();
		String cypherQuery = String.format("match (n:%s) return n", claz.getSimpleName());
		return template.queryForObjects(claz,cypherQuery,params);
	}
	protected <T> T findOne(Class<T> claz,Long id){
		Map<String, String> params = Collections.emptyMap();
		String cypherQuery = String.format("match (n:%s) where id(n)=%d return n", claz.getSimpleName(),id);
		return template.queryForObject(claz,cypherQuery,params);
	}
}
