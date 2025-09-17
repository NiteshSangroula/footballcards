package com.nitesh.footballcards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Player
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
