package me.guillaume.recruitment.tournament;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the attack strategy pattern implementation.
 */
public class AttackStrategyTest {
    
    @Test
    public void standardAttackStrategy_shouldAttackEveryRound() {
        AttackStrategy strategy = new StandardAttackStrategy();
        
        for (int i = 0; i < 10; i++) {
            assertThat(strategy.canAttack(i)).isTrue();
        }
    }
    
    @Test
    public void greatSwordAttackStrategy_shouldAttack2OutOf3Rounds() {
        AttackStrategy strategy = new GreatSwordAttackStrategy();
        
        // First 3 rounds: should attack in rounds 0 and 1, not in round 2
        assertThat(strategy.canAttack(0)).isTrue();  // Round 0: attack
        assertThat(strategy.canAttack(1)).isTrue();  // Round 1: attack
        assertThat(strategy.canAttack(2)).isFalse(); // Round 2: no attack
        
        // Next 3 rounds: should attack in rounds 3 and 4, not in round 5
        assertThat(strategy.canAttack(3)).isTrue();  // Round 3: attack
        assertThat(strategy.canAttack(4)).isTrue();  // Round 4: attack
        assertThat(strategy.canAttack(5)).isFalse(); // Round 5: no attack
        
        // Pattern repeats
        assertThat(strategy.canAttack(6)).isTrue();  // Round 6: attack
        assertThat(strategy.canAttack(7)).isTrue();  // Round 7: attack
        assertThat(strategy.canAttack(8)).isFalse(); // Round 8: no attack
    }
    
    @Test
    public void weapons_shouldHaveCorrectAttackStrategies() {
        // Standard weapons should use standard strategy
        Weapon oneHandedSword = new OneHandedSword();
        Weapon oneHandedAxe = new OneHandedAxe();
        
        assertThat(oneHandedSword.getAttackStrategy()).isInstanceOf(StandardAttackStrategy.class);
        assertThat(oneHandedAxe.getAttackStrategy()).isInstanceOf(StandardAttackStrategy.class);
        
        // Great Sword should use special strategy
        Weapon greatSword = new GreatSword();
        assertThat(greatSword.getAttackStrategy()).isInstanceOf(GreatSwordAttackStrategy.class);
    }
} 