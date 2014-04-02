import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*

description 'Käyttäjänä pystyn lisäämään Inproceedings-tyyppisen viitteen selkokielellä'

scenario "käyttäjä voi lisätä viitteen ohjelmaan selkokielisillä tiedoilla", {
    given 'komento addentry valittu'
    when 'oikean muotoiset viitteen tiedot syötetään'
    then 'viite on tallessa ohjelman tietämässä paikassa'
}