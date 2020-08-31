package com.example.shelter.handler;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Comparator;
import java.util.List;

public class SortDogsByNameAscHandler implements Handler {

    private static ShelterDataAccess shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context ctx) throws Exception {
        List<Dog> dogList = shelterDataAccess.getAllDogs();
        dogList.sort(new ComparatorByNameAsc());
        ctx.json(dogList);
    }

    class ComparatorByNameAsc implements Comparator<Dog>
    {
        @Override
        public int compare(Dog o1, Dog o2)
        {
             return o1.name.compareTo(o2.name);
        }
    }
}
