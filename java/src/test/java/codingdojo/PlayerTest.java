package codingdojo;

import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

  // choose this one if you are familiar with mocks
  @Test
  public void damageCalculationsWithMocks() {
    final Inventory inventory = mock(Inventory.class);
    when(inventory.getBaseDamage()).thenReturn(10);
    when(inventory.getDamageModifier()).thenReturn(0.9f);
    final Stats stats = mock(Stats.class);
    when(stats.getStrengthModifier()).thenReturn(0.1f);
    final SimpleEnemy target = mock(SimpleEnemy.class);
    when(target.getSoak(anyInt())).thenReturn(0);

    final Damage damage = new Player(inventory, stats).calculateDamage(target);
    assertEquals(10, damage.getAmount());
  }

  // choose this one if you are not familiar with mocks
  @Test
  public void damageCalculations() {
    final Inventory inventory = new Inventory(defaultEquipment());
    final Stats stats = new Stats(10);
    final SimpleEnemy target = simpleEnemy();
    final Damage damage = new Player(inventory, stats).calculateDamage(target);
    assertEquals(10, damage.getAmount());
  }

  private static SimpleEnemy simpleEnemy() {
    return new SimpleEnemy(new SimpleArmor(5), new Buffs(Collections.singletonList(new BasicBuff(1f, 1f))));
  }

  private static Equipment defaultEquipment() {
    return new Equipment(basicItem(), new BasicItem(10, 1), basicItem(), basicItem(), basicItem());
  }

  private static BasicItem basicItem() {
    return new BasicItem(0, 0);
  }
}
