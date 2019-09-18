package com.bolsadeideas.springboot.diapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.diapp.model.Movement;

@RestController
@RequestMapping("/game")
public class SpringTicTacToeController {
	
	@Autowired
	private SpringTicTacToeService GameService;
	
	@GetMapping
	public String newGame() {
		return GameService.createGame();
	}
	
	
	@GetMapping(value="/idGame")
	public String getGame(@RequestParam(value = "idGame", required = true) String idGame) {
		return GameService.getGame(idGame);
	}
	
	@PostMapping(value="/idGame", consumes="application/json")
	public String setMovement(@RequestParam(value = "idGame", required = true) String idGame, @RequestBody Movement mv) {
		return GameService.nextMovement(idGame , mv);
	}
}
