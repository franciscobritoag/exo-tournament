package me.guillaume.recruitment.tournament;

/**
 * Interface defining the contract for all weapons in the tournament system.
 */
public interface Weapon {
    
    /**
     * Returns the base damage this weapon deals.
     */
    int getDamage();
    
    /**
     * Returns the name of this weapon.
     */
    String getName();
    
    /**
     * Returns the attack strategy for this weapon.
     */
    AttackStrategy getAttackStrategy();
} 