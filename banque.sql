CREATE TABLE Banque(
   idBanque INT AUTO_INCREMENT,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(idBanque)
);

CREATE TABLE Compte(
   idCompte INT AUTO_INCREMENT,
   numero VARCHAR(100) NOT NULL,
   solde DECIMAL(15,2) NOT NULL,
   PRIMARY KEY(idCompte)
);

CREATE TABLE LivretA(
   idCompte INT NOT NULL,
   taux DECIMAL(2,2) NOT NULL,
   PRIMARY KEY(idCompte),
   FOREIGN KEY(idCompte) REFERENCES Compte(idCompte)
);

CREATE TABLE AssuranceVie(
   idCompte INT NOT NULL,
   dateFin DATE NOT NULL,
   taux DECIMAL(2,2) NOT NULL,
   PRIMARY KEY(idCompte),
   FOREIGN KEY(idCompte) REFERENCES Compte(idCompte)
);


CREATE TABLE Operation(
   idOperation INT NOT NULL AUTO_INCREMENT,
   dateOperation DATETIME NOT NULL,
   montant DECIMAL(15,2) NOT NULL,
   motif TEXT,
   typeOperation VARCHAR(25) NOT NULL,
   idCompte INT NOT NULL,
   PRIMARY KEY(idOperation),
   FOREIGN KEY(idCompte) REFERENCES Compte(idCompte) ON DELETE SET NULL
);

CREATE TABLE Client(
   idClient INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   dateNaissance DATE,
   numero INT,
   rue VARCHAR(100),
   codePostal INT,
   ville VARCHAR(50),
   idBanque INT NOT NULL,
   PRIMARY KEY(idClient),
   FOREIGN KEY(idBanque) REFERENCES Banque(idBanque) ON DELETE CASCADE 
);

CREATE TABLE Virement(
   idOperation INT NOT NULL,
   beneficiaire VARCHAR(100) NOT NULL,
   idOperation INT NOT NULL,
   PRIMARY KEY(idVirement),
   UNIQUE(idOperation),
   FOREIGN KEY(idOperation) REFERENCES Operation(idOperation) ON DELETE SET NULL
);

CREATE TABLE Credit(
   idOperation INT NOT NULL,
   debiteur VARCHAR(100) NOT NULL,
   PRIMARY KEY(idOperation),
   FOREIGN KEY(idOperation) REFERENCES Operation(idOperation)  ON DELETE SET NULL
);

CREATE TABLE Debit(
   idOperation INT NOT NULL,
   crediteur VARCHAR(100) NOT NULL,
   PRIMARY KEY(idOperation),
   FOREIGN KEY(idOperation) REFERENCES Operation(idOperation) ON DELETE SET NULL
);


CREATE TABLE Possede(
   idClient INT NOT NULL,
   idCompte INT NOT NULL,
   PRIMARY KEY(idClient, idCompte),
   FOREIGN KEY(idClient) REFERENCES Client(idClient) ON DELETE CASCADE,
   FOREIGN KEY(idCompte) REFERENCES Compte(idCompte) ON DELETE CASCADE
);
