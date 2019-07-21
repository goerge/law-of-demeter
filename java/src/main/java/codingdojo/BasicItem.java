package codingdojo;

public class BasicItem implements Item {

  private final int baseDamage;
  private final int damageModifier;

  public BasicItem(final int baseDamage, final int damageModifier) {
    this.baseDamage = baseDamage;
    this.damageModifier = damageModifier;
  }

  @Override
  public int getBaseDamage() {
    return baseDamage;
  }

  @Override
  public float getDamageModifier() {
    return damageModifier;
  }
}
