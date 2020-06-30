package com.example.shelter.animal;

import java.util.Scanner;

public class CurrentDogStatus {

    public static DogStatus getStatus() {
        System.out.println("Выберите статус собаки: Принята(1), Не принята (2), Выписана (3)?");
        Scanner in = new Scanner(System.in);
        String status = in.nextLine();
        if("2".equals(status)){
            return DogStatus.NOT_ADMITTED;
        }
        else if("3".equals(status)){
            return DogStatus.DISCHARGED;
        }
        else {
            return DogStatus.ADMITTED;
        }

    }
}

