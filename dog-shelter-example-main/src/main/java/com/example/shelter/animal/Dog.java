package com.example.shelter.animal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Important class
 */
public class Dog extends Resident implements Animal, Pet
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
        //this.dogStatus=dogStatus;
        // this.visitTime=visitTime;
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

    }
}
