package jp.co.seamark.example.football.api;

import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.seamark.example.football.data.Player;
import jp.co.seamark.example.football.data.Match;

@RestController
@RequestMapping(path="/football/match")
public class MatchApi extends ApiBase {
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Match> getAll(){
		return super.findAll(Match.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Match newMatch(@RequestParam String name ,@RequestParam @DateTimeFormat(pattern="yyy-MM-dd") Date day ,@RequestParam Long homeTeamId ,@RequestParam Long awayTeamId){
		Match p = new Match(name ,day);
		p.setHome(super.get(homeTeamId));
		p.setAway(super.get(awayTeamId));
		return super.put(p);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.GET)
	public Match getMatch(@PathVariable Long id){
		return super.get(id);
	}
	
	@RequestMapping(path="/{id}" ,method=RequestMethod.POST)
	public Match updateMatch(@PathVariable Long id, @RequestBody Match t){
		t.setNodeId(id);
		return super.put(t);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.DELETE)
	public void deleteMatch(@PathVariable Long id){
		super.remove(id);
	}

}
