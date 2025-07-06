package me.guillaume.recruitment.tournament;

/**
 * Highlander warrior with 150 hit points and a Great Sword.
 * Veteran variant goes berserk when health drops below 30%.
 */
public class Highlander extends Warrior {
    
    private static final int HIT_POINTS = 150;
    private static final double BERSERK_THRESHOLD = 0.3;
    private static final int BERSERK_MULTIPLIER = 2;
    
    private final boolean isVeteran;
    
    public Highlander() {
        this("Highlander");
    }
    
    public Highlander(String name) {
        super(name, HIT_POINTS, new GreatSword());
        this.isVeteran = "Veteran".equals(name);
    }
    
    @Override
    protected int applySpecialAbilities(int damage) {
        if (isVeteran && getHealthPercentage() <= BERSERK_THRESHOLD) {
            return damage * BERSERK_MULTIPLIER;
        }
        return damage;
    }
    
    /**
     * Returns the percentage of health remaining.
     */
    private double getHealthPercentage() {
        return (double) hitPoints / maxHitPoints;
    }
} 