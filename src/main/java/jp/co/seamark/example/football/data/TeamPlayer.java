package jp.co.seamark.example.football.data;

import java.util.Date;

import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;

import jp.co.seamark.example.neo4j.relation.RelationBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@RelationshipEntity(type="TeamPlayer")
public class TeamPlayer extends RelationBase<Team, Player> {
	
	@NonNull
	@Property
	private Date since;
	@Property
	private Date end;
	
	public TeamPlayer(String name, Team startNode, Player endNode, Date since) {
		super(name, startNode, endNode);
		this.since = since;
	}
}
