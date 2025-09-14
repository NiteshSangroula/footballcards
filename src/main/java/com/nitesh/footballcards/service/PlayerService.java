package com.nitesh.footballcards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nitesh.footballcards.model.Player;
import com.nitesh.footballcards.repository.PlayerRepository;

/**
 * PlayerService
 */
@Service
public class PlayerService {
	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	// get all player
	public List<Player> getAllPlayer() {
		return playerRepository.findAll();
	}

	// get player by id
	public Optional<Player> getPlayerById(int id) {
		return playerRepository.findById(id);
	}

	// create player
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}

	// delete player
	public void deletePlayer(int id) {
		playerRepository.deleteById(id);
	}

	// update a player
	public Player updatePlayer(int id, Player updated) {
		return playerRepository.findById(id).map(player -> {
			player.setName(updated.getName());
			player.setClub(updated.getClub());
			player.setCountry(updated.getCountry());
			player.setPosition(updated.getPosition());
			player.setPhotoUrl(updated.getPhotoUrl());
		}).orElseThrow(() -> new RuntimeException("Player not Found"));
	}

}
