import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn lisäämään Article-tyyppisen viitteen selkokielellä'

scenario "käyttäjä voi lisätä viitteen ohjelmaan selkokielisillä tiedoilla", {
    given 'komento addarticle valittu', {
        io = new StubIO("addentry", "article", "refKey", "ransum", "Master's thesis", "sinep", "2015", "12", "1-20", "5", "korvakatu 1", "2", "exit")
         textui = new TextUI(io)
    }
    when 'oikean muotoiset viitteen tiedot syötetään', {
        textui.start()
    }
    then 'viite on tallessa ohjelman tietämässä paikassa', {
        textui.getCommandStash().getRefList().get(0).getAuthor().shouldEqual "ransum"
    }
}