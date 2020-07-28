package com.example.shelter.handler;

import com.example.shelter.animal.DogStatus;
import com.example.shelter.db.dogs.select.DogSelectDataAccessImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class HandlerDogsCountOfEveryStatus implements Handler {
    private static DogSelectDataAccessImpl dogSelectDataAccess = new DogSelectDataAccessImpl();

    @Override
    public void handle(final Context ctx) throws Exception {
        int countDogsByStatusAdmitted = dogSelectDataAccess.getCountByStatus(DogStatus.ADMITTED.name());
        int countDogsByStatusNotAdmitted = dogSelectDataAccess.getCountByStatus(DogStatus.NOT_ADMITTED.name());
        int countDogsByStatusDischarged = dogSelectDataAccess.getCountByStatus(DogStatus.DISCHARGED.name());

        ctx.html("Status " + DogStatus.ADMITTED + " used " + countDogsByStatusAdmitted + " times<br>" +
                "Status " + DogStatus.NOT_ADMITTED + " used " + countDogsByStatusNotAdmitted + " times<br>" +
                "Status " + DogStatus.DISCHARGED + " used " + countDogsByStatusDischarged + " times<br>");
    }
}
