package me.guillaume.recruitment.tournament;

/**
 * Viking warrior with 120 hit points and a one-handed axe.
 */
public class Viking extends Warrior {
    
    private static final int HIT_POINTS = 120;
    
    public Viking() {
        super("Viking", HIT_POINTS, new OneHandedAxe());
    }
} 