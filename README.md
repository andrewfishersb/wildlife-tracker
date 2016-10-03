# _Wildlife Tracker_

#### _Wildlife Tracker Database Project, September 30th, 2016_

#### By _**Andrew Fisher**_

## Description

_This App will keep record sightings of Animals and define whether they are endangered, if they are you can record their age and health._

## Specifications

_1. It can ask the user for an animals species._
* _Input Example: Bear_
* _Output Example: Your animal is a Bear_

_2. It can then ask the user to define whether the animal is endangered or not._
* _Input Example: Endangered_
* _Output Example: Yes_

_3. If endangered the user inputs the age and health of the animal._
* _Input Example: Young, Ill_
* _Output Example: Young, Ill_

_4. It can delete the animal._
* _Output Example: Bear no longer exists_

_5. It can have the user create a sighting, where you add your name, location of the sighting and the time._
* _Input Example: Andrew, Portland_
* _Output Example: Andrew, Portland, 9/29/2016 6:23PM_


## Setup/Installation Requirements

* Requires Java, Gradle, POSTGRES and SQL
* Clone to your computer
* In PSQL:
* CREATE DATABASE wildlife\_tracker
* CREATE DATABASE wildlife\_tracker\_test
* Both will include the tables
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);
* CREATE TABLE sightings (id serial PRIMARY KEY, rangername varchar, location varchar, timespotted timestamp, animalid int);

## Known Bugs

_No known bugs_


## Contact
* _Andrewfishersb@gmail.com_

## Technologies Used

* _Java_
* _Gradle_
* _SQL_
* _HTML/CSS/Bootstrap_


### License

*This software is licensed under the MIT license*

Copyright (c) 2016 **_Andrew Fisher_**
