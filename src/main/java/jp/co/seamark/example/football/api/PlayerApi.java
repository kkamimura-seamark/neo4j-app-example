package jp.co.seamark.example.football.api;

import java.util.Date;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.seamark.example.football.data.Player;

@RestController
@RequestMapping(path="/football/player")
public class PlayerApi extends ApiBase {



	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Player> getAll(){
		return super.findAll(Player.class);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Player putPlayer(@RequestParam String name ,@RequestParam @DateTimeFormat(pattern="yyy-MM-dd") Date birthday ,@RequestParam(required=false) String comment){
		Player p = new Player(name, birthday);
		Optional.ofNullable(comment).ifPresent(s->p.setComment(s));
		return super.put(p);
	}
	
}
