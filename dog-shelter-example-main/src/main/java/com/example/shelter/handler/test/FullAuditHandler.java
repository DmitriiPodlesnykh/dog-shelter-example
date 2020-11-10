package com.example.shelter.handler.test;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;
import com.example.shelter.db.ShelterDataAccessInterface;
import com.example.shelter.service.AuditService;

public class FullAuditHandler implements Handler
{
    private AuditService auditService = new AuditService();

    private ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context context) throws Exception
    {
        List<Dog> dogs = shelterDataAccess.getAllDogs();

        for (Dog dog: dogs)
        {
            if (!auditService.isActive(dog))
            {
                context.html("we have a problem");
            }

        }
    }
}
