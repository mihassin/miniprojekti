import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn lisäämään Book-tyyppisen viitteen selkokielellä'

scenario "käyttäjä voi lisätä viitteen ohjelmaan selkokielisillä tiedoilla", {
    given 'komento addentry valittu', {
        io = new StubIO("addentry", "book", "refKey", "ransum", "Master's thesis", "sinep", "2015", "12", "komeron kovikset", "asd", "korvakatu 1", "black edition", "may", "this is a note", "exit")
         textui = new TextUI(io)
    }
    when 'oikean muotoiset viitteen tiedot syötetään', {
        textui.start()
    }
    then 'viite on tallessa ohjelman tietämässä paikassa', {
        textui.getCommandStash().getRefList().get(0).getAuthor().shouldEqual "ransum"
    }
}