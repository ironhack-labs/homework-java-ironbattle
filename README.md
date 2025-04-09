# Iron Battle Simulator

## Descripción

Este proyecto es un simulador de batallas RPG en el que dos personajes (un **Guerrero** o un **Mago**) luchan entre sí hasta que haya un ganador. El simulador permite crear personajes personalizados, generar personajes aleatorios o cargar personajes desde un archivo CSV.

## Requisitos

- **Java 21**.

## Instrucciones de Uso

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/dsuarezg/java-ironbattle
cd java-ironbattle
```

### 2. Compilar y ejecutar el proyecto

1. Abre el proyecto en tu IDE o compílalo desde la terminal.
2. Ejecuta la clase `Play` para iniciar el simulador.

### 3. Menú principal

Al ejecutar el programa, verás el siguiente menú:

```
======== Iron Battle ========
1. Leer personajes desde un archivo CSV
2. Generar personajes aleatorios
3. Crear tus propios personajes
4. Salir
=============================
Elige una opción:
```

#### Opción 1: Leer personajes desde un archivo CSV

- Crea un archivo llamado `characters.csv` en el directorio raíz del proyecto.
- El archivo debe tener el siguiente formato:

```
//Tipo,Nombre
Wizard,Gandalf
Warrior,Aragorn
```

- El programa leerá los personajes del archivo y los enfrentará en batallas.

#### Opción 2: Generar personajes aleatorios

- Ingresa un número impar de personajes para generar.
- El programa creará personajes aleatorios (Guerreros y Magos) y los enfrentará en batallas.

#### Opción 3: Crear tus propios personajes

- Crea dos personajes personalizados ingresando sus atributos (nombre, puntos de vida, etc.).
- Los personajes se enfrentarán en una batalla.

#### Opción 4: Salir

- Finaliza el programa.

## Archivos de Demostración

- **Archivo CSV de ejemplo**: `characters.csv`

```csv
Warrior,Thorgrim Ironfist
Wizard,Eldric Shadowweave
Warrior,Bjorn Steelcrusher
Wizard,Mystara Starweaver
Warrior,Krom Bloodaxe
Wizard,Zephyr Spellwind
Warrior,Ragnar Stormbreaker
Wizard,Lumina Frostwhisper
Warrior,Grimgar Steelheart
```

## Notas Importantes

- Asegúrate de que los valores de los atributos de los personajes estén dentro de los rangos especificados en las instrucciones.
- Si el número de personajes generados es impar, uno de ellos quedará fuera de las batallas.

## Estructura del Proyecto

- **`Character`**: Clase base abstracta para todos los personajes.
- **`Warrior`**: Subclase de `Character` que representa a un guerrero.
- **`Wizard`**: Subclase de `Character` que representa a un mago.
- **`Attacker`**: Interfaz que define el método `attack()` para los personajes.
- **`Play`**: Clase principal que contiene el menú y la lógica de las batallas.