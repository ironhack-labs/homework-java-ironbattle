# IronBattle


## Character

Serves as the foundation for warrior and wizard classes, defining shared attributes and behaviors for characters in the battle simulator.

#### Methods

- **receiveAttack(attack)**: Reduce the character's health points by the specified amount.
- **checkIsAlive()**: Checks if the character is still alive based on their health points and updates the isAlive flag accordingly.

## Warrior
Represents a warrior character in the battle simulator.

#### Methods
- **attack(Character)**: Randomly chooses between *heavyAttack* and *weakAttack* based on a generated number.
Checks available stamina before executing either attack and updates warrior's stamina and opponent's health after each attack.

- **heavyAttack(Character)**: Full warrior strength damage and reduces warrior's stamina by 5, but requires sufficient stamina to attack.

- **weakAttack(Character)**: Half warrior strength damage and recovers warrior's stamina by 1.

## Wizard
Represents a warrior character in the battle simulator.

#### Methods
- **attack(Character)**: Uses either "Fireball" or "Staff Hit" based on mana availability. 
"Fireball" deals damage based on intelligence but consumes mana. "Staff Hit" deals fixed damage and regenerates mana. 
Throws an exception when attempting an attack without sufficient mana.


## Battle

#### Methods
- **battleOpposite(Warrior, Wizard)**: Creates a battle between the two characters. It iterates through rounds display on the console the events of the battle.
First the characters attack each other and receives damage. Then check's if any character is the characters are still alive.
If someone is dead the remaining characters is the winner and in the case that both are dead is a tie.
- **battleWarriors(Warrior, Warrior)**: the same as battleOpposite but for both Warrior characters.
- **battleWizards(Wizard, Wizard)**: the same as battleOpposite but for both Wizard characters.

## Generator
This class provides methods to randomly generate attributes for different character types in your game. 

#### Methods
- **generatorWarrior()**: Randomly generates a hp value between 100 and 200 for using on the creation of a randomized Warrior.
- **generatorWizard()**: Randomly generates a hp value between 50 and 100 for using on the creation of a randomized Wizard.
- **generatorStrength()**: Randomly generates a strength value between 1 and 10.
- **generatorMana()**: Randomly generates a mana value between 10 and 50.
- **generatorIntelligence()**: Randomly generates an intelligence value between 1 and 50.

## How To Use

When executed the program will display a Menu on the console with a different options:

- Create Warrior
- Create Wizard
- Start Battle
- Create random battle
- Exit

### Create Warrior
After manually introducing the name, hp, strength and stamina inputs a new Warrior character is created.

### Create Wizard
After manually introducing the name, hp, mana and intelligence inputs a new Wizard character is created.

### Start Battle
Starts a new battle if two characters are created. The characters could be from the same type or different. It's up to you.

### Create a random battle
Starts a battle with randomly created characters with no manual effort from your part.

### Exit
If you don`t want to play anymore you could choose to exit the program.