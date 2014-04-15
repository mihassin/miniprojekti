import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn näyttämään listan viitteistä selkokielisenä'

scenario "käyttäjä voi listata tallennetut viitteet selkokielisillä tiedoilla", {
    given 'komento print valittu', {
        io = new StubIO("addentry", "inproceedings", "refKey", "ransum", "Master's thesis", "sinep", "2015", "editor", "3", "series", "10--20", "address", "month", "publisher", "organisation", "note", "isbn4000-232", "print", "exit")
        textui = new TextUI(io)
    }
    when 'käyttäjä haluaa nähdä selkokieliset tiedot viitteistä', {
        textui.start()
    }
    then 'ohjelma tulostaa tallessa olevat viitteet selkokielisinä', {
        io.getOutput().shouldHave("ransum")
    }
}