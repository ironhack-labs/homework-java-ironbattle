# Java IronBattle

## How to Run

1. Open the project in IntelliJ IDEA.
2. Locate the `Main` class in the project structure.
3. Right-click on the `Main` class and select "Run 'Main'".
4. Follow the prompts in the IntelliJ console.

### Character Creation

- When prompted, choose the type of character:
    - Enter `1` for Warrior
    - Enter `2` for Wizard

- Enter the character's name when prompted.

### Battle Simulation

- The battle is 1 vs. 1 and occurs in rounds.
- Each round, characters attack each other.
- Detailed logs of the battle are displayed on the command line.
- In case of a tie (both characters die in the same round), the game restarts with the same characters until there is a clear winner.

### Character Attributes

- Characters can have two types: Wizard or Warrior.
- Initial HP values are randomly assigned:
  - Warriors: `HP` between 100-200
  - Wizards: `HP` between 50-100
- Warriors have:
  - `Stamina`: Random between 10-50
  - `Strength`: Random between 1-10
- Wizards have:
  - `Mana`: Random between 10-50
  - `Intelligence`: Random between 1-50

### Character Attacks

#### Warrior

- Heavy Attack:
    - Damage: Strength
    - Stamina cost: 5

- Weak Attack:
    - Damage: Half of Strength
    - Stamina cost: None
    - Stamina cost: 1

- No stamina for attacks:
    - No damage inflicted
    - Stamina recovery: 2

#### Wizard

- Fireball:
    - Damage: Intelligence
    - Mana cost: 5

- Staff Hit:
    - Damage: 2
    - Mana cost: None
    - Mana cost: 1

- Recovery:
    - No damage inflicted
    - Mana recovery: 2
