#------------------------------------------------------------
# Table: User
#------------------------------------------------------------
Create database yasong_db;

use yasong_db;


CREATE TABLE User(
        TAG_USER  Int  Auto_increment  NOT NULL ,
        Lastname  Varchar (50) NOT NULL ,
        Firstname Varchar (50) NOT NULL ,
        Email     Varchar (1) NOT NULL ,
        Gender    Char (1) NOT NULL ,
        Password  Varchar (50) NOT NULL
	,CONSTRAINT User_PK PRIMARY KEY (TAG_USER)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Music
#------------------------------------------------------------

CREATE TABLE Music(
        TAG_Music Int  Auto_increment  NOT NULL ,
        Title     Varchar (50) NOT NULL ,
        Artist    Varchar (50)  NULL ,
        Duration  Varchar (50) NULL ,
        TAG_USER  Int NULL
	,CONSTRAINT Music_PK PRIMARY KEY (TAG_Music)

	,CONSTRAINT Music_User_FK FOREIGN KEY (TAG_USER) REFERENCES User(TAG_USER)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Playlist
#------------------------------------------------------------

CREATE TABLE Playlist(
        TAG_PLAYLIST Int  Auto_increment  NOT NULL ,
        TAG_USER     Int NOT NULL ,
        TAG_Music    Int NOT NULL
	,CONSTRAINT Playlist_PK PRIMARY KEY (TAG_PLAYLIST)

	,CONSTRAINT Playlist_User_FK FOREIGN KEY (TAG_USER) REFERENCES User(TAG_USER)
	,CONSTRAINT Playlist_Music0_FK FOREIGN KEY (TAG_Music) REFERENCES Music(TAG_Music)
)ENGINE=InnoDB;