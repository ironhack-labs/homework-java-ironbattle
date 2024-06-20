public interface Attacker {

    // The attack method, as required by the Attacker interface.
    // Determines whether to perform a heavy or weak attack based on the warrior's current stamina,
    // then adjusts the target's HP and the warrior's stamina accordingly.
    void attack(Character character);
}
