package com.example.restapitask;

import lombok.Data;

@Data
public class Message {
    String sender;
    String receiver;
    String text;
    boolean seen;

}
