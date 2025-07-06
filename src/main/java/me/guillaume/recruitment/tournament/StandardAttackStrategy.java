package me.guillaume.recruitment.tournament;

/**
 * Standard attack strategy that allows attacking every round.
 * Used by most weapons like swords and axes.
 */
public class StandardAttackStrategy implements AttackStrategy {
    
    @Override
    public boolean canAttack(int roundNumber) {
        return true;
    }
} 