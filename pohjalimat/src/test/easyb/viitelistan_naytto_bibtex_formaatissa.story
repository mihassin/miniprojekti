import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn näyttämään listan viitteistä BibTex-formaatissa'

scenario "käyttäjä voi listata tallennetut viitteet BibTex-formaatin tiedoilla", {
    given 'komento bibtex valittu', {
        io = new StubIO("addentry", "inproceedings", "refKey", "ransum", "Master's thesis", "sinep", "2015", "editor", "3", "series", "10--20", "address", "month", "publisher", "organisation", "note", "isbn4000-232", "bibtex", "exit")
        textui = new TextUI(io)
    }
    when 'käyttäjä haluaa nähdä  tiedot viitteistä BibTex-formaatissa', {
        textui.start()
    }
    then 'ohjelma tulostaa tallessa olevat viitteet BibTex-formaatin tiedoilla', {
        io.getOutput().shouldHave("@INPROCEEDINGS{refKey,")
    }
}