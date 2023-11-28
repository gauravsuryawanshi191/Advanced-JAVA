package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
//add a method to get abbreviations of all teams
	List<String> getAllTeamsAbbreviations();

	Team getDetailsByAbbreviation(String abbreviation);
	
}
