package com.example.shelter.staff;

public class Doc extends Staff implements Person
{
    @Override
    public void sleep()
    {

    }

    @Override
    public String help()
    {
        return "лечить";
    }

    @Override
    public int getSalary()
    {
        return 100;
    }

}
