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
}
