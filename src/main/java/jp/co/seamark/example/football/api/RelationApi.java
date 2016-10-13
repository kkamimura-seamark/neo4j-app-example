package jp.co.seamark.example.football.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.seamark.example.football.data.Player;
import jp.co.seamark.example.football.data.Team;
import jp.co.seamark.example.football.data.TeamPlayer;
import jp.co.seamark.example.football.data.store.TeamPlayerRepository;
import jp.co.seamark.example.neo4j.SimpleNodeRepository;
import jp.co.seamark.example.neo4j.SimpleRelationRepository;
import jp.co.seamark.example.neo4j.node.SimpleNode;
import jp.co.seamark.example.neo4j.relation.SimpleRelation;

@RestController
@RequestMapping(path="/football/relation")
public class RelationApi extends ApiBase {

	@Autowired
	private SimpleRelationRepository rRepo;
	@Autowired
	private TeamPlayerRepository tpRepo;

	@RequestMapping(path="/ext/{name}",method=RequestMethod.POST)
	public SimpleRelation create(@PathVariable String name,Long startNodeId,Long endNodeId){
		SimpleNode start = neo4jRepo.findOne(startNodeId);
		SimpleNode end = neo4jRepo.findOne(endNodeId);
		SimpleRelation r = new SimpleRelation(start,end,name);
		return rRepo.save(r);
	}

	
	@RequestMapping(path="/teamplayer" ,method=RequestMethod.POST)
	public TeamPlayer joinTeamPlayer(String name, Long teamId, Long playerId,
			@RequestParam @DateTimeFormat(pattern = "yyy-MM-dd") Date since,
			@RequestParam(required=false) @DateTimeFormat(pattern = "yyy-MM-dd") Date end) {
		Team team = findOne(Team.class, teamId);
		Player player = findOne(Player.class, playerId);
		TeamPlayer tp = new TeamPlayer(name, team, player, since);
		return tpRepo.save(tp);
	}
}
