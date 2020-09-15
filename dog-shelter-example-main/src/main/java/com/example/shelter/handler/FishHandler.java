package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import com.example.shelter.animal.Fish;

public class FishHandler implements Handler
{
    @Override
    public void handle(final Context ctx) throws Exception
    {
        Fish fish = new Fish();
        fish.setName("name");
        ctx.html(fish.getName());
    }
}
