package com.example.shelter.service;

import org.junit.Assert;
import org.junit.Test;

import com.example.shelter.animal.Animal;
import com.example.shelter.animal.Fish;

public class AuditServiceTest
{
    private AuditService auditService = new AuditService();

    @Test
    public void testIsActive_null_returnFalse()
    {

        boolean result = auditService.isActive(null);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsActive_newFish_returnFalse()
    {
        Animal animal = new Fish();

        boolean result = auditService.isActive(animal);

        Assert.assertFalse(result);
    }


}
