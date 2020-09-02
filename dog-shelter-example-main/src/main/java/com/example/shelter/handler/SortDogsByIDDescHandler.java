package com.example.shelter.handler;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Comparator;
import java.util.List;

public class SortDogsByIDDescHandler implements Handler {

    private static ShelterDataAccess shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context ctx) throws Exception {
        List<Dog> dogsList = shelterDataAccess.getAllDogs();
        dogsList.sort(new ComparatorDogsByIDDesc());
        ctx.json(dogsList);
    }

    class ComparatorDogsByIDDesc implements Comparator<Dog>
    {
        @Override
        public int compare(Dog o1, Dog o2) {

            if(o1.id < o2.id)
            {
                return 1;
            } else {
                if(o1.id > o2.id)
                {
                    return -1;
                }
            }
            return 0;
        }

    }
}
