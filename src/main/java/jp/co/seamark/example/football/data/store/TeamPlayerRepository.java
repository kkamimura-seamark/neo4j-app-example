package jp.co.seamark.example.football.data.store;

import org.springframework.data.neo4j.repository.GraphRepository;

import jp.co.seamark.example.football.data.TeamPlayer;

public interface TeamPlayerRepository extends GraphRepository<TeamPlayer> {

}
