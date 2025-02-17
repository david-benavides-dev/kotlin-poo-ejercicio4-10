package classes

/**
 * Clase que representa a un jugador en el juego.
 *
 * @property nombre El nombre del jugador.
 * @property numeroJugador El número que identifica al jugador (1 o 2).
 */
class Jugador(private var nombre: String, var numeroJugador: Int) {

    init {
        cambiarNombre()
    }

    /**
     * Solicita al jugador que introduzca su nombre.
     * Este método se llama en el inicializador de la clase.
     */
    private fun cambiarNombre() {
        print("Introduce tu nombre >> ")
        val nuevoNombre = readln()
        this.nombre = nuevoNombre
    }

    /**
     * Solicita al jugador que introduzca las coordenadas de la posición donde desea colocar su pieza.
     *
     * @return Una lista mutable de enteros que representa las coordenadas [X, Y] donde el jugador desea colocar su pieza.
     * Las coordenadas son ajustadas para que comiencen desde 0.
     *
     * Si las coordenadas introducidas no son válidas (fuera del rango 1-3), se mostrará un mensaje de error
     * y se volverá a solicitar la entrada hasta que se introduzcan coordenadas válidas.
     */
    fun pedirPosiciones(): MutableList<Int> {

        var validarpieza = false

        val posiciones: MutableList<Int> = mutableListOf(0, 0)

        do {
            print("Introduce coordenada X >> ")
            val posicionUno = readln().toIntOrNull()
            print("Introduce coordenada Y >> ")
            val posicionDos = readln().toIntOrNull()

            if (posicionUno == null || posicionUno <= 0 || posicionUno > 3 || posicionDos == null || posicionDos <= 0 || posicionDos > 3) {
                println("ERROR >> Coordenada no válida.")
            } else {
                posiciones[0] = posicionUno -1
                posiciones[1] = posicionDos -1
                validarpieza = true
            }
        } while (!validarpieza)

        return posiciones
    }
}