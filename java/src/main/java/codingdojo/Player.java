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
    final int soak = other.getSoak(totalDamage);
    return new Damage(Math.max(0, totalDamage - soak));
  }

  @Override
  protected int getSoak(final int totalDamage) {
    // TODO: Not implemented yet
    //  Add friendly fire
    return totalDamage;
  }
}
