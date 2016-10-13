package jp.co.seamark.example.football.data;

import jp.co.seamark.example.neo4j.node.SimpleNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Team extends SimpleNode {
	@NonNull
	private String location;
	
	private Long since;

	public Team(String name, String location) {
		super(name);
		this.location = location;
	}
}
