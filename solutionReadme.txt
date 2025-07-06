Tournament System - Solution Overview
====================================

PROJECT DESCRIPTION
------------------
This is a knights tournament simulation system implementing sequential combat mechanics 
between different warrior types (Swordsman, Viking, Highlander) with various weapons 
and equipment. The system handles complex interactions like buckler blocking patterns, 
Great Sword attack frequencies, and special abilities like berserk mode.

ARCHITECTURE OVERVIEW
--------------------
The solution follows a clean object-oriented design with clear separation of concerns:

- Warrior hierarchy with abstract base class and concrete implementations
- Weapon interface with different damage-dealing strategies  
- Equipment system for damage modification and protection
- Factory pattern for equipment instantiation
- Fluent interface for equipment chaining
- Strategy pattern for weapon attack patterns

KEY DESIGN DECISIONS
-------------------
1. Abstract Base Class Pattern
   - Centralized combat logic in Warrior base class
   - Hook methods (applySpecialAbilities) for subclass extensions
   - Template method pattern for attack/receive damage flow

2. Equipment System
   - Interface-based design for extensibility
   - Separate damage modification for outgoing vs incoming damage
   - Stateful equipment (Buckler) with proper lifecycle management

3. Factory Pattern
   - EquipmentFactory provides clean creation mechanism
   - Easy to add new equipment types without modifying existing code
   - Consistent instantiation across the system

4. Strategy Pattern for Attack Patterns
   - AttackStrategy interface defines when weapons can attack
   - StandardAttackStrategy for normal weapons (attack every round)
   - GreatSwordAttackStrategy for two-handed weapons (2 out of 3 rounds)
   - Weapons encapsulate their own attack patterns
   - Easy to add new attack patterns without modifying warrior classes

5. Pragmatic Compromises
   - Buckler axe detection uses damage value (6) - documented for future double dispatch
   - Single buckler state per instance - acceptable given interface constraints

RUNNING THE TESTS
----------------
Prerequisites:
- Java 11 or higher
- Maven 3.6+

From the project root directory compile and run all tests:
   mvn test

The test suite includes:
- Basic warrior vs warrior combat
- Equipment interactions (buckler blocking)
- Complex scenarios (armored combat, special abilities)
- Bonus test (vicious swordsman vs veteran highlander)
- Attack strategy pattern tests

BUILD VERIFICATION
-----------------
All tests should pass with the following output:
Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

EXTENSION POINTS
---------------
The architecture supports easy extension for:
- New warrior types (extend Warrior class)
- New weapons (implement Weapon interface)  
- New equipment (implement Equipment interface)
- Special abilities (override applySpecialAbilities hook)
- New attack patterns (implement AttackStrategy interface)

FUTURE IMPROVEMENTS
------------------
- Double dispatch pattern for weapon-equipment interaction
- State pattern for equipment lifecycle management
- Observer pattern for health-based abilities
- Composite pattern for complex weapon combinations

NOTES
-----
- Original test class remains unchanged as per requirements