package jp.co.seamark.example.neo4j.relation;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.StartNode;

import jp.co.seamark.example.neo4j.node.SimpleNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class RelationBase<S extends SimpleNode,E extends SimpleNode> {

	@GraphId
	private Long relationId;
	@NonNull
	@Property
	private String name;
	@NonNull
	@StartNode
	private S startNode;
	@NonNull
	@EndNode
	private E endNode;
	
}
