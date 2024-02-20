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


## Battle
