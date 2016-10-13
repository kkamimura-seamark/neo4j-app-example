package jp.co.seamark.example.football.data;

import java.util.Date;

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
public class Match extends SimpleNode {
	@NonNull
	private Date day;
	
	@Relationship(type="homeTeam")
	private Team home;
	@Relationship(type="awayTeam")
	private Team away;
	
}
