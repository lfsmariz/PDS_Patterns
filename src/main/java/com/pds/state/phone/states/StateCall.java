package com.pds.state.phone.states;

public interface StateCall {
    String cancelCall();
    String acceptCall();
    String createCall();
    String waitingCall();
    String returnToCall();
    String changeCall();
}
