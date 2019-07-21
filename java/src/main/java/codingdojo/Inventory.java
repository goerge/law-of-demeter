package codingdojo;

public class Inventory {
  private final Equipment equipment;

  public Inventory(final Equipment equipment) {
    this.equipment = equipment;
  }

  Equipment getEquipment() {
    return equipment;
  }
}
