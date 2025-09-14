package com.nitesh.footballcards.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Player
 */
@Entity
@Data
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String club;

	@Column
	private String country;

	@Enumerated(EnumType.STRING)
	@Column
	private Position position;

	@Column
	private String photoUrl;
}
