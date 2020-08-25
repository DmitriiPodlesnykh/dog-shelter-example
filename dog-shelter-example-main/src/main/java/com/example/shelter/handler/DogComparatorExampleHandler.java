package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.*;
import java.util.ArrayList;

import com.example.shelter.animal.Dog;

public class DogComparatorExampleHandler implements Handler
{
    @Override
    public void handle(final Context ctx) throws Exception
    {
        List<Dog> dogs = new ArrayList<>();
        Set<Dog> treeSetDog = new TreeSet<>();

        int a = 1;
        while (a < 20)
        {
            Dog dog = new Dog();
            dog.id = a;
            dog.name = "Vasua " + a;

            dogs.add(dog);
            treeSetDog.add(dog);

            a = a +1;
        }
        dogs.sort(new ComparatorById());
        ctx.html(
                "<p>result is </p>" + dogs + "<p>tree set =  </p>" + treeSetDog
        );

    }

    class ComparatorById implements Comparator<Dog>
    {

        @Override
        public int compare(final Dog o1, final Dog o2)
        {
            if(o1.id > o2.id)
            {
                return -1;
            } else {
                if ( o1.id < o2.id)
                {
                    return 1;
                }
            }
            return 0;
        }
    }
}
