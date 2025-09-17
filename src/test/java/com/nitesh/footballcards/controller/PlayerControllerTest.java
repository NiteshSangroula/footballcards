package com.nitesh.footballcards.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitesh.footballcards.model.Player;
import com.nitesh.footballcards.model.Position;
import com.nitesh.footballcards.repository.PlayerRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * PlayerControllerTest
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PlayerRepository playerRepository;

	@BeforeEach
	void setUp() {
		playerRepository.deleteAll();
	}

	@Test
	void testCreateAndGetPlayer() throws Exception {
		Player player = new Player();
		player.setName("Cristiano Ronaldo");
		player.setClub("Al Nassr");
		player.setCountry("Portugal");
		player.setPosition(Position.CF);
		player.setPhotoUrl("https://via.placeholder.com/150");

		mockMvc.perform(post("/api/players")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(player)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Cristiano Ronaldo"));

		mockMvc.perform(get("/api/players"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].club").value("Al Nassr"));
	}

	@Test
	void testUpdatePlayer() throws Exception {
		Player saved = playerRepository
				.save(new Player(null, "Test Player", "Test Club", "Test Country", Position.CM, "url"));

		saved.setClub("Updated Club");

		mockMvc.perform(put("/api/players/" + saved.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(saved)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.club").value("Updated Club"));
	}

	@Test
	void testDeletePlayer() throws Exception {
		Player saved = playerRepository
				.save(new Player(null, "To Delete", "Club", "Country", Position.LW, "url"));

		mockMvc.perform(delete("/api/players/" + saved.getId()))
				.andExpect(status().isOk());

		mockMvc.perform(get("/api/players/" + saved.getId()))
				.andExpect(status().is4xxClientError());
	}
}
