package me.guillaume.recruitment.tournament;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory class for creating equipment instances.
 * Uses the Factory pattern for clean object creation.
 */
public class EquipmentFactory {
    
    private static final Map<String, Supplier<Equipment>> EQUIPMENT_CREATORS = Map.of(
        "buckler", Buckler::new,
        "armor", Armor::new,
        "axe", Axe::new
    );
    
    /**
     * Creates an equipment instance based on the given name.
     * @param equipmentName the name of the equipment to create
     * @return the created equipment instance
     * @throws IllegalArgumentException if the equipment name is not recognized or null
     */
    public static Equipment create(String equipmentName) {
        if (equipmentName == null) {
            throw new IllegalArgumentException("Equipment name cannot be null");
        }
        Supplier<Equipment> creator = EQUIPMENT_CREATORS.get(equipmentName.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown equipment: " + equipmentName);
        }
        return creator.get();
    }
} 