CREATE TABLE IF NOT EXISTS CAR (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  acceleration INT NOT NULL,
  braking INT NOT NULL,
  cornering_ability INT NOT NULL,
  top_speed INT NOT NULL,
  unique key (name)
);

CREATE TABLE IF NOT EXISTS TRACK (
    id INT AUTO_INCREMENT PRIMARY KEY,
    route VARCHAR(100) NOT NULL,
    unique key (route)
);
