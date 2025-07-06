package me.guillaume.recruitment.tournament;

/**
 * One-handed axe weapon that deals 6 damage per strike.
 */
public class OneHandedAxe implements Weapon {
    
    private static final int DAMAGE = 6;
    private static final String NAME = "One-Handed Axe";
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