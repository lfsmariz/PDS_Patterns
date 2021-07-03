package com.pds.state.phone.states;

import com.pds.state.phone.ContextPhone;
import com.pds.state.phone.MessagePhone;
import com.pds.state.phone.states.ActiveCall;
import com.pds.state.phone.states.StateCall;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoCall implements StateCall {
    private ContextPhone contextPhone;

    @Override
    public String cancelCall() {
        String message = "Sem chamada ativa para cancelar";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String acceptCall() {
        String message = "Chamada aceita com sucesso";
        contextPhone.newCall();
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();

        contextPhone.changeState(new ActiveCall(contextPhone));

        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String createCall() {
        String message = "Chamada criada com sucesso";
        Integer quantityCalls = contextPhone.getQuantityCall();
        contextPhone.newCall();
        Integer activeCall = contextPhone.getActiveCall();

        contextPhone.changeState(new ActiveCall(contextPhone));

        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String waitingCall() {
        String message = "Sem chamada ativa para colocar em espera";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String returnToCall() {
        String message = "Sem chamada ativa para retornar";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String changeCall() {
        String message = "Sem chamada ativa para colocar em espera";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }
}
