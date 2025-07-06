package me.guillaume.recruitment.tournament;

/**
 * Attack strategy for Great Sword that allows attacking 2 out of every 3 rounds.
 * This represents the two-handed weapon's slower attack pattern.
 */
public class GreatSwordAttackStrategy implements AttackStrategy {
    
    private static final int ATTACK_FREQUENCY = 2;
    private static final int ROUND_CYCLE = 3;
    
    @Override
    public boolean canAttack(int roundNumber) {
        return (roundNumber % ROUND_CYCLE) < ATTACK_FREQUENCY;
    }
} 