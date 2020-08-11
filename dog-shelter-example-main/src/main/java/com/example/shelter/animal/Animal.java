package com.example.shelter.animal;

import java.io.Serializable;

public interface Animal extends Serializable
{
    String sayHello();

    void eat();
}
