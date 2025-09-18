package com.nitesh.footballcards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.footballcards.model.PlayerCard;
import com.nitesh.footballcards.model.Tier;

/**
 * PlayerCardRepository
 */
public interface PlayerCardRepository extends JpaRepository<PlayerCard, Integer> {
	List<PlayerCard> findByTier(Tier tier);

	List<PlayerCard> findByPlayerClub(String club);

	List<PlayerCard> findByPlayerCountry(String country);

	List<PlayerCard> findByPlayerPosition(String position);
}
