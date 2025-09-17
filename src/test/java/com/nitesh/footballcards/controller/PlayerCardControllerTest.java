package com.nitesh.footballcards.controller;

import com.nitesh.footballcards.model.Player;
import com.nitesh.footballcards.model.PlayerCard;
import com.nitesh.footballcards.model.Position;
import com.nitesh.footballcards.repository.PlayerCardRepository;
import com.nitesh.footballcards.repository.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PlayerCardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerCardRepository cardRepository;

	@BeforeEach
	void setUp() {
		cardRepository.deleteAll();
		playerRepository.deleteAll();
	}

	@Test
	void testCreateAndGetCard() throws Exception {
		Player player = playerRepository
				.save(new Player(null, "Messi", "Inter Miami", "Argentina", Position.RW, "url"));

		PlayerCard card = new PlayerCard();
		card.setPlayer(player);
		card.setPace(90);
		card.setShooting(92);
		card.setPassing(91);
		card.setDribbling(95);
		card.setDefending(35);
		card.setPhysical(65);

		mockMvc.perform(post("/api/cards")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(card)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.overallRating").value(78)) // auto calc
				.andExpect(jsonPath("$.tier").value("SILVER"));
	}
}
