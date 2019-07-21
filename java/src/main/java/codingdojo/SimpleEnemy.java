package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {

  private final Armor armor;
  private final List<Buff> buffs;

  public SimpleEnemy(final Armor armor, final List<Buff> buffs) {
    this.armor = armor;
    this.buffs = buffs;
  }

  @Override
  protected int getSoak(final int totalDamage) {
    return Math.round(armor.getDamageSoak() * (soakModifier() + 1f));
  }

  private float soakModifier() {
    return (float) buffs
      .stream()
      .mapToDouble(Buff::soakModifier)
      .sum();
  }
}
