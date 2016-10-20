package jp.co.seamark.example.football.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.seamark.example.football.data.Team;

@RestController
@RequestMapping(path="/football/team")
public class TeamApi extends ApiBase {
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Team> getAll(){
		return super.findAll(Team.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Team newTeam(@RequestParam String name ,String location ,@RequestParam(required=false) Long since){
		Team p = new Team(name, location);
		Optional.ofNullable(since).ifPresent(s->p.setSince(s));
		return super.put(p);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.GET)
	public Team getTeam(@PathVariable Long id){
		return super.get(id);
	}
	
	@RequestMapping(path="/{id}" ,method=RequestMethod.POST)
	public Team updateTeam(@PathVariable Long id, @RequestBody Team t){
		t.setNodeId(id);
		return super.put(t);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.DELETE)
	public void deleteTeam(@PathVariable Long id){
		super.remove(id);
	}

}
