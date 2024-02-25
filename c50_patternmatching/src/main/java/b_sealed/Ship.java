package b_sealed;

public sealed interface Ship permits SailingShip, Ferry {
}
