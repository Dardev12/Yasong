#------------------------------------------------------------
# Table: User
#------------------------------------------------------------

CREATE TABLE User(
        TAG_USER  Int NOT NULL ,
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
        Artist    Varchar (50) NOT NULL ,
        Duration  TimeStamp NOT NULL
	,CONSTRAINT Music_PK PRIMARY KEY (TAG_Music)
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


#------------------------------------------------------------
# Table: owns
#------------------------------------------------------------

CREATE TABLE owns(
        TAG_Music Int NOT NULL ,
        TAG_USER  Int NOT NULL
	,CONSTRAINT owns_PK PRIMARY KEY (TAG_Music,TAG_USER)

	,CONSTRAINT owns_Music_FK FOREIGN KEY (TAG_Music) REFERENCES Music(TAG_Music)
	,CONSTRAINT owns_User0_FK FOREIGN KEY (TAG_USER) REFERENCES User(TAG_USER)
)ENGINE=InnoDB;
