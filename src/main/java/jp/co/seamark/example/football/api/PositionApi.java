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

import jp.co.seamark.example.football.data.Position;

@RestController
@RequestMapping(path="/football/position")
public class PositionApi extends ApiBase {


	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Position> getAll(){
		return super.findAll(Position.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Position newPosition(@RequestParam String name){
		Position p = new Position(name);
		return super.put(p);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.GET)
	public Position getPosition(@PathVariable Long id){
		return super.get(id);
	}
	
	@RequestMapping(path="/{id}" ,method=RequestMethod.POST)
	public Position updatePosition(@PathVariable Long id, @RequestBody Position p){
		p.setNodeId(id);
		return super.put(p);
	}
	@RequestMapping(path="/{id}" ,method=RequestMethod.DELETE)
	public void deletePosition(@PathVariable Long id){
		super.remove(id);
	}
}
