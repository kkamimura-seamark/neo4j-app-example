package jp.co.seamark.example.football.api;

import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.seamark.example.football.data.Player;
import jp.co.seamark.example.football.data.Team;

@RestController
@RequestMapping(path="/football/team")
public class TeamApi extends ApiBase {
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Team> getAll(){
		return super.findAll(Team.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Team putPlayer(@RequestParam String name ,String location ,@RequestParam(required=false) Long since){
		Team p = new Team(name, location);
		Optional.ofNullable(since).ifPresent(s->p.setSince(s));
		return super.put(p);
	}

}
