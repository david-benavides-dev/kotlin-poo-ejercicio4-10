package classes

/**
 * Clase que representa un juego entre dos jugadores.
 *
 * @property j1 El primer jugador.
 * @property j2 El segundo jugador.
 */
class Juego(var j1: Jugador, var j2: Jugador) {
    companion object {
        var RONDA = 0
        var GANADOR = false
    }

    /**
     * Verifica las condiciones de victoria en el tablero.
     *
     * Este método revisa las filas, columnas y diagonales del tablero
     * para determinar si alguno de los jugadores ha ganado.
     *
     * @param table El tablero en el que se está jugando.
     * @return 1 si gana el Jugador 1, 2 si gana el Jugador 2, o 0 si no hay ganador.
     */
    private fun condicionGanador(table: Tablero): Int {
        for (i in 0..<Tablero.SIZE_TABLERO) {
            if (table.tablero[i][0] == Tablero.PIEZA_JUGADOR_1 &&
                table.tablero[i][1] == Tablero.PIEZA_JUGADOR_1 &&
                table.tablero[i][2] == Tablero.PIEZA_JUGADOR_1
            ) {
                return 1
            }
            if (table.tablero[i][0] == Tablero.PIEZA_JUGADOR_2 &&
                table.tablero[i][1] == Tablero.PIEZA_JUGADOR_2 &&
                table.tablero[i][2] == Tablero.PIEZA_JUGADOR_2
            ) {
                return 2
            }
        }

        for (i in 0..<Tablero.SIZE_TABLERO) {
            if (table.tablero[0][i] == Tablero.PIEZA_JUGADOR_1 &&
                table.tablero[1][i] == Tablero.PIEZA_JUGADOR_1 &&
                table.tablero[2][i] == Tablero.PIEZA_JUGADOR_1
            ) {
                return 1
            }
            if (table.tablero[0][i] == Tablero.PIEZA_JUGADOR_2 &&
                table.tablero[1][i] == Tablero.PIEZA_JUGADOR_2 &&
                table.tablero[2][i] == Tablero.PIEZA_JUGADOR_2
            ) {
                return 2
            }
        }

        if (table.tablero[0][0] == Tablero.PIEZA_JUGADOR_1 &&
            table.tablero[1][1] == Tablero.PIEZA_JUGADOR_1 &&
            table.tablero[2][2] == Tablero.PIEZA_JUGADOR_1
        ) {
            return 1
        }
        if (table.tablero[0][2] == Tablero.PIEZA_JUGADOR_1 &&
            table.tablero[1][1] == Tablero.PIEZA_JUGADOR_1 &&
            table.tablero[2][0] == Tablero.PIEZA_JUGADOR_1
        ) {
            return 1
        }
        if (table.tablero[0][0] == Tablero.PIEZA_JUGADOR_2 &&
            table.tablero[1][1] == Tablero.PIEZA_JUGADOR_2 &&
            table.tablero[2][2] == Tablero.PIEZA_JUGADOR_2
        ) {
            return 2
        }
        if (table.tablero[0][2] == Tablero.PIEZA_JUGADOR_2 &&
            table.tablero[1][1] == Tablero.PIEZA_JUGADOR_2 &&
            table.tablero[2][0] == Tablero.PIEZA_JUGADOR_2
        ) {
            return 2
        }

        return 0
    }

    /**
     * Inicia la partida entre los dos jugadores.
     *
     * Este método controla el flujo del juego, solicitando a los jugadores
     * que introduzcan sus posiciones, actualizando el tablero y verificando
     * si hay un ganador después de cada movimiento.
     */
    fun comenzarPartida() {

        val tablero = Tablero()

        while (!GANADOR) {
            val posiciones1 = j1.pedirPosiciones()
            tablero.colocarPieza(j1, posiciones1)
            println(tablero)

            val posiciones2 = j2.pedirPosiciones()
            tablero.colocarPieza(j2, posiciones2)
            println(tablero)


            RONDA ++

            when (condicionGanador(tablero)) {
                1 -> {
                    println("Gana el Jugador 1")
                    GANADOR = true
                }

                2 -> {
                    println("Gana el Jugador2")
                    GANADOR = true
                }
            }
        }
    }
}