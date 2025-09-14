package com.nitesh.footballcards.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nitesh.footballcards.model.Player;
import com.nitesh.footballcards.service.PlayerService;

/**
 * PlayerController
 */
@RestController
@RequestMapping("/api/players")
public class PlayerController {
	private final PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayer();
	}

	@GetMapping("/{id}")
	public Player getPlayerById(@PathVariable int id) {
		return playerService.getPlayerById(id)
				.orElseThrow(() -> new RuntimeException("Player not found"));
	}

	@PostMapping
	public Player createPlayer(@RequestBody Player player) {
		return playerService.createPlayer(player);
	}

	@PutMapping("/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
		return playerService.updatePlayer(id, player);
	}

	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id) {
		playerService.deletePlayer(id);
	}

}
