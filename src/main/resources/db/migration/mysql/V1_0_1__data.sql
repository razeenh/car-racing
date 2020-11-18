INSERT IGNORE INTO CAR (name, acceleration, braking, cornering_ability, top_speed)
VALUES('Corvette', 8, 3, 4, 9);

INSERT IGNORE INTO CAR (name, acceleration, braking, cornering_ability, top_speed)
VALUES('GTR', 6, 7, 9, 8);

INSERT IGNORE INTO CAR (name, acceleration, braking, cornering_ability, top_speed)
VALUES('Porsche', 9, 7, 8, 7);

INSERT IGNORE INTO CAR (name, acceleration, braking, cornering_ability, top_speed)
VALUES('Ferrari', 9, 7, 7, 8);

INSERT IGNORE INTO TRACK (route)
VALUES('111100111000110011100111');

INSERT IGNORE INTO TRACK (route)
VALUES('11110011100011001110011101');

INSERT IGNORE INTO TRACK (route)
VALUES('11111111001111110111100001');

INSERT IGNORE INTO TRACK (route)
VALUES('11001');

COMMIT;