package jp.co.seamark.example.neo4j;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.util.StreamUtils;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.seamark.example.TestApplication;
import jp.co.seamark.example.neo4j.node.SimpleNode;
import jp.co.seamark.example.neo4j.relation.SimpleRelation;
import junit.framework.AssertionFailedError;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestApplication.class,webEnvironment=WebEnvironment.NONE)
public class SimpleNodeRepositoryTest {
	@Autowired
	private SimpleNodeRepository eRepo;
	@Autowired
	private SimpleRelationRepository rRepo;
	@Autowired
	private Neo4jOperations template;
	
	@Test
	public void test() {
		// given
		SimpleNode n = new SimpleNode();
		n.setName("なまえ");
		
		// when
		eRepo.save(n);
		
		// then
		assertThat(n.getNodeId(),is(notNullValue(Long.class)));
		SimpleNode r = eRepo.findOne(n.getNodeId());
		assertThat(n.getName(), is(r.getName()));
	}
	
	@Test
	public void testリレーションを設定する() throws Exception {
		// given
		SimpleNode p = new SimpleNode("親");
		SimpleNode c = new SimpleNode("子");
		SimpleRelation r = new SimpleRelation();
		r.setStartNode(p);
		r.setEndNode(c);
		r.setName("関連");
		
		// when
		eRepo.save(Arrays.asList(p,c));
		rRepo.save(r);
		
		// then
		Result ret = template.query("match (p)-[r:SimpleRelation{name:\"関連\"}]->(c) return p,r,c", Collections.emptyMap());
		System.out.println(ret);
		Map<String, Object> o = StreamSupport.stream(ret.spliterator(), false)
			.findFirst()
			.orElse(Collections.emptyMap());
		assertThat(o.get("p"), is(p));
		assertThat(o.get("r"), is(r));
		assertThat(o.get("c"), is(c));
	}
	
	

}
