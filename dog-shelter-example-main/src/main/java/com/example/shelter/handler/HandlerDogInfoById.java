package com.example.shelter.handler;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.dogs.select.DogSelectDataAccess;
import com.example.shelter.db.dogs.select.DogSelectDataAccessImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class HandlerDogInfoById implements Handler
{
    private DogSelectDataAccess dogSelectDataAccess = new DogSelectDataAccessImpl();

    @Override
    public void handle(final Context ctx) throws Exception
    {
        String idString = ctx.pathParam("id");
        int id = Integer.parseInt(idString);
        Dog dog = dogSelectDataAccess.getDogById(id);
        ctx.json(dog);
    }
}
