package com.nitesh.footballcards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PlayerCard
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@Column
	private int pace;

	@Column
	private int shooting;

	@Column
	private int passing;

	@Column
	private int dribbling;

	@Column
	private int defending;

	@Column
	private int physical;

	@Column
	private int overallRating;

	@Enumerated(EnumType.STRING)
	@Column
	private Tier tier;
}
