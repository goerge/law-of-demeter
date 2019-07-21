package codingdojo;

public class Inventory {
  private final Equipment equipment;

  public Inventory(final Equipment equipment) {
    this.equipment = equipment;
  }

  float getDamageModifier() {
    return equipment.getDamageModifier();
  }

  int getBaseDamage() {
    return equipment.getBaseDamage();
  }
}
