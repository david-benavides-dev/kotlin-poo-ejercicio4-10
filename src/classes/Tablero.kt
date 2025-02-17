package classes

/**
 * Clase que representa el tablero del juego.
 *
 * @property tablero Una matriz que representa el estado del tablero.
 */
class Tablero() {

    companion object {
        const val SIZE_TABLERO = 3
        const val PIEZA_JUGADOR_1 = "X"
        const val PIEZA_JUGADOR_2 = "O"
        const val PIEZA_VACIA = "-"
    }

    val tablero = Array(SIZE_TABLERO) {Array(SIZE_TABLERO) {PIEZA_VACIA} }

    /**
     * Coloca una pieza en el tablero en la posición especificada por el jugador.
     *
     * @param jugador El jugador que está colocando la pieza.
     * @param posiciones Una lista mutable que contiene las coordenadas [X, Y] donde se desea colocar la pieza.
     *
     * Si la posición es válida (es decir, está vacía), se coloca la pieza correspondiente al jugador.
     * Si la posición no es válida, no se realiza ninguna acción.
     */
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

    /**
     * Comprueba si la posición especificada es válida para colocar una pieza.
     *
     * @param posiciones Una lista mutable que contiene las coordenadas [X, Y] a comprobar.
     * @return true si la posición está vacía, false en caso contrario.
     */
    private fun comprobarPiezaValida(posiciones: MutableList<Int>): Boolean {

        val x = posiciones[0]
        val y = posiciones[1]

        return tablero[x][y] == PIEZA_VACIA
    }

    /**
     * Devuelve una representación en forma de cadena del tablero.
     *
     * @return Una cadena que muestra el estado actual del tablero.
     */
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