import classes.*

fun main() {

    val tablero = Tablero()

    val jugador1 = Jugador("Jugador Uno", 1)
    val jugador2 = Jugador("Jugador Dos", 2)

    jugador1.cambiarNombre()
    jugador2.cambiarNombre()

    val posiciones = jugador1.pedirPosiciones()

    tablero.colocarPieza(jugador1,posiciones)

    println(tablero)

}