-- Base de données : `uber`

-- --------------------------------------------------------

-- Structure de la table `car_model`
CREATE TABLE car_model
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL
);

-- Déchargement des données de la table `car_model`
INSERT INTO car_model (id, brand, model)
VALUES (2, 'BMW', 'M5'),
       (3, 'BMW', 'M5');

-- --------------------------------------------------------

-- Structure de la table `client`
CREATE TABLE client
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) DEFAULT NULL,
    phone_number VARCHAR(255) DEFAULT NULL
);

-- Déchargement des données de la table `client`
INSERT INTO client (id,name, phone_number)
VALUES (1,'clientName#1', '0659487898'),
       (2,'clientName#2', '0659487898');

-- --------------------------------------------------------

-- Structure de la table `driver`
CREATE TABLE driver
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    license_number VARCHAR(255) NOT NULL
);

-- Déchargement des données de la table `driver`
INSERT INTO driver (id, name, license_number)
VALUES (1, 'Albert le taxi', 'APHY5948YF'),
       (2, 'Jean le taxi', 'APHY5948YF');

-- --------------------------------------------------------
-- Structure de la table `taxi`
CREATE TABLE taxi
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_id INT DEFAULT NULL,
    car_model_id INT NOT NULL,
    total_km INT NOT NULL,
    CONSTRAINT FK_taxi_driver FOREIGN KEY (driver_id) REFERENCES driver(id),
    CONSTRAINT FK_taxi_car_model FOREIGN KEY (car_model_id) REFERENCES car_model(id)
);

-- Déchargement des données de la table `taxi`
INSERT INTO taxi (id, driver_id, car_model_id, total_km)
VALUES (1, 1, 2, 120000),
       (3, 2, 2, 120000);

-- Structure de la table `ride`
CREATE TABLE ride
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    taxi_id INT NOT NULL,
    client_id INT DEFAULT NULL,
    lat_start DOUBLE NOT NULL,
    long_start DOUBLE NOT NULL,
    lat_end DOUBLE DEFAULT NULL,
    long_end DOUBLE DEFAULT NULL,
    km INT DEFAULT NULL,
    CONSTRAINT FK_ride_taxi FOREIGN KEY (taxi_id) REFERENCES taxi(id),
    CONSTRAINT FK_ride_client FOREIGN KEY (client_id) REFERENCES client(id)
);

-- Déchargement des données de la table `ride`
INSERT INTO ride (id, taxi_id, client_id, lat_start, long_start, lat_end, long_end, km)
VALUES (1, 1, 1, 0, 0, 0, 0, 12);

-- --------------------------------------------------------


COMMIT;
