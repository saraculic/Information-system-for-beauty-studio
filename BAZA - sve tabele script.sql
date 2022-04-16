CREATE TABLE `administrator` (
  `idAdministrator` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAdministrator`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `komentar` (
  `idKomentar` int NOT NULL AUTO_INCREMENT,
  `idKorisnika` int DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idKomentar`),
  KEY `fk_komentar_idKorisnik_idx` (`idKorisnika`),
  CONSTRAINT `fk_komentar_idKorisnik` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnik` (`idKorisnik`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `korisnik` (
  `idKorisnik` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idKorisnik`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `salon_korisnik` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `salon_korisnik_uloga` (
  `idKorisnikUloga` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `idUloga` int DEFAULT NULL,
  PRIMARY KEY (`idKorisnikUloga`),
  KEY `fk_salon_korisnik_uloga_1_idx` (`id`),
  KEY `fk_salon_korisnik_uloga_2_idx` (`idUloga`),
  CONSTRAINT `fk_salon_korisnik_uloga_1` FOREIGN KEY (`id`) REFERENCES `salon_korisnik` (`id`),
  CONSTRAINT `fk_salon_korisnik_uloga_2` FOREIGN KEY (`idUloga`) REFERENCES `uloga` (`idUloga`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `slika` (
  `idSlika` int NOT NULL AUTO_INCREMENT,
  `idAdministrator` int DEFAULT NULL,
  `idUsluga` int DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idSlika`),
  KEY `fk_slika_idUsluga_idx` (`idUsluga`),
  CONSTRAINT `fk_slika_idUsluga` FOREIGN KEY (`idUsluga`) REFERENCES `usluga` (`idUsluga`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `slobodantermin` (
  `idSlobodanTermin` int NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `vreme` varchar(45) DEFAULT NULL,
  `idUsluga` int DEFAULT NULL,
  `idZaposlen` int DEFAULT NULL,
  PRIMARY KEY (`idSlobodanTermin`),
  KEY `fk_slobodantermin_idUsluga_idx` (`idUsluga`),
  KEY `fk_slobodantermin_idZaposlen_idx` (`idZaposlen`),
  CONSTRAINT `fk_slobodantermin_idUsluga` FOREIGN KEY (`idUsluga`) REFERENCES `usluga` (`idUsluga`),
  CONSTRAINT `fk_slobodantermin_idZaposlen` FOREIGN KEY (`idZaposlen`) REFERENCES `zaposlen` (`idZaposlen`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `uloga` (
  `idUloga` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUloga`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usluga` (
  `idUsluga` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) DEFAULT NULL,
  `idAdministrator` int DEFAULT NULL,
  `cena` int DEFAULT NULL,
  `slika` blob,
  PRIMARY KEY (`idUsluga`),
  KEY `fk_usluga_idAdministrator_idx` (`idAdministrator`),
  CONSTRAINT `fk_usluga_idAdministrator` FOREIGN KEY (`idAdministrator`) REFERENCES `administrator` (`idAdministrator`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `zakazivanje` (
  `idZakazivanje` int NOT NULL AUTO_INCREMENT,
  `datum` datetime DEFAULT NULL,
  `vreme` varchar(45) DEFAULT NULL,
  `idUsluga` int DEFAULT NULL,
  `idZaposlen` int DEFAULT NULL,
  `idKorisnik` int DEFAULT NULL,
  PRIMARY KEY (`idZakazivanje`),
  KEY `fk_zakazivanje_idUsluga_idx` (`idUsluga`),
  KEY `fk_zakazivanje_idZaposlen_idx` (`idZaposlen`),
  KEY `fk_zakazivanje_idKorisnik_idx` (`idKorisnik`),
  CONSTRAINT `fk_zakazivanje_idKorisnik` FOREIGN KEY (`idKorisnik`) REFERENCES `korisnik` (`idKorisnik`),
  CONSTRAINT `fk_zakazivanje_idUsluga` FOREIGN KEY (`idUsluga`) REFERENCES `usluga` (`idUsluga`),
  CONSTRAINT `fk_zakazivanje_idZaposlen` FOREIGN KEY (`idZaposlen`) REFERENCES `zaposlen` (`idZaposlen`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `zaposlen` (
  `idZaposlen` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) DEFAULT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `idAdministrator` int DEFAULT NULL,
  `plata` int DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idZaposlen`),
  KEY `fk_zaposlen_idAdministrator_idx` (`idAdministrator`),
  CONSTRAINT `fk_zaposlen_idAdministrator` FOREIGN KEY (`idAdministrator`) REFERENCES `administrator` (`idAdministrator`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
