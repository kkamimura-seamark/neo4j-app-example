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

import jp.co.seamark.example.football.data.MatchResult;

@RestController
@RequestMapping(path="/football/matchResult")
public class MatchResultApi extends ApiBase {
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<MatchResult> getAll(){
		return super.findAll(MatchResult.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public MatchResult newMatchResult(@RequestParam String name ,@RequestParam Long matchId ,@RequestParam(required=false) @DateTimeFormat(pattern="yyy-MM-dd HH:mm") Date kickoff ,@RequestParam(required=false)Long homeTeamScore,@RequestParam(required=false) Long awayTeamScore ){
		MatchResult p = new MatchResult(name ,super.get(matchId));
		Optional.ofNullable(kickoff).ifPresent(s->p.setKickoff(s));
		Optional.ofNullable(homeTeamScore).ifPresent(s->p.setHomeTeamScore(s));
		Optional.ofNullable(awayTeamScore).ifPresent(s->p.setAwayTeamScore(s));
		return super.put(p);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.GET)
	public MatchResult getMatchResult(@PathVariable Long id){
		return super.get(id);
	}
	
	@RequestMapping(path="/{id}" ,method=RequestMethod.POST)
	public MatchResult updateMatchResult(@PathVariable Long id, @RequestBody MatchResult t){
		t.setNodeId(id);
		return super.put(t);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.DELETE)
	public void deleteMatchResult(@PathVariable Long id){
		super.remove(id);
	}

}
