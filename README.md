![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# HW | Java IronBattle (Unit 1 homework)

## Introduction

In this homework, you will implement a basic RPG battle simulator that will consist of having two characters fighting to determine one winner.

## Instructions

Let's walk through the details of the homework:

### Classes

Three classes and one interface are necessary to complete this homework:

- These classes will be named: **Character**, **Warrior** and **Wizard**.
- This interface will be called **Attacker**.

<br>

**Attacker interface**

This interface will have:

- A public void function `attack()` that takes a character as a parameter.

We have two types of characters, warriors and wizards, who have different attributes and combat styles. You need to create a character class (that can't be instantiated) that will contain base attributes that are common for both - warriors and wizards.

<br>

**Character class**

This class will have:

- Variable called `id` of data type `string`, auto-generated (Private member)
- Variable called `name` of data type `string` (Private member)
- Variable called `hp` of data type `int`, random between 100-200 to warriors and 50-100 for wizards, representing the health points (Private member)
- Variable called `isAlive` of data type `boolean` defaulted to `true` (Private member)
- A "parameterized" constructor that takes `name` and `hp` (as parameters)
- Public Getter functions to _access_ these variables
- Public Setter functions to _change_ these variables

<br>

**Warrior Class**

This class is derived from the `Character` class. A Warrior is a Character that fights by attacking. Attacks inflict damage and in order to do one, stamina is required

The Warrior class will have:

- Variable called `stamina` of data type `int`, random between 10-50, representing a resource the warrior consumes to make an attack (Private member)
- Variable called `strength` of data type `int`, random between 1-10, measuring how strong the warrior attack is (Private member)
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- A parameterized constructor that takes `name`, `hp`, `stamina` and `strength`
- A public function that overloads `attack()` implemented in the `Attacker` interface, that will take a character as a parameter and reduce that character's health based on the strength of the attack.

<br>

**Wizard class**

This class is derived from the `Character` class. A Wizard is a Character that fights by casting spells. Spells inflict damage and require mana to be cast.

The Wizard class will have:

- Variable called `mana` of data type `int`, random between 10-50, representing a resource the wizard consumes to cast spells (Private member)
- Variable called `intelligence` of data type `int`, random between 1-50, measuring how strong the wizard spells are (Private member)
- Public Getter functions to access these variables
- Public Setter functions to change these variables
- A parameterized constructor that takes `name`, `hp`, `mana` and `intelligence`
- A public function that overloads `attack()` implemented in the `Attacker` interface, that will take a character as a parameter and reduce that character's health based on the intelligence of the spell
<!-- - `mana` - number to represent a resource the wizard consumes to cast spells
- `intelligence` - number to calculate how strong the wizard spells are -->

## How the battle simulator works

The characters are created before the battle starts. They can have either the same character type or different character types.

The battle is 1 vs. 1 and will be by rounds, in each round both combatants will attack at the same time (so even if one combatant does the killing blow both will take damage). So the combat could end in a tie.
In case of a tie, the battle is restarted to have only one winner.

**A complete log of the battle will be displayed on the command line. When the battle is over the winner should be displayed as well.**

## Character Attacks

Both wizards and warriors will have the same attack command defined by an interface called `Attacker`.

- **Warrior:**

  Warriors are strong well-armored characters that focus on the attribute of strength. Every round a warrior will have randomly either a **Heavy attack** or a **Weak attack**. The damage of a **Heavy attack** is equal to their strength and every hit will decrease their stamina by 5 points. The damage of a **Weak attack** is half of the strength (truncate decimals). Every **Weak attack** will recover his stamina by 1.

  If a warrior does not have the stamina to make a **Heavy attack** he will do a **Weak attack** instead.

  If a warrior does not have the stamina to do a **Weak attack** he will not inflict any damage and recover his stamina by 2.

- **Wizard:**

  Wizards are the masters of the arcane their main attribute is intelligence. Every round a wizard will try to randomly cast either a **Fireball** or a **Staff hit**. The damage of a **Fireball** is equal to his intelligence and every **Fireball** will decrease their mana by 5 points. The damage of a staff hit is equal to 2. Every staff hit will recover his mana by 1.

  If a wizard does not have the mana to cast a **Fireball** he will do a **Staff hit** instead.

  If a wizard does not have the mana to cast a **Staff hit** he will not inflict any damage and recover his mana by 2.

## Requirements

For this project you must accomplish all of the following:

1.  Navigate through a text-based menu using Standard Input and Output.
2.  Create warriors and wizards individually customizing their stats and name.
3.  Have a battle between the characters and determines the winner.
4.  Keep a detailed log (on the standard output) of every action taken during the duels.

### Bonus

1. Import characters using a CSV file.
2. Simulate the whole battle with one command by creating random characters with random stats and making them duel.

## Important Notes

- Everyone in the squad should contribute equally to the project in time and lines of code written.
- All code must be reviewed before it is merged into the `master` branch.
- All squad members must participate in code review.
- Every repository should have a README file with clear instructions, demo files or any documentation needed so other teams don't have problems with the review.
- This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!