package me.guillaume.recruitment.tournament;

/**
 * Buckler equipment that blocks all damage every other hit and is destroyed after 3 axe blows.
 * Each buckler instance maintains its own state independently.
 */
public class Buckler implements Equipment {
    
    private static final String NAME = "Buckler";
    private static final int MAX_AXE_BLOWS = 3;
    
    private int hitCounter = 0;
    private int axeBlowCounter = 0;
    private boolean isDestroyed = false;
    
    @Override
    public int modifyDamage(int baseDamage) {
        return baseDamage;
    }
    
    @Override
    public int modifyReceivedDamage(int incomingDamage) {
        if (isDestroyed) {
            return incomingDamage;
        }
        
        if (incomingDamage <= 0) {
            return 0;
        }
        
        hitCounter++;
        boolean willBlock = hitCounter % 2 == 1;
        
        if (willBlock) {
            // Only increment axe block counter if this is a blocked axe blow
            if (incomingDamage == 6) {
                axeBlowCounter++;
                if (axeBlowCounter >= MAX_AXE_BLOWS) {
                    isDestroyed = true;
                }
            }
            return 0;
        }
        
        return incomingDamage;
    }
    
    @Override
    public String getName() {
        return NAME;
    }
    
} 