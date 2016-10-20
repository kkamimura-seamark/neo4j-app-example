package jp.co.seamark.example.football.data;

import jp.co.seamark.example.neo4j.node.SimpleNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Position extends SimpleNode {
	public Position(String name) {
		super(name);
	}
}
