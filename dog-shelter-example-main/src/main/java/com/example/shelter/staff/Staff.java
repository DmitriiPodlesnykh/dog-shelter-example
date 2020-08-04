package com.example.shelter.staff;

public class Staff implements Person
{
    public String category = " ";

    public String action = "( - )";

    public Staff(final String category)
    {
        this.category = category;
    }

    public Staff()
    {
    }

    @Override
    public void sleep()
    {

    }

    public String help()
    {
        return action;
    }

    @Override
    public int getSalary()
    {
        return 1;
    }
}
