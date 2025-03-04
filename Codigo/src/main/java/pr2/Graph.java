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

package pr2;

import java.util.*;

/**
 * Implementación de un grafo dirigido mediante listas de adyacencia.
 * @param <V> tipo de los vértices del grafo.
 */
public class Graph<V> {

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /**
     * Añade el vértice 'v' al grafo.
     *
     * @param v vértice a añadir.
     * @return 'true' si no estaba anteriormente y 'false' en caso contrario.
     */
    public boolean addVertex(V v) {
        if (adjacencyList.containsKey(v)) {
            return false;
        }
        adjacencyList.put(v, new HashSet<>());
        return true;
    }

    /**
     * Añade un arco entre los vértices 'v1' y 'v2' al grafo. En
     * caso de que no exista alguno de los vértices, lo añade también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return 'true' si no existía el arco y 'false' en caso contrario.
     */
    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);

        Set<V> adjacents = adjacencyList.get(v1);
        return adjacents.add(v2);
    }

    /**
     * Obtiene el conjunto de vértices adyacentes a 'v'.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     * @throws Exception si el vértice no existe en el grafo.
     */
    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("El vértice no existe en el grafo.");
        }
        return new HashSet<>(adjacencyList.get(v));
    }

    /**
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return 'true' si 'v' es un vértice del grafo.
     */
    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    /**
     * Método 'toString()' reescrito para la clase 'Graph'.
     * @return una cadena de caracteres con la lista de adyacencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v.toString()).append(": ");
            for (V adj : adjacencyList.get(v)) {
                sb.append(adj.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Obtiene, en caso de que exista, un camino entre 'v1' y 'v2'.
     * En caso contrario, devuelve 'null'.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde 'v1' hasta 'v2'
     * pasando por arcos del grafo.
     */
    public List<V> onePath(V v1, V v2) {
        if (!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) {
            return null;
        }


        Map<V, V> trace = new HashMap<>();


        Stack<V> open = new Stack<>();

        open.push(v1);
        trace.put(v1, null);
        boolean found = false;

        while (!open.isEmpty() && !found) {
            V v = open.pop();

            if (v.equals(v2)) {
                found = true;
            } else {
                Set<V> adjacents;
                try {
                    adjacents = obtainAdjacents(v);
                    for (V s : adjacents) {
                        if (!trace.containsKey(s)) {
                            open.push(s);
                            trace.put(s, v);
                        }
                    }
                } catch (Exception e) {
                    }
            }
        }

        if (found) {

            List<V> path = new ArrayList<>();
            V current = v2;
            while (current != null) {
                path.add(0, current);
                current = trace.get(current);
            }
            return path;
        } else {
            return null;
        }
    }
}