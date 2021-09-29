INSERT INTO ROLE(ID, LIBELLE, CODE, COMMENTAIRE, VERSION)
VALUES (1, 'role1', 'coderole1', 'bla bla bla', 1);
INSERT INTO ROLE(ID, LIBELLE, CODE, COMMENTAIRE, VERSION)
VALUES (2, 'role2', 'coderole2', 'bla bla bla', 1);
INSERT INTO ROLE(ID, LIBELLE, CODE, COMMENTAIRE, VERSION)
VALUES (3, 'role3', 'coderole3', 'bla bla bla', 1);

INSERT INTO PROFIL(ID, LIBELLE, COMMENTAIRE, TYPE_PROFIL, ACTIF)
VALUES (1, 'profil1', 'bla bla bla', 'ADMIN', 1);
INSERT INTO PROFIL(ID, LIBELLE, COMMENTAIRE, TYPE_PROFIL, ACTIF)
VALUES (2, 'profil2', 'bla bla bla', 'ANONYME', 1);
INSERT INTO PROFIL(ID, LIBELLE, COMMENTAIRE, TYPE_PROFIL, ACTIF)
VALUES (3, 'profil3', 'bla bla bla', 'ANONYME', 0);

INSERT INTO PERSONNE(UID, OU, CN)
VALUES ('IDN00010006I', 'IDN218420', 'IDN00096481I_IDN000046');
INSERT INTO PERSONNE(UID, OU, CN)
VALUES ('IDN00010008I', 'IDN218420', 'IDN00096481I_IDN000046');
INSERT INTO PERSONNE(UID, OU, CN)
VALUES ('IDN00010058I', 'IDN218420', 'IDN00096481I_IDN000046');

INSERT INTO PERSONNE_PROFIL(PERSONNE_ID, PROFIL_ID)
VALUES ('IDN00010006I', 1);
INSERT INTO PERSONNE_PROFIL(PERSONNE_ID, PROFIL_ID)
VALUES ('IDN00010006I', 2);
INSERT INTO PERSONNE_PROFIL(PERSONNE_ID, PROFIL_ID)
VALUES ('IDN00010008I', 1);
INSERT INTO PERSONNE_PROFIL(PERSONNE_ID, PROFIL_ID)
VALUES ('IDN00010058I', 3);

INSERT INTO PROFIL_ROLE(PROFIL_ID, ROLE_ID)
VALUES (1, 1);
INSERT INTO PROFIL_ROLE(PROFIL_ID, ROLE_ID)
VALUES (1, 2);
INSERT INTO PROFIL_ROLE(PROFIL_ID, ROLE_ID)
VALUES (2, 3);

INSERT INTO annuaire_personne (UID, NOM, PRENOM, EMAIL)
VALUES ('IDN00010006I', 'NOM1', 'PRENOM1', 'nom1.prenom1@mail.com');
