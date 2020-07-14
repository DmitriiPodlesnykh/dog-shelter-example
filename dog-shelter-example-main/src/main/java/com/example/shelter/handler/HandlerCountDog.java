package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import com.example.shelter.db.ShelterDataAccess;
import com.example.shelter.db.ShelterDataAccessInterface;

public class HandlerCountDog implements Handler
{
    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context ctx) throws Exception
    {
        int countDogs = shelterDataAccess.getCountDogs();

        System.out.println("Count dogs = " + countDogs);
        ctx.result("Count dogs = " + countDogs);
    }
}
