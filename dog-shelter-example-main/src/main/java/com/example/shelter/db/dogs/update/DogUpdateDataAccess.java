package com.example.shelter.db.dogs.update;

import java.time.LocalDate;

import com.example.shelter.animal.DogStatus;

public interface DogUpdateDataAccess
{
    void replaceDogStatusById(int dogId, DogStatus status);

    /**
     * @param name имя собаки
     * @param status изменить на статус
     */
    void replaceDogStatusByName(String name, DogStatus status);

    /**
     * Изменить статус для всех собак, дата приема которых меньше указанной в параметре
     *
     * @param lastDate дата до которой статус всех собак должен быть заменен на DogStatus.DISCHARGED
     */
    void dischargeAllDogsBeforeDate(LocalDate lastDate);

}
