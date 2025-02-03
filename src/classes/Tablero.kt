package classes

class Tablero() {

    companion object {
        const val SIZE_TABLERO = 3
        const val PIEZA_JUGADOR_1 = "X"
        const val PIEZA_JUGADOR_2 = "O"
        const val PIEZA_VACIA = "-"
    }

    private val tablero = Array(SIZE_TABLERO) {Array(SIZE_TABLERO) { PIEZA_VACIA} }

    fun colocarPieza(jugador: Jugador, posiciones: MutableList<Int>) {
        when(jugador.numeroJugador) {
            1 -> {
                if (comprobarPiezaValida(posiciones)) {
                    val posicionX = posiciones[0]
                    val posicionY = posiciones[1]
                    tablero[posicionX][posicionY] = PIEZA_JUGADOR_1
                }
            }
            2 -> {
                if (comprobarPiezaValida(posiciones)) {
                    val posicionX = posiciones[0]
                    val posicionY = posiciones[1]
                    tablero[posicionX][posicionY] = PIEZA_JUGADOR_2
                }
            }
            else -> {
                println("ERROR >> Ese jugador no existe")
            }
        }
    }

    private fun comprobarPiezaValida(posiciones: MutableList<Int>): Boolean {

        val x = posiciones[0]
        val y = posiciones[1]

        if (tablero[x][y] == PIEZA_VACIA) {
            return true
        }
        return false
    }


    override fun toString(): String {

        val mostrarTablero = StringBuilder()
        mostrarTablero.append("\n---------\n")
        for (fila in tablero) {
            mostrarTablero.append(fila.joinToString(" | "))
            mostrarTablero.append("\n---------\n")
        }
        return mostrarTablero.toString()
    }
}