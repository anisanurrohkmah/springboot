package com.projek.utils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator  {

    public String Random() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
