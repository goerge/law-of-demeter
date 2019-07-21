package codingdojo;

class Player extends Target {
  private final Inventory inventory;
  private final Stats stats;

  Player(final Inventory inventory, final Stats stats) {
    this.inventory = inventory;
    this.stats = stats;
  }

  Damage calculateDamage(final Target other) {
    final int baseDamage = getBaseDamage();
    final float damageModifier = getDamageModifier();
    final int totalDamage = Math.round(baseDamage * damageModifier);
    final int soak = getSoak(other, totalDamage);
    return new Damage(Math.max(0, totalDamage - soak));
  }

  private static int getSoak(final Target other, final int totalDamage) {
    int soak = 0;
    if (other instanceof Player) {
      // TODO: Not implemented yet
      //  Add friendly fire
      soak = totalDamage;
    } else if (other instanceof SimpleEnemy) {
      final SimpleEnemy simpleEnemy = (SimpleEnemy) other;
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

  private float getDamageModifier() {
    final Equipment equipment = inventory.getEquipment();
    final Item leftHand = equipment.getLeftHand();
    final Item rightHand = equipment.getRightHand();
    final Item head = equipment.getHead();
    final Item feet = equipment.getFeet();
    final Item chest = equipment.getChest();
    final float strengthModifier = stats.getStrength() * 0.1f;
    return strengthModifier +
      leftHand.getDamageModifier() +
      rightHand.getDamageModifier() +
      head.getDamageModifier() +
      feet.getDamageModifier() +
      chest.getDamageModifier();
  }

  private int getBaseDamage() {
    final Equipment equipment = inventory.getEquipment();
    final Item leftHand = equipment.getLeftHand();
    final Item rightHand = equipment.getRightHand();
    final Item head = equipment.getHead();
    final Item feet = equipment.getFeet();
    final Item chest = equipment.getChest();
    return leftHand.getBaseDamage() +
      rightHand.getBaseDamage() +
      head.getBaseDamage() +
      feet.getBaseDamage() +
      chest.getBaseDamage();
  }
}
