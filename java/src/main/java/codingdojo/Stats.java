package codingdojo;

public class Stats {
  // TODO add dexterity that will both help with soak and damage.
  //  but half of what strength gives.
  private final int strength;

  public Stats(final int strength) {
    this.strength = strength;
  }

  int getStrength() {
    return strength;
  }
}
