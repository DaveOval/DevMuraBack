insert into  auths(auth_name) VALUES ("Admin");
insert into  auths(auth_name) VALUES ("User");

insert into levels (name) VALUES ("private");
insert into levels (name) VALUES ("public");

insert into countries (country_name) VALUES ("China");
insert into countries (country_name) VALUES ("India");
insert into countries (country_name) VALUES ("Iran");
insert into countries (country_name) VALUES ("Israel");
insert into countries (country_name) VALUES ("Japan");
insert into countries (country_name) VALUES ("Pakistan");
insert into countries (country_name) VALUES ("Palestine");
insert into countries (country_name) VALUES ("Saudi Arabia");
insert into countries (country_name) VALUES ("South Korea");
insert into countries (country_name) VALUES ("Australia");
insert into countries (country_name) VALUES ("Fiji");
insert into countries (country_name) VALUES ("New Zeland");
insert into countries (country_name) VALUES ("Argentina");
insert into countries (country_name) VALUES ("Brazil");
insert into countries (country_name) VALUES ("Chile");
insert into countries (country_name) VALUES ("Peru");
insert into countries (country_name) VALUES ("Venezuela");
insert into countries (country_name) VALUES ("Canada");
insert into countries (country_name) VALUES ("Cuba");
insert into countries (country_name) VALUES ("Mexico");
insert into countries (country_name) VALUES ("Dominican Republic");
insert into countries (country_name) VALUES ("Jamaica");
insert into countries (country_name) VALUES ("United States");
insert into countries (country_name) VALUES ("Belize");
insert into countries (country_name) VALUES ("Costa Rica");
insert into countries (country_name) VALUES ("El Salvador");
insert into countries (country_name) VALUES ("Guatemala");
insert into countries (country_name) VALUES ("Honduras");
insert into countries (country_name) VALUES ("Nicaragua");
insert into countries (country_name) VALUES ("Panama");
insert into countries (country_name) VALUES ("Denmark");
insert into countries (country_name) VALUES ("France");
insert into countries (country_name) VALUES ("Germany");
insert into countries (country_name) VALUES ("Italy");
insert into countries (country_name) VALUES ("Portugal");
insert into countries (country_name) VALUES ("Russia");
insert into countries (country_name) VALUES ("Spain");
insert into countries (country_name) VALUES ("Turkey");
insert into countries (country_name) VALUES ("United Kingdom");
insert into countries (country_name) VALUES ("Morocco");

insert into genders (gender_name) VALUES ("Femenino");
insert into genders (gender_name) VALUES ("Masculino");

insert into languages (language_name) VALUES ("Java");
insert into languages (language_name) VALUES ("JavaScript");
insert into languages (language_name) VALUES ("MySQL");
insert into languages (language_name) VALUES ("HTML");
insert into languages (language_name) VALUES ("PHP");
insert into languages (language_name) VALUES ("Python");
insert into languages (language_name) VALUES ("XML");
insert into languages (language_name) VALUES ("React");
insert into languages (language_name) VALUES ("NodeJs");
insert into languages (language_name) VALUES ("TypeScript");
insert into languages (language_name) VALUES ("CSS");

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("David", "Vazquez", 24, "dave@gmail.com", "Dave", "2023-05-01", 2,"Dave123@!",1,20);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Fernando", "Herrera", 28, "ferher@gmail.com", "Fers", "2023-06-01", 2,"FerHer2@!",2,19);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Juanito", "Banana", 24, "juanito@hotmail.com", "juanito01", "2023-06-01", 2,"Juans12!!", 2, 23);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Mariana", "Smith", 33, "mari@gmail.com", "mariana_dev", "2023-06-01", 1,"maRi111!", 2, 23);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Alex", "Turner", 28, "alexTur@hotmail.com", "alex_t", "2023-06-02", 2 ,"AlEx23@-", 2, 20);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Sophie", "Chen", 27, "chen@gmail.com", "sophie.design", "2023-06-02", 1 ,"22Soph@#", 2, 1);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Raj", "Patel", 31, "rajPat@outlook.com", "patel.Raj7", "2023-06-03", 2,"Raj7P777#",2,25);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Emily", "Thompson", 42, "emsly@gmail.com", "emily.Thomp", "2023-06-04", 1,"emithosT02~",2,23);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Ana", "Torres", 21 , "antor@gmail.com", "Ana_Dev", "2023-06-04", 1,"AATorr21@", 2, 6);

insert into users (name ,last_name, age, email, username, created_at, gender_id, password, auth_id, country_id )
VALUES ("Patricia", "Matias", 22 , "ale@hotmail.com", "Tenshik0", "2023-06-05", 1,"Tensh111!-", 1, 20);

INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Hola mundo", "5", "2023-06-02", "https://images.pexels.com/photos/954599/pexels-photo-954599.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 2);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Adios mundo", "15", "2023-06-03", "https://images.pexels.com/photos/1714208/pexels-photo-1714208.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", 5);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Sobre Java", "25", "2023-06-03", "img/java.jpg", 4);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Sobre HTML", "35", "2023-06-03", "img/html.png", 1);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Sumando numeros", "1", "2023-06-05", "", 7);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Mi primer calculadora", "10", "2023-06-05", "", 10);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("JAVA", "11", "2023-06-05", "img/java2.png", 2);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Scrum", "3", "2023-06-06", "", 10);
INSERT INTO posts (post_body, counter, created_at, img_source, user_id) VALUES ("Metodo burbuja", "50", "2023-06-06", "img/burbu.png", 8);

INSERT INTO `profiles` (birthday, bio, img_user, github_username, linkedin_username, background_user,role, level_id, user_id)
VALUES("1998-02-04", "Hola", "https://images.pexels.com/photos/1933873/pexels-photo-1933873.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Dave", "David Vazquez" , "https://images.pexels.com/photos/1933873/pexels-photo-1933873.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1","Backend Developer", 2,1);

INSERT INTO `profiles` (birthday, bio, img_user, github_username, linkedin_username, background_user,role, level_id, user_id)
VALUES("1998-03-04", "Hi", "https://www.pexels.com/es-es/foto/hombre-en-sueter-de-cuello-alto-marron-3170635/", "Fers", "Fernando Herrera" , "https://www.pexels.com/es-es/foto/hombre-en-sueter-de-cuello-alto-marron-3170635/","Backend Developer", 1,2);

INSERT INTO `profiles` (birthday, bio, img_user, github_username, linkedin_username, background_user,role, level_id, user_id)
VALUES("1999-05-04", "Hello", "https://images.pexels.com/photos/428328/pexels-photo-428328.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "jns", "Juanito Banana" , "https://images.pexels.com/photos/428328/pexels-photo-428328.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1","Backend Developer", 2,3);

INSERT INTO `profiles` (birthday, bio, img_user, github_username, linkedin_username, background_user,role, level_id, user_id)
VALUES("1999-02-04", "Hola", "https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Mar", "Mariana Smith" , "https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1","Backend Developer", 2,4);

INSERT INTO `profiles` (birthday, bio, img_user, github_username, linkedin_username, background_user, role, level_id, user_id)
VALUES("1994-02-04", "Hola", "https://images.pexels.com/photos/5220075/pexels-photo-5220075.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Alex", "Alex Turner" , "https://images.pexels.com/photos/5220075/pexels-photo-5220075.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Backend Developer", 2,5);

INSERT INTO `profiles` (birthday, bio, img_user, github_username, linkedin_username, background_user,role, level_id, user_id)
VALUES("1991-02-04", "Hola", "https://images.pexels.com/photos/1587009/pexels-photo-1587009.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "Sop", "Sophie Chen" , "https://images.pexels.com/photos/1587009/pexels-photo-1587009.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1","Backend Developer", 1,6);

insert into notifications (is_readed, created_at, receptor_id, sender_id) VALUES (1, "2023-06-12", 1,2);
insert into notifications (is_readed, created_at, receptor_id, sender_id) VALUES (0, "2023-06-13", 4,6);
insert into notifications (is_readed, created_at, receptor_id, sender_id) VALUES (0, "2023-06-13", 4,6);
insert into notifications (is_readed, created_at, receptor_id, sender_id) VALUES (1, "2023-06-14", 5,6);
insert into notifications (is_readed, created_at, receptor_id, sender_id) VALUES (1, "2023-06-14", 5,6);

insert into comments (content, created_at, user_id, post_id) VALUES ("Niceee!!!", "2023-06-02", 2, 1);

INSERT INTO friends (accepted, receiver_id, sender_id) VALUES (true, 2, 1);
INSERT INTO friends (accepted, receiver_id, sender_id) VALUES (true, 1, 2);

INSERT INTO language_profile(language_id, profile_id) VALUES(1,1);
INSERT INTO language_profile(language_id, profile_id) VALUES(2,1);
INSERT INTO language_profile(language_id, profile_id) VALUES(3,1);
INSERT INTO language_profile(language_id, profile_id) VALUES(1,2);
INSERT INTO language_profile(language_id, profile_id) VALUES(2,2);
INSERT INTO language_profile(language_id, profile_id) VALUES(1,3);
INSERT INTO language_profile(language_id, profile_id) VALUES(2,3);

INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-02",2,1);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-02",2,1);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-02",2,1);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-02",2,1);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-03",5,2);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-03",2,1);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-03",5,2);
INSERT INTO hearts (created_at, user_id, post_id) VALUES("2023-06-03",5,2);

INSERT INTO `groups` (title, created_at, description_group, user_id) VALUES ("JAVA", "2023/06/06" , "Personas con interes en aprender sobre JAVA", 5);
INSERT INTO `groups` (title, created_at, description_group, user_id) VALUES ("HTML", "2023/06/06" , "Personas con interes en aprender sobre HTML", 8);
INSERT INTO `groups` (title, created_at, description_group, user_id) VALUES ("PYTHON", "2023/06/07" , "Personas con interes en aprender sobre PYTHON", 3);
INSERT INTO `groups` (title, created_at, description_group, user_id) VALUES ("JAVEROS", "2023/06/08" , "Personas que saben JAVA", 9);
INSERT INTO `groups` (title, created_at, description_group, user_id) VALUES ("BD", "2023/06/10" , "Personas con interes en aprender sobre BD", 4);

INSERT INTO group_post(group_id, post_id) VALUES(1,3);
INSERT INTO group_post(group_id, post_id) VALUES(2,4);
INSERT INTO group_post(group_id, post_id) VALUES(3,2);
INSERT INTO group_post(group_id, post_id) VALUES(4,5);
INSERT INTO group_post(group_id, post_id) VALUES(4,9);