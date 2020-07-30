package com.example.shelter.animal;

public abstract class Resident implements Animal
{
    public String name = "Resident#1";

    public boolean isExist()
    {
        return true;
    }


    public String sayHello()
    {
        return "Hello guys";
    }

}
