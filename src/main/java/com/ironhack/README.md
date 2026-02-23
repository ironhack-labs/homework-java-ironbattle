# ⚔️ IronBattle — Java RPG Battle Simulator

A console-based RPG battle simulator built in Java as part of the Ironhack Java bootcamp homework. Two characters face off in turn-based combat until one (or both) are defeated.

---

## 📖 Description

IronBattle pits a **Warrior** and a **Wizard** (or any combination) against each other in a round-by-round duel. Each round, both combatants attack simultaneously — meaning even a fatal blow doesn't guarantee victory if your own HP hits zero at the same time. In the event of a tie, the battle restarts until there is a single winner.


---

## 🧩 Class Overview

### `Attacker` (Interface)
Defines a single method: `void attack(Character target)` — implemented by both Warrior and Wizard.

### `Character` (Abstract Class)
Base class for all combatants. Contains:
- `id` — auto-generated unique identifier
- `name` — character name
- `hp` — health points
- `isAlive` — alive/dead flag (defaults to `true`)

### `Warrior` extends `Character`
A melee fighter who consumes **stamina** to deal damage.

| Attribute | Range |
|-----------|-------|
| HP        | 100–200 |
| Stamina   | 10–50 |
| Strength  | 1–10 |

**Attack logic:**
- **Heavy Attack** — deals `strength` damage, costs 5 stamina *(random chance)*
- **Weak Attack** — deals `strength / 2` damage, restores 1 stamina *(used if not enough stamina for heavy)*
- **Rest** — deals 0 damage, restores 2 stamina *(used if not enough for weak attack)*

### `Wizard` extends `Character`
A spell caster who consumes **mana** to deal damage.

| Attribute    | Range |
|--------------|-------|
| HP           | 50–100 |
| Mana         | 10–50 |
| Intelligence | 1–50 |

**Attack logic:**
- **Fireball** — deals `intelligence` damage, costs 5 mana *(random chance)*
- **Staff Hit** — deals 2 damage, restores 1 mana *(used if not enough mana for fireball)*
- **Rest** — deals 0 damage, restores 2 mana *(used if not enough for staff hit)*

---

## 🕹️ How to Play

1. Launch the program.
2. Use the text menu (via standard input) to:
    - Create Warriors and Wizards with custom names and stats.
    - Start a battle between two characters.
3. Watch the full battle log printed to the console.
4. The winner is announced at the end. If it's a tie, the battle restarts automatically.

---

## ▶️ Running the Project

**Prerequisites:** Java 17+, Maven or open in IntelliJ IDEA and run `Main.java` directly.

---

## 📋 Requirements Met

- [x] Text-based menu with Standard I/O
- [x] Create Warriors and Wizards with custom stats
- [x] Round-by-round battle with simultaneous attacks
- [x] Detailed combat log printed to console
- [x] Tie detection with automatic restart

### Bonus
- [x] Import characters from CSV
- [x] Auto-simulate battle with randomly generated characters

---
## Source:

This README.md was created by __claude.ai__