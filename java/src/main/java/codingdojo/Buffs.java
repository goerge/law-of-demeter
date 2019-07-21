package codingdojo;

import java.util.List;

public class Buffs {
  final List<Buff> buffs;

  public Buffs(final List<Buff> buffs) {
    this.buffs = buffs;
  }

  float getSoakModifier() {
    return (float) buffs
      .stream()
      .mapToDouble(Buff::soakModifier)
      .sum();
  }
}
