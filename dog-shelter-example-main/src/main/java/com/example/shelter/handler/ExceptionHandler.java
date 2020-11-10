package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import org.jetbrains.annotations.NotNull;

import com.example.shelter.db.ShelterDataAccess;

public class ExceptionHandler implements Handler
{
    private ShelterDataAccess shelterDataAccess = new ShelterDataAccess();

    @Override
    public void handle(@NotNull final Context context) throws Exception
    {
        //shelterDataAccess.getDogNameById(1);

        String bhuhu = "dsdsdsds";
        bhuhu.toLowerCase();


        try
        {
            String a = "";

            int [] array = {1,2};
            int result = array[10];

            String b = null;
            b.toLowerCase();
        }
//        catch (NullPointerException e)
//        {
//            System.out.println("NullPointerException is here!");
//        }
//        catch (IndexOutOfBoundsException e)
//        {
//            System.out.println("IndexOutOfBoundsException is here!");
//        }
        catch (Exception e)
        {

            System.out.println("Exception is here!");
        }

        System.out.println("23 HI!!!!!!!!!!!!!!!");

        String a = null;
        try
        {
           a.toLowerCase();
        }
        catch (NullPointerException e)
        {
            System.out.println("2");
        }
        catch (RuntimeException e)
        {
            System.out.println("1/2");
        }
        catch (Exception e)
        {
            System.out.println("1");
        }

    }
}
