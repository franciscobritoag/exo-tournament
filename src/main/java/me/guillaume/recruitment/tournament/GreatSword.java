package me.guillaume.recruitment.tournament;

/**
 * Great Sword weapon that deals 12 damage per strike.
 * Uses a special attack strategy that allows attacking 2 out of every 3 rounds.
 */
public class GreatSword implements Weapon {
    private static final int DAMAGE = 12;
    private static final String NAME = "Great Sword";
    private static final AttackStrategy ATTACK_STRATEGY = new GreatSwordAttackStrategy();

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public String getName() {
        return NAME;
    }
    
    @Override
    public AttackStrategy getAttackStrategy() {
        return ATTACK_STRATEGY;
    }
} 