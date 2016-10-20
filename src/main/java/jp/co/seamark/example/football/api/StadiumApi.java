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
import jp.co.seamark.example.football.data.Stadium;

@RestController
@RequestMapping(path="/football/stadium")
public class StadiumApi extends ApiBase {
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Stadium> getAll(){
		return super.findAll(Stadium.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Stadium newStadium(@RequestParam String name ,String location){
		Stadium p = new Stadium(name, location);
		return super.put(p);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.GET)
	public Stadium getStadium(@PathVariable Long id){
		return super.get(id);
	}
	
	@RequestMapping(path="/{id}" ,method=RequestMethod.POST)
	public Stadium updateStadium(@PathVariable Long id, @RequestBody Stadium t){
		t.setNodeId(id);
		return super.put(t);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.DELETE)
	public void deleteStadium(@PathVariable Long id){
		super.remove(id);
	}

}
