package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {

  private final Armor armor;
  private final List<Buff> buffs;

  public SimpleEnemy(final Armor armor, final List<Buff> buffs) {
    this.armor = armor;
    this.buffs = buffs;
  }

  List<Buff> getBuffs() {
    return buffs;
  }

  Armor getArmor() {
    return armor;
  }

  @Override
  protected int getSoak(final int totalDamage) {
    final int soak;
    final SimpleEnemy simpleEnemy = this;
    soak = Math.round(
      simpleEnemy.getArmor().getDamageSoak() *
        (
          ((float) simpleEnemy.getBuffs()
            .stream()
            .mapToDouble(Buff::soakModifier)
            .sum()) +
            1f
        )
    );
    return soak;
  }
}
