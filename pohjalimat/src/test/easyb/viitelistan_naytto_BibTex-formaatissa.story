import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*

description 'Käyttäjänä pystyn näyttämään listan viitteistä BibTex-formaatissa'

scenario "käyttäjä voi listata tallennetut viitteet BibTex-formaatin tiedoilla", {
    given 'komento xxxx valittu'
    when 'käyttäjä haluaa nähdä  tiedot viitteistä BibTex-formaatissa'
    then 'ohjelma tulostaa tallessa olevat viitteet BibTex-formaatin tiedoilla'
}