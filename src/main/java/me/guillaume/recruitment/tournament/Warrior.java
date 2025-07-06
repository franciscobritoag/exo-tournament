package me.guillaume.recruitment.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Base for all warriors in the tournament system.
 * Implements the core combat mechanics and equipment system.
 */
public abstract class Warrior {
    
    protected int hitPoints;
    protected final int maxHitPoints;
    protected final String name;
    protected final List<Equipment> equipment;
    protected final Weapon weapon;
    private int roundCounter = 0;
    
    protected Warrior(String name, int hitPoints, Weapon weapon) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.hitPoints = hitPoints;
        this.maxHitPoints = hitPoints;
        this.weapon = Objects.requireNonNull(weapon, "Weapon cannot be null");
        this.equipment = new ArrayList<>();
    }
    
    public int hitPoints() {
        return hitPoints;
    }
    
    /**
     * Equips an item to the warrior.
     */
    @SuppressWarnings("unchecked")
    public <T extends Warrior> T equip(String equipmentName) {
        Equipment equipment = EquipmentFactory.create(equipmentName);
        this.equipment.add(equipment);
        return (T) this;
    }
    
    /**
     * Engages in combat with another warrior.
     * Implements sequential combat: this warrior strikes first, then the opponent responds.
     */
    public void engage(Warrior opponent) {
        Objects.requireNonNull(opponent, "Opponent cannot be null");
        
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            attack(opponent);
            
            if (opponent.hitPoints > 0) {
                opponent.attack(this);
            }
        }
    }
    
    /**
     * Performs an attack on the given opponent.
     */
    protected void attack(Warrior opponent) {
        int damage = calculateOutgoingDamage();
        opponent.receiveDamage(damage);
    }
    
    /**
     * Calculates the outgoing damage this warrior deals in an attack (only this warrior's equipment).
     */
    protected int calculateOutgoingDamage() {
        if (weapon.getAttackStrategy().canAttack(roundCounter)) {
            int baseDamage = weapon.getDamage();
            for (Equipment equip : equipment) {
                baseDamage = equip.modifyDamage(baseDamage);
            }
            baseDamage = applySpecialAbilities(baseDamage);
            roundCounter++;
            return Math.max(0, baseDamage);
        } else {
            roundCounter++;
            return 0;
        }
    }
    
    /**
     * Receives damage from an attack, considering only this warrior's equipment protection.
     */
    protected void receiveDamage(int damage) {
        int finalDamage = calculateIncomingDamage(damage);
        this.hitPoints = Math.max(0, this.hitPoints - finalDamage);
    }
    
    /**
     * Calculates the final damage received after this warrior's equipment protection.
     */
    protected int calculateIncomingDamage(int incomingDamage) {
        int finalDamage = incomingDamage;
        for (Equipment equip : equipment) {
            finalDamage = equip.modifyReceivedDamage(finalDamage);
        }
        return Math.max(0, finalDamage);
    }
    
    /**
     * Hook method for subclasses to implement special abilities.
     */
    protected int applySpecialAbilities(int damage) {
        return damage;
    }
    
} 