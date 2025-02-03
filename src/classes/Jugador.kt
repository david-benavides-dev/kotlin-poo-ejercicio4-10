package classes

class Jugador(private var nombre: String, var numeroJugador: Int) {

    fun cambiarNombre() {
        print("Introduce tu nombre >> ")
        val nuevoNombre = readln()
        this.nombre = nuevoNombre
    }

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