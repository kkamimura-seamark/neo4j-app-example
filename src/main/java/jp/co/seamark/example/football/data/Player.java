package jp.co.seamark.example.football.data;

import java.util.Date;

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
public class Player extends SimpleNode {
	@NonNull
	private Date birthday;
	
	private String comment;

	public Player(String name, Date birthday) {
		super(name);
		this.birthday = birthday;
	}
}
