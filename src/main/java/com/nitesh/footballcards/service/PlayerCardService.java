package com.nitesh.footballcards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nitesh.footballcards.model.PlayerCard;
import com.nitesh.footballcards.model.Tier;
import com.nitesh.footballcards.repository.PlayerCardRepository;

/**
 * PlayerCardService
 */
@Service
public class PlayerCardService {
	private final PlayerCardRepository playerCardRepository;

	public PlayerCardService(PlayerCardRepository playerCardRepository) {
		this.playerCardRepository = playerCardRepository;
	}

	public List<PlayerCard> getAllCards() {
		return playerCardRepository.findAll();
	}

	public Optional<PlayerCard> getCardById(int id) {
		return playerCardRepository.findById(id);
	}

	public PlayerCard createCard(PlayerCard card) {
		calculateOvrAndTier(card);
		return playerCardRepository.save(card);
	}

	public PlayerCard updateCard(int id, PlayerCard updated) {
		return playerCardRepository.findById(id).map(card -> {
			card.setPace(updated.getPace());
			card.setShooting(updated.getShooting());
			card.setPassing(updated.getPassing());
			card.setDribbling(updated.getDribbling());
			card.setDefending(updated.getDefending());
			card.setPhysical(updated.getPhysical());
			calculateOvrAndTier(card);
			return playerCardRepository.save(card);
		}).orElseThrow(() -> new RuntimeException("Card not found"));
	}

	public void deleteCard(int id) {
		playerCardRepository.deleteById(id);
	}

	private void calculateOvrAndTier(PlayerCard card) {
		int overall = (card.getPace() + card.getShooting() + card.getPassing() + card.getDribbling()
				+ card.getDefending() + card.getPhysical()) / 6;
		card.setOverallRating(overall);

		if (overall >= 85)
			card.setTier(Tier.PLATINUM);
		else if (overall >= 80)
			card.setTier(Tier.GOLD);
		else if (overall >= 65)
			card.setTier(Tier.SILVER);
		else
			card.setTier(Tier.BRONZE);
	}

}
