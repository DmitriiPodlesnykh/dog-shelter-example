package com.example.shelter;

import java.util.Scanner;
import com.example.shelter.db.DogInsertDataAccess;
import com.example.shelter.db.ShelterDataAccess;


public class Main
{
    public static void main(String... args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Dog name: ");
        String string = in.nextLine();
        while (!"exit".equals(string))
        {
            System.out.println("Dog name: ");
            DogInsertDataAccess.addNewDog(string);
            string = in.nextLine();
        }

        System.out.println("Dog table size = "  + ShelterDataAccess.getCountDogs());
    }


}
