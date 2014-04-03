import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*

description 'Käyttäjänä pystyn näyttämään listan viitteistä selkokielisenä'

scenario "käyttäjä voi listata tallennetut viitteet selkokielisillä tiedoilla", {
    given 'komento print valittu', {
        io = new StubIO("addentry", "refKey", "ransum", "Master's thesis", "sinep", "2015", "print", "exit")
        textui = new TextUI(io)
    }
    when 'käyttäjä haluaa nähdä selkokieliset tiedot viitteistä', {
        textui.start()
    }
    then 'ohjelma tulostaa tallessa olevat viitteet selkokielisinä', {
        io.getOutput().shouldHave("ransum")
    }
}