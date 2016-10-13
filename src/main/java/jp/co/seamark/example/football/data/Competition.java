package jp.co.seamark.example.football.data;

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
public class Competition extends SimpleNode {
	@NonNull
	private CompetitionType type;
}
