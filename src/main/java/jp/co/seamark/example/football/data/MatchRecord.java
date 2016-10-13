package jp.co.seamark.example.football.data;

import org.neo4j.ogm.annotation.Relationship;

import jp.co.seamark.example.neo4j.node.SimpleNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@RequiredArgsConstructor
public class MatchRecord extends SimpleNode {
	@NonNull
	@Relationship(type="result")
	private Match match;
	@NonNull
	private Long homeTeamScore;
	@NonNull
	private Long awayTeamScore;
}
