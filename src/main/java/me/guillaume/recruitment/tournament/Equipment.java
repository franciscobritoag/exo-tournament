package me.guillaume.recruitment.tournament;

/**
 * Interface defining the contract for all equipment items in the tournament system.
 */
public interface Equipment {
    
    /**
     * Modifies the damage dealt by the warrior.
     * @param baseDamage the base damage before modification
     * @return the modified damage
     */
    int modifyDamage(int baseDamage);
    
    /**
     * Modifies the damage received by the warrior.
     * @param incomingDamage the incoming damage before modification
     * @return the modified damage
     */
    int modifyReceivedDamage(int incomingDamage);
    
    /**
     * Returns the name of this equipment.
     */
    String getName();
} 