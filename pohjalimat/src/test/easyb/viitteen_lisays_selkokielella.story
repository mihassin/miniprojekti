import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*

description 'Käyttäjänä pystyn lisäämään Inproceedings-tyyppisen viitteen selkokielellä'

scenario "käyttäjä voi lisätä viitteen ohjelmaan selkokielisillä tiedoilla", {
    given 'komento addentry valittu', {
        io = new StubIO("addentry", "ransum", "Master's thesis", "sinep", "2015", "exit")
        textui = new TextUI(io)
    }
    when 'oikean muotoiset viitteen tiedot syötetään', {
        textui.start()
    }
    then 'viite on tallessa ohjelman tietämässä paikassa', {
        textui.getRefList().get(0).getAuthor().shouldEqual "ransum"
    }
}