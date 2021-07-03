package com.pds.state.phone;

import com.pds.state.phone.states.NoCall;
import com.pds.state.phone.states.StateCall;
import lombok.Getter;

@Getter
public class ContextPhone {

    private StateCall state;
    private Integer quantityCall;
    private Integer activeCall;


    public ContextPhone() {
        this.state = new NoCall(this);
        activeCall = 0;
        quantityCall = 0;
    }

    public void changeState(StateCall state) {
        this.state = state;
    }

    public void newCall() {
        quantityCall += 1;
        activeCall += 1;
    }

    public void endCall() {
        quantityCall -= 1;
        activeCall = quantityCall.equals(1) ? 1 : 0;
    }

    public void changeCall() {
        activeCall = activeCall.equals(2) ? 1 : 2;
    }


}
