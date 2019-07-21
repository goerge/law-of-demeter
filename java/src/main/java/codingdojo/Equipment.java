package codingdojo;

class Equipment {
  // TODO add a ring item that may be equipped
  //  that may also add damage modifier
  private final Item leftHand;
  private final Item rightHand;
  private final Item head;
  private final Item feet;
  private final Item chest;

  Equipment(final Item leftHand, final Item rightHand, final Item head, final Item feet, final Item chest) {
    this.leftHand = leftHand;
    this.rightHand = rightHand;
    this.head = head;
    this.feet = feet;
    this.chest = chest;
  }

  Item getLeftHand() {
    return leftHand;
  }

  Item getRightHand() {
    return rightHand;
  }

  Item getHead() {
    return head;
  }

  Item getFeet() {
    return feet;
  }

  Item getChest() {
    return chest;
  }
}
