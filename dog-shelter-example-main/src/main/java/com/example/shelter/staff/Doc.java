package com.example.shelter.staff;

import org.apache.commons.lang3.*;

public class Doc extends Staff implements Person
{
    public static int  salary = 10000;

    public static final int AVERAGE_SALARY = 100;

    public String firstName = "Ivan";

    public final String gender = null;

    public Doc(final String firstName)
    {
        System.out.println(this.firstName);
        this.firstName = firstName;
    }
    public Doc()
    {
    }

    @Override
    public void sleep()
    {
        boolean isEmpty1 = StringUtils.isEmpty(firstName);
        boolean isEmpty = false;
        if (firstName != null && !firstName.equals(""))
        {
            isEmpty = false;
        }
        else {
            isEmpty = true;
        }
        firstName = "eded";
    }

    @Override
    public String help()
    {
        return "лечить";
    }

    public static void setSalary(int newSalary)
    {
        salary = newSalary;
    }

    public void setFirstName(String firstName)
    {
        setSalary(1000);
        this.firstName = firstName;
    }
}
