package com.example.shelter.staff;

public class Sponsor extends Staff implements Person
{

    @Override
    public void sleep()
    {
    }

    @Override
    public String help()
    {
        return "дать денег";
    }

    @Override
    public int getSalary()
    {
        return 0;
    }
}
