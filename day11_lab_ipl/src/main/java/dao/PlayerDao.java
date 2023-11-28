package dao;

import pojos.Player;

public interface PlayerDao {
//add player
	String addPlayerDetails(Player player,Integer teamId);
}
