INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

-- De wachtwoorden van alle drie de gebruikers is '123456'
INSERT INTO app_user(email, password, username) VALUES('willem@gmail.com', '$2a$10$W3dtLlKUDTyxm6e4IR0A7OwhTs7rufrEpOprROwiVvPjZVkVqHNkK', 'Willem');
INSERT INTO app_user(email, password, username) VALUES('s.j.brink@outlook.com', '$2a$10$W3dtLlKUDTyxm6e4IR0A7OwhTs7rufrEpOprROwiVvPjZVkVqHNkK', 'Sjoerd21');
INSERT INTO app_user(email, password, username) VALUES('yildiz@live.nl', '$2a$10$W3dtLlKUDTyxm6e4IR0A7OwhTs7rufrEpOprROwiVvPjZVkVqHNkK', 'Meryem.Y');



