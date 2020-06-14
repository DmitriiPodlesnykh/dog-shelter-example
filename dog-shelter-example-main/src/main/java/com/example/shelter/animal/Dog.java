package com.example.shelter.animal;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Important class
 */
public class Dog
{
    public String name = "Sharic";
    public LocalDateTime admissionDate = LocalDateTime.now();

    ZoneOffset offset = ZoneOffset.of("+02:00");
    OffsetDateTime offSetByTwo = OffsetDateTime
            .of(admissionDate, offset);

    public String status = "admitted";

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", admissionDate=" + admissionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
