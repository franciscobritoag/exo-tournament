package me.guillaume.recruitment.tournament;

/**
 * Axe equipment that can be equipped to replace the default weapon.
 * This is a special equipment that modifies the weapon damage.
 */
public class Axe implements Equipment {
    
    private static final String NAME = "Axe";
    private static final int AXE_DAMAGE = 6;
    
    @Override
    public int modifyDamage(int baseDamage) {
        // Replace the base damage with axe damage
        return AXE_DAMAGE;
    }
    
    @Override
    public int modifyReceivedDamage(int incomingDamage) {
        // Axe doesn't modify received damage
        return incomingDamage;
    }
    
    @Override
    public String getName() {
        return NAME;
    }
    
} 