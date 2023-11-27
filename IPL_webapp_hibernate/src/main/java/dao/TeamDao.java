package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to insert new team details
	String addTeamDetails(Team newTeam);
	List<Team> getSeletedTeamDetails(String abbr);
	List<String> getTeamWithMaxAge(int age);
	Team updateTeamStats(int teamid,double battingAvg,int wickets);
	//ADD A METHOD TO GET ABBR OF ALL TEAMS;
	List<String> getAllTeamsByAbbr();
	Team getTeamDetails(String abbr);
}
