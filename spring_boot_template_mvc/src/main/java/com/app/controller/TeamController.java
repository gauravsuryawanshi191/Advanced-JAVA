package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;

	public TeamController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to get all teams abbreviations
	@GetMapping("/")
	public String getAllTeamsAbbreviations(Model map) {
		System.out.println("in get all teams abbr " + map);
		map.addAttribute("teams_abbr", teamService.getAllTeamsAbbreviations());
		return "/teams/add_player_form";//AVN : /WEB-INF/views/teams/add_player_form.jsp
	}
}
