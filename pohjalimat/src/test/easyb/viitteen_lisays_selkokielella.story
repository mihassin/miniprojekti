import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn lisäämään Inproceedings-tyyppisen viitteen selkokielellä'

scenario "käyttäjä voi lisätä viitteen ohjelmaan selkokielisillä tiedoilla", {
    given 'komento addentry valittu', {
        io = new StubIO("addentry", "inproceedings", "refKey", "ransum", "Master's thesis", "sinep", "2015", "editor", "3", "series", "10--20", "address", "month", "publisher", "organisation", "note", "isbn4000-232", "exit")
        textui = new TextUI(io)
    }
    when 'oikean muotoiset viitteen tiedot syötetään', {
        textui.start()
    }
    then 'viite on tallessa ohjelman tietämässä paikassa', {
        textui.getCommandStash().getRefList().get(0).getAuthor().shouldEqual "ransum"
    }
}