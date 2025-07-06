package me.guillaume.recruitment.tournament;

/**
 * One-handed sword weapon that deals 5 damage per strike.
 */
public class OneHandedSword implements Weapon {
    
    private static final int DAMAGE = 5;
    private static final String NAME = "One-Handed Sword";
    private static final AttackStrategy ATTACK_STRATEGY = new StandardAttackStrategy();
    
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