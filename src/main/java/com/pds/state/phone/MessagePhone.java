package com.pds.state.phone;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MessagePhone {
    private String message;
    private Integer quantityCalls;
    private Integer activeCall;
}
