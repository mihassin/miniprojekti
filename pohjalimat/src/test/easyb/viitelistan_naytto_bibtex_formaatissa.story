import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn näyttämään listan viitteistä BibTex-formaatissa'

scenario "käyttäjä voi listata tallennetut viitteet BibTex-formaatin tiedoilla", {
    given 'komento bibtex valittu', {
        io = new StubIO("addentry", "refKey", "ransum", "Masters thesis", "sinep", "2015", "bibtex", "exit")
        textui = new TextUI(io)
    }
    when 'käyttäjä haluaa nähdä  tiedot viitteistä BibTex-formaatissa', {
         textui.start()
    }
    then 'ohjelma tulostaa tallessa olevat viitteet BibTex-formaatin tiedoilla', {
       io.getOutput().shouldHave("@INPROCEEDINGS{refKey,")
    }
}