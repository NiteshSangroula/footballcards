-- Players
INSERT INTO player (id, name, club, country, position, photo_url)
VALUES (1, 'Lionel Messi', 'Inter Miami', 'Argentina', 'RW', 'https://via.placeholder.com/150');

INSERT INTO player (id, name, club, country, position, photo_url)
VALUES (2, 'Cristiano Ronaldo', 'Al Nassr', 'Portugal', 'CF', 'https://via.placeholder.com/150');

INSERT INTO player (id, name, club, country, position, photo_url)
VALUES (3, 'Kylian Mbappé', 'PSG', 'France', 'LW', 'https://via.placeholder.com/150');

-- Player Cards
INSERT INTO player_card (id, player_id, pace, shooting, passing, dribbling, defending, physical, overall_rating, tier)
VALUES (1, 1, 85, 92, 91, 95, 38, 65, 0, 'GOLD');

INSERT INTO player_card (id, player_id, pace, shooting, passing, dribbling, defending, physical, overall_rating, tier)
VALUES (2, 2, 88, 94, 82, 89, 40, 77, 0, 'GOLD');

INSERT INTO player_card (id, player_id, pace, shooting, passing, dribbling, defending, physical, overall_rating, tier)
VALUES (3, 3, 97, 90, 85, 94, 42, 80, 0, 'PLATINUM');

