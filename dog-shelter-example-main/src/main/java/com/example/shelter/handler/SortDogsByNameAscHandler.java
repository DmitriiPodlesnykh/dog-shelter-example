package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Comparator;
import java.util.List;

import com.example.shelter.animal.Dog;
import com.example.shelter.db.ShelterDataAccess;

public class SortDogsByNameAscHandler implements Handler
{

    private static ShelterDataAccess shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(final Context ctx) throws Exception
    {
        List<Dog> dogList = shelterDataAccess.getAllDogs();
        dogList.sort(new ComparatorByNameAsc());

        String headerString = "<table cellspacing=\"2\" border=\"1\" cellpadding=\"5\" style=\"width:100%\">"
                + "  <tr>"
                + "    <th>id</th>"
                + "    <th>name</th> "
                + "    <th>status</th>"
                + "  </tr>";
        StringBuilder result = new StringBuilder(headerString);
        for (Dog dog : dogList)
        {
            result.append("<tr>");

            result.append("<td>").append(dog.id).append("</td>");

            result.append("<td>");
            result.append(dog.name);
            result.append("</td>");

            result.append("<td>");
            result.append(dog.dogStatus);
            result.append("</td>");

            result.append("</tr>");
        }

        result.append("</table>");
        ctx.html(result.toString());
    }

    class ComparatorByNameAsc implements Comparator<Dog>
    {
        @Override
        public int compare(Dog o1, Dog o2)
        {
            //return o1.name.compareToIgnoreCase(o2.name);


            if (o1.name.equalsIgnoreCase(o2.name))
            {
                return o1.dogStatus.compareTo(o2.dogStatus);
            } else
            {
                return o1.name.compareToIgnoreCase(o2.name);
            }
        }
    }
}
