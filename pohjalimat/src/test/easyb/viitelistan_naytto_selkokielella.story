import wad.pohjalimat.*
import wad.pohjalimat.controller.*
import wad.pohjalimat.io.*
import wad.pohjalimat.model.*

description 'Käyttäjänä pystyn näyttämään listan viitteistä selkokielisenä'

scenario "käyttäjä voi listata tallennetut viitteet selkokielisillä tiedoilla", {
    given 'komento print valittu'
    when 'käyttäjä haluaa nähdä selkokieliset tiedot viitteistä'
    then 'ohjelma tulostaa tallessa olevat viitteet selkokielisinä'
}