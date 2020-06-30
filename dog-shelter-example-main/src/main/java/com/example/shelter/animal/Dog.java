package com.example.shelter.animal;

/**
 * Important class
 */
public class Dog
{
    public int id;
    public String name = "Sharic";
    public LocalDateTime visitTime = LocalDateTime.now();
    public DogStatus dogStatus = DogStatus.ADMITTED;

    public Dog(final int id, final String name)
    {
        this.id = id;
        this.name = name;
    }

    public Dog()
    {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", visitTime=" + visitTime +
                ", dogStatus=" + dogStatus +
                '}';
    }
}
