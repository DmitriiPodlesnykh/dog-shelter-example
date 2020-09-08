package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.shelter.animal.Dog;

public class ReflectionExampleHandler implements Handler
{
    @Override
    public void handle(final Context ctx) throws Exception
    {
        Dog dog = new Dog();

        Class classDog = dog.getClass();

        StringBuilder stringBuilder = new StringBuilder("<h1>Info about");
        stringBuilder.append(classDog.toString());
        stringBuilder.append("</h1>");
        stringBuilder.append(getFieldsInfo(classDog));
        stringBuilder.append(getMethodsInfo(classDog));
        ctx.html(stringBuilder.toString());
    }

    private String getFieldsInfo(Class aClass)
    {
        StringBuilder stringBuilder = new StringBuilder("<h2>Fields:</h2>");

        Field[] dogFields = aClass.getFields();
        for (Field field : dogFields)
        {
            stringBuilder.append(field.getName());
            stringBuilder.append("</br>");
        }

        return stringBuilder.toString();
    }

    private String getMethodsInfo(Class aClass)
    {
        StringBuilder stringBuilder = new StringBuilder("<h2>Methods:</h2>");

        Method[] dogMethods = aClass.getMethods();

        for (Method method : dogMethods)
        {
            stringBuilder.append(method.getName());
            stringBuilder.append("</br>");
        }

        return stringBuilder.toString();
    }
}
