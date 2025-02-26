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
package aplicacion;

import mates.Matematicas;

/**
 * Clase principal que muestra el cálculo del número PI
 * mediante el metodo de Montecarlo.
 */
public class Principal {

    /**
     * Metodo principal que ejecuta el programa.
     * Recibe como argumento el número de pasos para la aproximación.
     *
     * @param args argumentos de la línea de comandos.
     *             args[0] debe ser un número entero que indica la cantidad de puntos a generar.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java aplicacion.Principal <numero_de_pasos>");
            System.exit(1);
        }

        try {
            long pasos = Long.parseLong(args[0]);
            System.out.println("El número PI es " + Matematicas.generarNumeroPi(pasos));
        } catch (NumberFormatException e) {
            System.out.println("Error: El argumento debe ser un número entero");
            System.exit(1);
        }
    }
}