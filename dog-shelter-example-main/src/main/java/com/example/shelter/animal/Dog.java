package com.example.shelter.animal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Important class
 */
public class Dog extends Resident implements Animal, Pet, Comparable<Dog>
{

    public static String AAAA = "dsasadsad";

    public int id;
    public String name = "Sharic";
    public LocalDateTime visitTime = LocalDateTime.now();
    public DogStatus dogStatus = DogStatus.ADMITTED;

    private List<String> description = new ArrayList<>();

    public Dog(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Dog() {
    }

    public void addDescription(String description)
    {
        this.description.add(description);
    }

    public void addDescription(List<String> listDescription)
    {
        description.addAll(listDescription);
    }

    public void addDescription(Set<String> setDescription)
    {
        description.addAll(setDescription);
    }

    public List<String> getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", visitTime=" + visitTime +
                ", dogStatus=" + dogStatus +
                '}';
    }

    @Override
    public void eat()
    {

        int a = 10;

        int b = 100;

        if (a > b)
        {
            System.out.println("a > b");
        }

    }

    @Override
    public int compareTo(Dog anotherDog){

        if(this.id > anotherDog.id)
        {
            return -1;
        } else {
           if ( this.id < anotherDog.id)
           {
               return 1;
           }
        }
        return 0;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        final Dog dog = (Dog)o;
        return id == dog.id &&
                Objects.equals(name, dog.name) &&
                Objects.equals(visitTime, dog.visitTime) &&
                dogStatus == dog.dogStatus &&
                Objects.equals(description, dog.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, visitTime, dogStatus, description);
    }
}
