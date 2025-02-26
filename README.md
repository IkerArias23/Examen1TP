# 🎲 EVALUACIÓN INICIAL 📏

## 📝 Visión General
Este repositorio alberga tres ejercicios de programación implementados en Java:

1. 📐 **Estimación de Pi**: Uso del algoritmo de Montecarlo para calcular una aproximación de π
2. 🧬 **Autómata de Conway**: Representación del célebre Juego de la Vida
3. 🧭 **Exploración de Grafos**: Construcción de una estructura de grafo con capacidad de búsqueda de rutas

## ⭐ Características Principales

### Ejercicio 1: Estimación de Pi
- 🔢 Algoritmo de Montecarlo aplicado a la aproximación de π
- 🎲 Distribución aleatoria de puntos dentro del área cuadrada
- 📊 Determinación basada en cocientes de superficies

### Ejercicio 2: Autómata de Conway
- 🌱 Desarrollo íntegro del Juego de la Vida
- 📋 Lectura de patrones iniciales desde documentos
- 🎯 Creación probabilística de configuraciones iniciales
- 👀 Monitorización del desarrollo temporal

### Ejercicio 3: Navegación en Grafos
- 🔍 Implementación de grafos mediante listas de vecindad
- 🛣️ Sistema de búsqueda de trayectorias entre nodos
- 🧠 Metodología de desarrollo guiada por pruebas (TDD)

## 🔧 Entorno Técnico

- ☕ Java
- 📦 Maven
- 🧪 JUnit
- 🔖 Javadoc
- 📈 UML (Umbrello)
- 🗃️ Git

## 🚀 Puesta en Marcha

### Requisitos Previos
- Java 8 o posterior
- Maven (obligatorio para el ejercicio 3)

### Instrucciones de Compilación
```bash
# Para ejercicios 1 y 2 (utilizando makefile)
make compile

# Para ejercicio 3 (utilizando Maven)
mvn compile
```

### Comandos de Ejecución
```bash
# Ejercicio 1: Estimación de Pi (argumento: cantidad de iteraciones)
java -cp target/classes aplicacion.Principal 1000000

# Ejercicio 2: Autómata de Conway
java -cp target/classes Principal

# Ejercicio 3: Evaluación del grafo
mvn test
```

### Creación de Documentación
```bash
# Para ejercicios 1 y 2
make javadoc

# Para ejercicio 3
mvn javadoc:javadoc
```

## 📈 Estudio de Eficiencia

### Ejercicio 1: Estimación de Pi
- `generarNumeroPi(long pasos)`: O(n) donde n representa la cantidad de pasos

### Ejercicio 2: Autómata de Conway
- `leerEstadoActual()`: O(n²) donde n indica el tamaño del tablero
- `generarEstadoActualPorMontecarlo()`: O(n²)
- `transitarAlEstadoSiguiente()`: O(n²)
- `toString()`: O(n²)

### Ejercicio 3: Grafos
- `addVertex(V v)`: O(1)
- `addEdge(V v1, V v2)`: O(1)
- `obtainAdjacents(V v)`: O(1)
- `containsVertex(V v)`: O(1)
- `onePath(V v1, V v2)`: O(V + E) siendo V la cantidad de vértices y E las conexiones

## 📂 Arquitectura del Proyecto
```
.
├── 📁 .idea/
├── 📄 .gitignore
├── 📄 misc.xml
├── 📄 modules.xml
├── 📄 uiDesigner.xml
├── 📁 src/
│   ├── 📁 aplicacion/
│   │   └── 📄 Principal.java
│   ├── 📁 dominio/
│   │   └── 📄 Tablero.java
│   ├── 📁 mates/
│   │   └── 📄 Matematicas.java
│   └── 📁 pr2/
│       ├── 📄 Graph.java
│       └── 📄 Principal.java
├── 📄 .gitignore
├── 📄 LICENSE
├── 📄 Primera_Prueba_Evaluacion_Con...
└── 📄 README.md
```

## 🔎 Ilustraciones

### Estimación de Pi
```java
// Muestra del resultado
El número PI es 3.14159265358979
```

### Autómata de Conway
```
x
x x
xx
```

### Grafos
```java
// Demostración de búsqueda
Graph<Integer> g = new Graph<>();
g.addEdge(1, 2);
g.addEdge(1, 5);
g.addEdge(5, 6);
g.addEdge(6, 4);

List<Integer> path = g.onePath(1, 4); // Obtiene [1, 5, 6, 4]
```

## 📄 Licencia
```
Copyright 2025 Mario Blanco Heranz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 💻 Desarrollador

Creado con 💖 por Mario Blanco Herranz

## 👏 Menciones
- 🎓 Al docente por los recursos educativos
- 💡 A la comunidad Java por su documentación
- 🌠 A Conway por su contribución con el Juego de la Vida
