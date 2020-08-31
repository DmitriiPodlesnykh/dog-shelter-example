package com.example.shelter.handler;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Comparator;
import java.util.List;

public class SortDogsByNameStatusHandler implements Handler {

    private static ShelterDataAccess shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context ctx) throws Exception {
        List<Dog> dogList = shelterDataAccess.getAllDogs();
        dogList.sort(new ComparatorByNameAndStatus());
        ctx.json(dogList);

    }

class ComparatorByNameAndStatus implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        int nameResult = o1.name.compareTo(o2.name);
        if (nameResult != 0) {
            return nameResult;
        } else if(o1.dogStatus == null && o2.dogStatus == null) {
            return 0;
        } else if (o1.dogStatus == null) {
            return 1;
        } else if (o2.dogStatus == null) {
            return -1;
        } else {
        return o1.dogStatus.compareTo(o2.dogStatus);
    }
    }
}
}
