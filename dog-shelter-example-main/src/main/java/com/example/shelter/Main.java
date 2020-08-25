package com.example.shelter;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import com.example.shelter.animal.Dog;
import com.example.shelter.animal.DogStatus;
import com.example.shelter.animal.Resident;
import com.example.shelter.db.DogInsertDataAccess;
import com.example.shelter.db.DogInsertDataAccessInterface;
import com.example.shelter.db.ShelterDataAccess;
import com.example.shelter.db.ShelterDataAccessInterface;
import com.example.shelter.db.dogs.select.DogSelectDataAccessImpl;
import com.example.shelter.db.dogs.update.DogUpdateDataAccess;
import com.example.shelter.db.dogs.update.DogUpdateDataAccessImplByNL;
import com.example.shelter.handler.DogComparatorExampleHandler;
import com.example.shelter.handler.FishHandler;
import com.example.shelter.handler.HandlerAllDogs;
import com.example.shelter.handler.HandlerCountDog;
import com.example.shelter.handler.HandlerDocInfo;
import com.example.shelter.handler.HandlerDogInfoById;
import com.example.shelter.handler.HandlerDogsCountOfEveryStatus;
import com.example.shelter.handler.HandlerDogsListByStatus;
import com.example.shelter.staff.Doc;
import com.example.shelter.staff.Person;
import com.example.shelter.staff.Sponsor;
import com.example.shelter.staff.Staff;

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
        app.get("/statuses/:dogStatus", handlerDogInfoByStatus);

        Handler handlerDogsCountByStatus = new HandlerDogsCountOfEveryStatus();
        app.get("/count_by_statuses/statistics/", handlerDogsCountByStatus);

        Handler docInfoHandler = new HandlerDocInfo();
        app.get("/doc", docInfoHandler);

        Handler fishHandler = new FishHandler();
        app.get("/fish", fishHandler);

        Handler comparatorHandler = new DogComparatorExampleHandler();
        app.get("/dog/sort", comparatorHandler);
    }

    private static void helpEveryOne()
    {
        //1
        ArrayList<Person> staffList = new ArrayList<>();

        Person staff1 = new Staff("volunteer");
        Person staff2 = new Staff("volunteer");
        Person staff3 = new Staff("volunteer");
        Person staff4 = new Sponsor();
        Person staff5 = new Sponsor();

        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);
        staffList.add(staff4);
        staffList.add(staff5);
        staffList.add(new Staff("director"));
        staffList.add(new Doc());

//        //2
//        for (Staff staff : staffList)
//        {
//            if (staff.category.equals("volunteer"))
//            {
//                staff.action = "помочь";
//            } else if(staff.category.equals("doc"))
//            {
//                staff.action = "лечить";
//            } else if (staff.category.equals("director"))
//            {
//                staff.action = "manage";
//            } else if (staff.category.equals("sponsor"))
//            {
//                staff.action = "дать денег";
//            }
//        }


        //3
        for (Person staff : staffList)
        {
            System.out.println(staff.help());
            System.out.println(staff.getSalary());
        }
    }

    private static void tryInterfaces(Javalin app)
    {
        Dog dog = new Dog();

        dog.sayHello();

        Resident resident = dog;
        System.out.println(resident.name);

        dog.addDescription("descr1");

        dog.getDescription();

        int size = dog.getDescription().size();
        System.out.println("our size = " + size);
    }

}
