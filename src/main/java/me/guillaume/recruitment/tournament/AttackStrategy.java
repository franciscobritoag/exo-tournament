package me.guillaume.recruitment.tournament;

/**
 * Strategy interface for determining when a weapon can attack.
 * Different weapons can have different attack patterns.
 */
public interface AttackStrategy {
    
    /**
     * Determines if the weapon can attack in the given round.
     * @param roundNumber the current round number (0-based)
     * @return true if the weapon can attack, false otherwise
     */
    boolean canAttack(int roundNumber);
} 