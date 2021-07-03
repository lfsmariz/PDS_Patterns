package com.pds.state.phone;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MessagePhone {
    private final String message;
    private final Integer quantityCalls;
    private final Integer activeCall;
}
