package com.example.shelter.handler;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;
import com.example.shelter.db.ShelterDataAccessInterface;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class HandlerAllDogs implements Handler {
    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context ctx) throws Exception {
        List<Dog> allDogs = shelterDataAccess.getAllDogs();
        ctx.json(allDogs);
    }
}
