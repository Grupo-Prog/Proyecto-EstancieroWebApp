package com.estanciero.api.models.enums;

public enum CardEffectType {
    PAY_TO_BANK,
    PAY_TO_ALL_PLAYERS,
    PAY_PER_PROPERTY,
    RECEIVE_FROM_BANK,
    RECEIVE_FROM_ALL_PLAYERS,
    GO_TO_JAIL,
    GET_OUT_OF_JAIL,
    // mover hacia x chacra
    MOVE_TO_BOX,
    // mover x casillas para adelante o para atras
    MOVE_X_AMOUNT
}
