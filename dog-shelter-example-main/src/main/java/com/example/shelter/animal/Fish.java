package com.example.shelter.animal;

import java.time.LocalDate;

public class Fish implements Animal
{
    private String name = "Fish";

    private LocalDate lastVisit = LocalDate.now();

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public LocalDate getLastVisit()
    {
        return lastVisit;
    }

    public void setLastVisit(final LocalDate lastVisit)
    {
        this.lastVisit = lastVisit;
    }

    @Override
    public String sayHello()
    {
        return null;
    }

    @Override
    public void eat()
    {

    }
}
