package com.example.shelter;

import com.example.shelter.animal.DogStatus;
import com.example.shelter.db.dogs.select.DogSelectDataAccessImpl;
import com.example.shelter.handler.HandlerAllDogs;
import com.example.shelter.handler.HandlerDogsListByStatus;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;


import java.util.Arrays;
import java.util.Set;


import com.example.shelter.db.*;
import com.example.shelter.db.dogs.update.DogUpdateDataAccess;
import com.example.shelter.db.dogs.update.DogUpdateDataAccessImplByNL;
import com.example.shelter.handler.HandlerCountDog;
import com.example.shelter.handler.HandlerDogInfoById;

public class Main {

    private static DogInsertDataAccessInterface dogInsertDataAccess = new DogInsertDataAccess();

    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    private static DogUpdateDataAccess dogUpdateDataAccess = new DogUpdateDataAccessImplByNL();
    private static DogSelectDataAccessImpl dogSelectData = new DogSelectDataAccessImpl();

    public static void main(String... args) {

        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World 2 "));
        app.get("/example", new Handler() {
            @Override
            public void handle(final Context ctx) throws Exception {
                ctx.result("This is example");
            }
        });

        Handler handlerCountDogs = new HandlerCountDog();
        app.get("/count", handlerCountDogs);

        app.get("/dogs", new Handler() {
            @Override
            public void handle(final Context ctx) throws Exception {
                Set<String> names = shelterDataAccess.getUniqueDogNames();

                ctx.json(names);
            }
        });

        app.get("/html2", ctx -> ctx.html("<h1>Hello <br>World 2</h1>"));

        Handler handlerAllDogs = new HandlerAllDogs();
        app.get("/dogs/full", handlerAllDogs);
        //app.get("/dogs/full", ctx -> ctx.json(shelterDataAccess.getAllDogs()));
        app.get("/statuses", ctx -> ctx.html("All possible statuses: " + Arrays.toString(DogStatus.values())));

        Handler handlerDogInfo = new HandlerDogInfoById();
        app.get("/dogs/:id", handlerDogInfo);

        Handler handlerDogInfoByStatus = new HandlerDogsListByStatus();
        app.get("/statuses/:discharged", handlerDogInfoByStatus);

        app.get("/statuses/statistics/", ctx -> ctx.html("Status " + DogStatus.ADMITTED + " used " + dogSelectData.getCountByStatus(DogStatus.ADMITTED.name()) + " times"));
    }

}
