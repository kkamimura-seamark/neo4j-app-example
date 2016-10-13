package jp.co.seamark.example.neo4j.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NodeEntity
public class SimpleNode {

	@GraphId
	private Long nodeId;
	
	@NonNull
	private String name;
}
