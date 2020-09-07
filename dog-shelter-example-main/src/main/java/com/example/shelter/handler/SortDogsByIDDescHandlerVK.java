package com.example.shelter.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import java.security.PrivateKey;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;


public class SortDogsByIDDescHandlerVK implements io.javalin.http.Handler {
    private static ShelterDataAccess shelterDataAccess= new ShelterDataAccess();
    @Override
    public void handle(final Context ctx) throws Exception {
        List<Dog> dogsList = shelterDataAccess.getAllDogs();
        dogsList.sort(new SortDogsByIDDescHandlerVK.ComparatorDogsByIDDesc());

        String headerString = "<table cellspacing=\"2\" border=\"1\" cellpadding=\"5\" style=\"width:100%\">"
                + "  <tr>"
                + "    <th>id</th>"
                + "    <th>name</th> "
                + "    <th>status</th>"
                + "  </tr>";
        StringBuilder result = new StringBuilder(headerString);
        for (Dog dog : dogsList)
        {
            result.append("<tr>");

            result.append("<td>").append(dog.id).append("</td>");

            result.append("<td>").append(dog.name).append("</td>");

            result.append("<td>").append(dog.dogStatus).append("</td>");

            result.append("</tr>");
        }
        ctx.json(result.toString());


    }
    class ComparatorDogsByIDDesc  implements Comparator<Dog>{

        @Override
        public int compare(Dog o1, Dog o2) {
            if (o1.id  > o2.id){
                return -1;
            }
            else {
                if (o1.id < o2.id){
                    return 1;
                }
            }
            return 0;
        }
    }
}
