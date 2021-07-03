package com.pds.state.phone.states;

import com.pds.state.phone.ContextPhone;
import com.pds.state.phone.MessagePhone;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WaitCall implements StateCall {
    private final ContextPhone contextPhone;

    @Override
    public String cancelCall() {
        String message = "Sem chamada ativa para cancelar";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String acceptCall() {
        Integer MAX_CALLS = 2;
        String message;
        Integer quantityCalls;
        Integer activeCall;
        if (contextPhone.getQuantityCall().equals(MAX_CALLS)){
            message = "Numero de chamadas simultaneas excedida";
            quantityCalls = contextPhone.getQuantityCall();
            activeCall = contextPhone.getActiveCall();
            return new MessagePhone(message, quantityCalls, activeCall).toString();
        }
        message = "Atendendo segunda chamada";
        contextPhone.newCall();
        contextPhone.changeState(new ActiveCall(contextPhone));
        quantityCalls = contextPhone.getQuantityCall();
        activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String createCall() {
        Integer MAX_CALLS = 2;
        String message;
        Integer quantityCalls;
        Integer activeCall;
        if (contextPhone.getQuantityCall().equals(MAX_CALLS)){
            message = "Numero de chamadas simultaneas excedida";
            quantityCalls = contextPhone.getQuantityCall();
            activeCall = 0;
            return new MessagePhone(message, quantityCalls, activeCall).toString();
        }
        message = "Atendendo segunda chamada";
        contextPhone.newCall();
        contextPhone.changeState(new ActiveCall(contextPhone));
        quantityCalls = contextPhone.getQuantityCall();
        activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String waitingCall() {
        String message = "Chamadas já em espera";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = 0;
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String returnToCall() {
        String message = "Retornando para chamada ativa";
        contextPhone.changeState(new ActiveCall(contextPhone));
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String changeCall() {
        String message = "Sem chamada ativa para alternar";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = 0;
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }
}
