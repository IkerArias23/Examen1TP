/*
 * Copyright 2025 Tu Nombre
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
package mates;

import java.util.Random;

/**
 * Esta clase contiene métodos para realizar cálculos matemáticos.
 */
public class Matematicas {

    /**
     * Genera una aproximación al número pi mediante el método de Montecarlo.
     * El método genera puntos aleatorios en un cuadrado de lado 2 centrado en el origen,
     * y calcula la proporción de puntos que caen dentro del círculo unitario.
     * La proporción multiplicada por el área del cuadrado (4) da una aproximación a pi.
     *
     * @param pasos el número de puntos a generar
     * @return aproximación al número pi
     */
    public static double generarNumeroPi(long pasos) {
        Random random = new Random();
        long aciertos = 0;
        double areaCuadrado = 4.0;

        for (long i = 0; i < pasos; i++) {
            double x = random.nextDouble() * 2 - 1; // Valores entre -1 y 1
            double y = random.nextDouble() * 2 - 1;


            if (x * x + y * y <= 1) {
                aciertos++;
            }
        }


        return areaCuadrado * ((double) aciertos / pasos);
    }
}