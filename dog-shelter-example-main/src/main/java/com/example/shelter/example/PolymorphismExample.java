package com.example.shelter.example;

import io.javalin.http.Handler;

import com.example.shelter.handler.HandlerAllDogs;
import com.example.shelter.handler.HandlerCountDog;
import com.example.shelter.handler.HandlerDogsListByStatus;

public class PolymorphismExample
{

    public static void startExample()
    {
        String exampleResultWithPolymorphism = startExampleWithPolymorphism();
        String exampleResultWithoutPolymorphism = startExampleWithoutPolymorphism();

        boolean isEqualsStrings = exampleResultWithoutPolymorphism.equals(exampleResultWithPolymorphism); //true
        System.out.println("exampleResultWithPolymorphism = " + exampleResultWithPolymorphism);
        System.out.println("exampleResultWithoutPolymorphism = " + exampleResultWithoutPolymorphism);
        System.out.println("Result = " + isEqualsStrings);

    }

    private static String startExampleWithPolymorphism()
    {
        Handler h1 = new HandlerCountDog();
        String r1 = testGetCurrentClassPlusGreeting(h1); // testGetCurrentClassPlusGreeting(Handler h)

        Handler h2 = new HandlerDogsListByStatus();
        String r2 = testGetCurrentClassPlusGreeting(h2); // testGetCurrentClassPlusGreeting(Handler h)

        Handler h3 = new HandlerAllDogs();
        String r3 =  testGetCurrentClassPlusGreeting(h3); // testGetCurrentClassPlusGreeting(Handler h)

        return r1 +r2+r3;
    }

    private static String startExampleWithoutPolymorphism()
    {
        HandlerCountDog h1 = new HandlerCountDog();
        String r1 = testGetCurrentClassPlusGreeting(h1); // testGetCurrentClassPlusGreeting(HandlerCountDog h)

        HandlerDogsListByStatus h2 = new HandlerDogsListByStatus(); // testGetCurrentClassPlusGreeting(HandlerDogsListByStatus h)
        String r2 = testGetCurrentClassPlusGreeting(h2);

        HandlerAllDogs h3 = new HandlerAllDogs();
        String r3 =  testGetCurrentClassPlusGreeting(h3); // testGetCurrentClassPlusGreeting(HandlerAllDogs h)

        return r1 +r2+r3;
    }

    /**
     * @param h any Handler
     */
    private static String testGetCurrentClassPlusGreeting(Handler h)
    {
        String clazz = h.getClass().toString();
        return "Hello, " + clazz + ". Bye!";
    }

    /**
     * @param h HandlerCountDog
     */
    private static String testGetCurrentClassPlusGreeting(HandlerCountDog h)
    {
        String clazz = h.getClass().toString();
        return "Hello, " + clazz + ". Bye!";
    }

    /**
     * @param h HandlerDogsListByStatus
     */
    private static String testGetCurrentClassPlusGreeting(HandlerDogsListByStatus h)
    {
        String clazz = h.getClass().toString();
        return "Hello, " + clazz + ". Bye!";
    }

    /**
     * @param h HandlerAllDogs
     */
    private static String testGetCurrentClassPlusGreeting(HandlerAllDogs h)
    {
        String clazz = h.getClass().toString();
        return "Hello, " + clazz + ". Bye!";
    }
}
