import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*
import wad.pohjalimat.uicommands.*

description 'Käyttäjänä pystyn luomaan ja tallentamaan .bib-tyyppiseen tiedostoon bibtex-dataa'

scenario "käyttäjä luoda .bib-tyyppisen tiedoston halutulla tiedostonimellä", {
    given 'komento save valittu', {
        io = new StubIO("save", "kameli","exit")
        textui = new TextUI(io)
    }
    when 'käyttäjä haluaa tallentaa tiedoston nimellä kameli', {
         textui.start()
    }
    then 'varmistetaan, että tiedosto ilmestyi', {
        f = new File("kameli.bib")
        assert f.exists()
        f.delete()
    }
}
