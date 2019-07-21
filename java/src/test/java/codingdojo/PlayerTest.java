package codingdojo;

import java.util.Collections;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

  // choose this one if you are familiar with mocks
  @Ignore("Test is not finished yet")
  @Test
  public void damageCalculationsWithMocks() {
    Inventory inventory = mock(Inventory.class);
    Stats stats = mock(Stats.class);
    SimpleEnemy target = mock(SimpleEnemy.class);

    Damage damage = new Player(inventory, stats).calculateDamage(target);
    assertEquals(10, damage.getAmount());
  }

  // choose this one if you are not familiar with mocks
  @Test
  public void damageCalculations() {
    Inventory inventory = new Inventory(defaultEquipment());
    Stats stats = new Stats(10);
    SimpleEnemy target = simpleEnemy();
    Damage damage = new Player(inventory, stats).calculateDamage(target);
    assertEquals(10, damage.getAmount());
  }

  private SimpleEnemy simpleEnemy() {
    return new SimpleEnemy(new SimpleArmor(5), Collections.singletonList(new BasicBuff(1f, 1f)));
  }

  private Equipment defaultEquipment() {
    return new Equipment(basicItem(), new BasicItem(10, 1), basicItem(), basicItem(), basicItem());
  }

  private BasicItem basicItem() {
    return new BasicItem(0, 0);
  }
}
