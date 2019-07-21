package codingdojo;

public class SimpleEnemy extends Target {

  private final Armor armor;
  private final Buffs buffs;

  public SimpleEnemy(final Armor armor, final Buffs buffs) {
    this.armor = armor;
    this.buffs = buffs;
  }

  @Override
  protected int getSoak(final int totalDamage) {
    return Math.round(armor.getDamageSoak() * (buffs.getSoakModifier() + 1f));
  }
}
