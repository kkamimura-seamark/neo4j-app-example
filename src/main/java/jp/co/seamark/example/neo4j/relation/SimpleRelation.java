package jp.co.seamark.example.neo4j.relation;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import jp.co.seamark.example.neo4j.node.SimpleNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@RelationshipEntity(type="SimpleRelation")
public class SimpleRelation {
	@GraphId
	private Long relationId;
	@NonNull
	@StartNode
	private SimpleNode startNode;
	@NonNull
	@EndNode
	private SimpleNode endNode;
	
	@NonNull
	@Property
	private String name;
}
