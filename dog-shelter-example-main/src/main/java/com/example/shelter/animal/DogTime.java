package com.example.shelter.animal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DogTime {
    public static LocalDateTime dogAdmissionTime(){

        System.out.println("Когда собака поступила (ГГГГ-ММ-ДД)?");
        Scanner in = new Scanner(System.in);
        String dateInput = in.nextLine();
        LocalDate date = LocalDate.parse(dateInput);

        System.out.println("Во сколько (ЧЧ:ММ)?");
        Scanner inTime = new Scanner(System.in);
        String timeInput = in.nextLine();
        LocalTime time = LocalTime.parse(timeInput);

        LocalDateTime dogDate = date.atTime(time);

        return dogDate;
    }
}
