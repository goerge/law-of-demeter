package codingdojo;

class Player extends Target {
  private final Inventory inventory;
  private final Stats stats;

  Player(final Inventory inventory, final Stats stats) {
    this.inventory = inventory;
    this.stats = stats;
  }

  Damage calculateDamage(final Target other) {
    final int baseDamage = inventory.getBaseDamage();
    final float damageModifier = stats.getStrengthModifier() + inventory.getDamageModifier();
    final int totalDamage = Math.round(baseDamage * damageModifier);
    final int soak = getSoak(other, totalDamage);
    return new Damage(Math.max(0, totalDamage - soak));
  }

  private int getSoak(Target other, int totalDamage) {
    int soak = 0;
    if (other instanceof Player) {
      // TODO: Not implemented yet
      //  Add friendly fire
      soak = totalDamage;
    } else if (other instanceof SimpleEnemy) {
      SimpleEnemy simpleEnemy = (SimpleEnemy) other;
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
    }
    return soak;
  }
}
