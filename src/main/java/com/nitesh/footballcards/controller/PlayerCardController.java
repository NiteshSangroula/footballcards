package com.nitesh.footballcards.controller;

import com.nitesh.footballcards.model.PlayerCard;
import com.nitesh.footballcards.model.Tier;
import com.nitesh.footballcards.service.PlayerCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class PlayerCardController {
	private final PlayerCardService playerCardService;

	public PlayerCardController(PlayerCardService playerCardService) {
		this.playerCardService = playerCardService;
	}

	@GetMapping
	public List<PlayerCard> getAllCards() {
		return playerCardService.getAllCards();
	}

	@GetMapping("/{id}")
	public PlayerCard getCardById(@PathVariable int id) {
		return playerCardService.getCardById(id)
				.orElseThrow(() -> new RuntimeException("Card not found"));
	}

	@PostMapping
	public PlayerCard createCard(@RequestBody PlayerCard card) {
		return playerCardService.createCard(card);
	}

	@PutMapping("/{id}")
	public PlayerCard updateCard(@PathVariable int id, @RequestBody PlayerCard card) {
		return playerCardService.updateCard(id, card);
	}

	@DeleteMapping("/{id}")
	public void deleteCard(@PathVariable int id) {
		playerCardService.deleteCard(id);
	}

	@GetMapping("/search")
	public List<PlayerCard> searchCards(
			@RequestParam(required = false) Tier tier,
			@RequestParam(required = false) String club,
			@RequestParam(required = false) String country,
			@RequestParam(required = false) String position) {

		if (tier != null)
			return playerCardService.getCardsByTier(tier);
		if (club != null)
			return playerCardService.getCardsByClub(club);
		if (country != null)
			return playerCardService.getCardsByCountry(country);
		if (position != null)
			return playerCardService.getCardsByPosition(position);

		return playerCardService.getAllCards();
	}

}
