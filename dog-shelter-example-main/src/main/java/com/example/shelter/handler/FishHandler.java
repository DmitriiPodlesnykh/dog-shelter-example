package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import com.example.shelter.animal.Fish2;
import com.example.shelter.animal.Resident;

public class FishHandler implements Handler
{
    @Override
    public void handle(final Context ctx) throws Exception
    {
        Resident resident = new Resident()
        {
            @Override
            public void eat()
            {

            }
        };


        ctx.html("<h1>Fishfish</h1>");



        Fish2 fish2 = new Fish2()
        {
            @Override
            public void doNothing()
            {
                //do it!;
            }
        };

        Fish2.FishNonStaticInner fishNonStaticInner= fish2.new FishNonStaticInner();


    }


    public void check(Fish2 fish2)
    {

    }
}
