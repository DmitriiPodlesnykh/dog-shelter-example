package com.example.shelter;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Arrays;
import java.util.Set;

import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;
import com.example.shelter.db.DogInsertDataAccess;
import com.example.shelter.db.DogInsertDataAccessInterface;
import com.example.shelter.db.ShelterDataAccess;
import com.example.shelter.db.ShelterDataAccessInterface;
import com.example.shelter.db.dogs.select.DogSelectDataAccessImpl;
import com.example.shelter.db.dogs.update.DogUpdateDataAccess;
import com.example.shelter.db.dogs.update.DogUpdateDataAccessImplByNL;
import com.example.shelter.handler.HandlerAllDogs;
import com.example.shelter.handler.HandlerCountDog;
import com.example.shelter.handler.HandlerDogInfoById;
import com.example.shelter.handler.HandlerDogsCountOfEveryStatus;
import com.example.shelter.handler.HandlerDogsListByStatus;

public class Main {

    private static DogInsertDataAccessInterface dogInsertDataAccess = new DogInsertDataAccess();

    private static ShelterDataAccessInterface shelterDataAccess = new ShelterDataAccess();

    private static DogUpdateDataAccess dogUpdateDataAccess = new DogUpdateDataAccessImplByNL();
    private static DogSelectDataAccessImpl dogSelectData = new DogSelectDataAccessImpl();

    public static void main(String... args) {
        tryInterfaces(null);
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
        app.get("/statuses/:dogStatus", handlerDogInfoByStatus);

        Handler handlerDogsCountByStatus = new HandlerDogsCountOfEveryStatus();
        app.get("/count_by_statuses/statistics/", handlerDogsCountByStatus);


    }

    private static void tryInterfaces(Javalin app)
    {
        Dog dog = new Dog();
        dog.addDescription("descr1");

//        int size2 = dog.getDescription().size();
//        System.out.println("our size = " + size2);

        //DogDescriptionChanger.addDescription(dog, "fds");

        dog.getDescription();

        int size = dog.getDescription().size();
        System.out.println("our size = " + size);
    }

}
