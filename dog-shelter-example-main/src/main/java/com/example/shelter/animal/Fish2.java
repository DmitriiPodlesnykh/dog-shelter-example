package com.example.shelter.animal;

public abstract class Fish2
{
    public String name = "Fish2";

    public Gender gender;

    public abstract void doNothing();

    public static class Fish3
    {
        public String name = "Fish3";

    }

    public class FishNonStaticInner
    {
        public String name = "Fish3";
    }

    private enum Gender
    {
        F,
        M,
        U,
    }

}

class Fish
{
    public String name = "Fish";

    void a()
    {
        //nameDefault = " ";
    }
}
