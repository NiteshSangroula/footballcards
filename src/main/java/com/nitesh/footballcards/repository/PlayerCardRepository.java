package com.nitesh.footballcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.footballcards.model.PlayerCard;

/**
 * PlayerCardRepository
 */
public interface PlayerCardRepository extends JpaRepository<PlayerCard, Integer> {

}
