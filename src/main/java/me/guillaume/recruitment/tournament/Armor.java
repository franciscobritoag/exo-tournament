package me.guillaume.recruitment.tournament;

/**
 * Armor equipment that reduces received damage by 3 points and delivered damage by 1 point.
 */
public class Armor implements Equipment {
    
    private static final String NAME = "Armor";
    private static final int DAMAGE_REDUCTION = 3;
    private static final int DAMAGE_PENALTY = 1;
    
    @Override
    public int modifyDamage(int baseDamage) {
        return Math.max(0, baseDamage - DAMAGE_PENALTY);
    }
    
    @Override
    public int modifyReceivedDamage(int incomingDamage) {
        return Math.max(0, incomingDamage - DAMAGE_REDUCTION);
    }
    
    @Override
    public String getName() {
        return NAME;
    }
    
} 