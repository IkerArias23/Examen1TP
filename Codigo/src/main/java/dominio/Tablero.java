/*
 * Copyright 2025 Iker
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Esta clase es responsable de leer el tablero de un
 * fichero en forma de ceros y unos, ir transitando de
 * estados e ir mostrando dichos estados.
 */
public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual; // matriz que representa el estado actual
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION]; // matriz que representa el estado siguiente

    /**
     * Constructor de la clase Tablero.
     * Inicializa el estado actual como una matriz vacía de DIMENSION x DIMENSION.
     */
    public Tablero() {
        estadoActual = new int[DIMENSION][DIMENSION];
    }

    /**
     * Lee el estado inicial de un fichero llamado 'matriz'.
     * La secuencia de ceros y unos del fichero es guardada en 'estadoActual' y,
     * utilizando las reglas del juego de la vida, se insertan los ceros y unos
     * correspondientes en 'estadoSiguiente'.
     *
     * @throws IOException si hay problemas al leer el fichero
     */
    public void leerEstadoActual() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/matriz"))) {
            String linea;
            int fila = 0;


            while ((linea = br.readLine()) != null && fila < DIMENSION) {
                for (int columna = 0; columna < linea.length() && columna < DIMENSION; columna++) {
                    estadoActual[fila][columna] = Character.getNumericValue(linea.charAt(columna));
                }
                fila++;
            }


            calcularEstadoSiguiente();

        } catch (IOException e) {
            System.err.println("Error al leer el fichero matriz: " + e.getMessage());
        }
    }

    /**
     * Genera un estado inicial aleatorio. Para cada celda genera un número aleatorio
     * en el intervalo [0, 1). Si el número es menor que 0,5, entonces la celda está
     * inicialmente viva. En caso contrario, está muerta.
     * La secuencia de ceros y unos generada es guardada en 'estadoActual' y,
     * utilizando las reglas del juego de la vida, se insertan los ceros y unos
     * correspondientes en 'estadoSiguiente'.
     */
    public void generarEstadoActualPorMontecarlo() {
        Random random = new Random();


        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = (random.nextDouble() < 0.5) ? 1 : 0;
            }
        }


        calcularEstadoSiguiente();
    }

    /**
     * Transita al estado siguiente según las reglas del juego de la vida.
     * La variable 'estadoActual' pasa a tener el contenido de 'estadoSiguiente'
     * y, este último atributo pasa a reflejar el siguiente estado.
     */
    public void transitarAlEstadoSiguiente() {

        for (int i = 0; i < DIMENSION; i++) {
            System.arraycopy(estadoSiguiente[i], 0, estadoActual[i], 0, DIMENSION);
        }


        calcularEstadoSiguiente();
    }

    /**
     * Metodo privado que calcula el estado siguiente a partir del estado actual
     * según las reglas del juego de la vida.
     */
    private void calcularEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinasVivas = contarVecinasVivas(i, j);


                if (estadoActual[i][j] == 1) {

                    if (vecinasVivas == 2 || vecinasVivas == 3) {

                        estadoSiguiente[i][j] = 1;
                    } else {

                        estadoSiguiente[i][j] = 0;
                    }
                } else {

                    if (vecinasVivas == 3) {

                        estadoSiguiente[i][j] = 1;
                    } else {

                        estadoSiguiente[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * Metodo privado que cuenta el número de células vivas alrededor de una posición.
     *
     * @param fila fila de la célula
     * @param columna columna de la célula
     * @return número de células vivas alrededor de la posición (fila, columna)
     */
    private int contarVecinasVivas(int fila, int columna) {
        int count = 0;


        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }


                int filaVecina = (fila + i + DIMENSION) % DIMENSION;
                int columnaVecina = (columna + j + DIMENSION) % DIMENSION;


                if (estadoActual[filaVecina][columnaVecina] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Devuelve, en modo texto, el estado actual.
     *
     * @return el estado actual en forma de cadena de texto donde 'x' representa una célula viva
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (estadoActual[i][j] == 1) {
                    resultado.append("x");
                } else {
                    resultado.append(" ");
                }
            }
            resultado.append("\n");
        }

        return resultado.toString();
    }
}