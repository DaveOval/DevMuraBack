drop database if exists devmura;

create database if not exists devmura;
use devmura;

DROP TABLE IF EXISTS auths;
create table auths (
                       auth_id integer not null auto_increment,
                       auth_name varchar(50) unique,
                       primary key (auth_id) );

DROP TABLE IF EXISTS levels;
create table levels (
                        level_id	integer not null auto_increment,
                        name	varchar(100) not null unique,
                        primary key(level_id)
);

DROP TABLE IF EXISTS countries;
create table countries (
                           country_id  integer not null auto_increment,
                           country_name varchar(50) not null unique,
                           country_code varchar(10) not null unique,
                           primary key (country_id)
);

DROP TABLE IF EXISTS genders;
create table genders (
                         gender_id integer not null auto_increment,
                         gender_name varchar(25) unique,

                         primary key(gender_id)
);

DROP TABLE IF EXISTS languages;
CREATE TABLE IF NOT EXISTS `devmura`.`languages` (
                                                     language_id INTEGER NOT NULL auto_increment,
                                                     language_name VARCHAR(100) NOT NULL unique,
    PRIMARY KEY (`language_id`) );

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS `devmura`.`users` (
                                                 user_id INTEGER NOT NULL auto_increment,
                                                 name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    age INTEGER NOT NULL,
    email VARCHAR(150) NOT NULL unique,
    username VARCHAR(150) NOT NULL unique,
    created_at DATETIME NOT NULL,
    gender_id INTEGER NOT NULL,
    password VARCHAR(150),
    country_id  integer not null,
    PRIMARY KEY (`user_id`),
    FOREIGN KEY (gender_id) REFERENCES genders (gender_id),
    FOREIGN KEY (country_id) REFERENCES countries (country_id)  );

drop table if exists user_roles;
create table user_roles (
                            user_role_id integer not null auto_increment,
                            user_id integer not null,
                            auth_id integer not null,
                            primary key(user_role_id),
                            foreign key(user_id) references users(user_id),
                            foreign key(auth_id) references auths(auth_id)
);

DROP TABLE IF EXISTS posts;
create table posts (
                       post_id		integer not null auto_increment,
                       post_body	varchar(250) not null,
                       counter		integer,
                       created_at DATETIME NOT NULL,
                       img_source	varchar(300),
                       user_id		integer not null,
                       primary key(post_id),
                       foreign key(user_id) references users(user_id)
);

DROP TABLE IF EXISTS profiles;
create table profiles (
                          profile_id	integer not null auto_increment,
                          birthday	date,
                          bio			varchar(250),
                          img_user	varchar(300),
                          github_username	varchar(50),
                          linkedin_username varchar(100),
                          background_user	varchar(300),
                          role  varchar(100),
                          level_id	integer not null,
                          user_id	integer not null,
                          primary key (profile_id),
                          foreign key(level_id) references levels(level_id),
                          foreign key(user_id) references users(user_id)
);

DROP TABLE IF EXISTS notifications;
create table notifications (
                               notification_id	integer not null auto_increment,
                               is_readed	boolean not null,
                               created_at	date not null,
                               receptor_id	integer not null,
                               sender_id	integer not null,
                               primary key(notification_id),
                               foreign key(receptor_id) references users(user_id),
                               foreign key(sender_id) references users(user_id)
);

DROP TABLE IF EXISTS comments;
create table comments(
                         comment_id  integer not null auto_increment,
                         content varchar (150),
                         created_at date not null,
                         user_id integer not null,
                         post_id integer not null,
                         primary key (comment_id),
                         foreign key (user_id) references users (user_id),
                         foreign key (post_id) references posts (post_id)

);

DROP TABLE IF EXISTS friends;
create table friends(
                        friend_id integer not null auto_increment,
                        accepted boolean not null,
                        receiver_id integer not null,
                        sender_id integer not null,

                        primary key(friend_id),
                        foreign key(receiver_id) references users (user_id),
                        foreign key(sender_id) references users (user_id)
);

DROP TABLE IF EXISTS language_profile;
CREATE TABLE IF NOT EXISTS language_profile (
                                                profile_language_id INTEGER NOT NULL AUTO_INCREMENT,
                                                language_id INTEGER NOT NULL,
                                                profile_id INTEGER NOT NULL,
                                                primary key (profile_language_id),

    FOREIGN KEY (language_id) REFERENCES languages (language_id),
    FOREIGN KEY (profile_id) REFERENCES profiles (profile_id));


DROP TABLE IF EXISTS hearts;
create table hearts (
                        heart_id integer not null auto_increment,
                        created_at DATETIME NOT NULL,
                        status boolean not null,
                        user_id integer not null,
                        post_id integer not null,

                        primary key(heart_id),
                        foreign key(user_id) references users (user_id),
                        foreign key(post_id) references posts (post_id)
);

DROP TABLE IF EXISTS `groups`;
create table `devmura`.`groups`(
                                   group_id integer not null auto_increment,
                                   title varchar (50),
                                   created_at date not null,
                                   description_group varchar(250),
                                   user_id integer not null,
                                   primary key (group_id),
                                   foreign key (user_id) references `users` (user_id)
);

DROP TABLE IF EXISTS `group_post`;
CREATE TABLE IF NOT EXISTS `devmura`.`group_post` (
                                                      id INTEGER NOT NULL AUTO_INCREMENT,
                                                      group_id INTEGER NOT NULL,
                                                      post_id INTEGER NOT NULL,
                                                      primary key (id),
    FOREIGN KEY (group_id) REFERENCES `groups` (group_id),
    FOREIGN KEY (post_id) REFERENCES `posts` (post_id));