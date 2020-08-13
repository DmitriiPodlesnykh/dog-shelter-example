package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import com.example.shelter.staff.Doc;

public class HandlerDocInfo implements Handler
{
    @Override
    public void handle(final Context ctx) throws Exception
    {

        int a = Doc.AVERAGE_SALARY;

        Doc doc4 = new Doc();

        doc4.setFirstName("rffrfrfrfrf");
        Doc.setSalary(100);
        doc4.setSalary(121211);

        String result = "<h1>" + doc4.firstName + "</h1></br>"
                + "<h2>doc4 salary = " + doc4.salary + "</h2>";
        ctx.html(result);

    }
}
