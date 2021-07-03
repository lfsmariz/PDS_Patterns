package com.pds.state.phone.states;

import com.pds.state.phone.ContextPhone;
import com.pds.state.phone.MessagePhone;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ActiveCall implements StateCall {
    private ContextPhone contextPhone;

    @Override
    public String cancelCall() {
        String message = "Chamada encerrada!";
        contextPhone.endCall();
        if(contextPhone.getQuantityCall().equals(0)) {
            contextPhone.changeState(new NoCall(contextPhone));
        }
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
            activeCall = contextPhone.getActiveCall();
            return new MessagePhone(message, quantityCalls, activeCall).toString();
        }
        message = "Realizando segunda chamada";
        contextPhone.newCall();
        quantityCalls = contextPhone.getQuantityCall();
        activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String waitingCall() {
        String message = "Chamada em espera";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = 0;
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String returnToCall() {
        String message = "Retornando da chamada em espera";
        Integer quantityCalls = contextPhone.getQuantityCall();
        Integer activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }

    @Override
    public String changeCall() {
        Integer MAX_CALLS = 2;
        String message;
        Integer quantityCalls;
        Integer activeCall;
        if (contextPhone.getQuantityCall().equals(MAX_CALLS)){
            message = "Troca de chamada ativa";
            contextPhone.changeCall();
            quantityCalls = contextPhone.getQuantityCall();
            activeCall = contextPhone.getActiveCall();
            return new MessagePhone(message, quantityCalls, activeCall).toString();
        }
        message = "Sem segunda chamada ativa";
        quantityCalls = contextPhone.getQuantityCall();
        activeCall = contextPhone.getActiveCall();
        return new MessagePhone(message, quantityCalls, activeCall).toString();
    }
}
