package com.nitesh.footballcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitesh.footballcards.model.Player;

/**
 * PlayerRepository
 */
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
