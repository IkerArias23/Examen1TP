/**
 * Copyright 2025 Iker
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
import dominio.Tablero;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Principal {
    private static Scanner input = new Scanner(System.in);
    private static Tablero tablero = new Tablero();

    public static void main(String[] args) {
        boolean salir = false;

        System.out.println("                JUEGO DE LA VIDA                       ");
        System.out.println("*******************************************************");

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();

            try {
                switch (opcion) {
                    case 1:
                        simularTableroLeido();
                        break;
                    case 2:
                        simularTableroMontecarlo();
                        break;
                    case 3:
                        configurarSimulacion();
                        break;
                    case 4:
                        mostrarAyuda();
                        break;
                    case 5:
                        System.out.println("\nSaliendo del programa...");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nOpción no válida. Intente de nuevo.");
                }
            } catch (InterruptedException e) {
                System.out.println("Error durante la simulación: " + e.getMessage());
            }

            if (!salir) {
                System.out.println("\nPulse ENTER para continuar...");
                input.nextLine();
            }
        }

        input.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n----- MENÚ PRINCIPAL -----");
        System.out.println("1. Simular con tablero leído");
        System.out.println("2. Simular con tablero generado por Montecarlo");
        System.out.println("3. Configurar parámetros de simulación");
        System.out.println("4. Ayuda");
        System.out.println("5. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return 0; // Opción inválida
        }
    }

    private static void simularTableroLeido() throws InterruptedException {
        System.out.println("\n----- SIMULACIÓN CON TABLERO LEÍDO -----");
        tablero.leerEstadoActual();
        System.out.println("Estado inicial:");
        System.out.println(tablero);

        System.out.print("Número de iteraciones a simular: ");
        int iteraciones = Integer.parseInt(input.nextLine());

        System.out.print("Tiempo entre iteraciones (segundos): ");
        int tiempoEspera = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= iteraciones; i++) {
            TimeUnit.SECONDS.sleep(tiempoEspera);
            tablero.transitarAlEstadoSiguiente();
            System.out.println("Iteración " + i + ":");
            System.out.println(tablero);
        }

        System.out.println("Simulación finalizada.");
    }

    private static void simularTableroMontecarlo() throws InterruptedException {
        System.out.println("\n----- SIMULACIÓN CON TABLERO GENERADO POR MONTECARLO -----");
        tablero.generarEstadoActualPorMontecarlo();
        System.out.println("Estado inicial:");
        System.out.println(tablero);

        System.out.print("Número de iteraciones a simular: ");
        int iteraciones = Integer.parseInt(input.nextLine());

        System.out.print("Tiempo entre iteraciones (segundos): ");
        int tiempoEspera = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= iteraciones; i++) {
            TimeUnit.SECONDS.sleep(tiempoEspera);
            tablero.transitarAlEstadoSiguiente();
            System.out.println("Iteración " + i + ":");
            System.out.println(tablero);
        }

        System.out.println("Simulación finalizada.");
    }

    private static void configurarSimulacion() {
        System.out.println("\n----- CONFIGURACIÓN DE SIMULACIÓN -----");
        System.out.println("Nota: Esta funcionalidad requeriría modificar la clase Tablero");
        System.out.println("para permitir la configuración de sus parámetros.");
    }

    private static void mostrarAyuda() {
        System.out.println("\n----- AYUDA -----");
        System.out.println("El Juego de la Vida es un autómata celular diseñado por John Conway en 1970.");
        System.out.println("Reglas:");
        System.out.println("1. Una célula muerta con exactamente 3 células vecinas vivas nace.");
        System.out.println("2. Una célula viva con 2 o 3 células vecinas vivas sigue viva.");
        System.out.println("3. En cualquier otro caso, una célula muere o permanece muerta.");
        System.out.println("\nOpciones del programa:");
        System.out.println("- Tablero leído: Carga un estado inicial desde un archivo.");
        System.out.println("- Tablero Montecarlo: Genera un estado inicial aleatorio.");
    }
}
