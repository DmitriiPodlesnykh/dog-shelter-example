package com.example.shelter.handler;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpHandler implements Handler
{
    private static final String EXAMPLE_TEMPLATE_REGEXP = "^(W|w)[0-9]{2,7}schools";

    @Override
    public void handle(final Context context) throws Exception
    {
        Pattern pattern = Pattern.compile(EXAMPLE_TEMPLATE_REGEXP);
        Matcher matcher = pattern.matcher("w4000000000000000000000000000000000000000000000000schools!");
        boolean matchFound = matcher.find();
        if(matchFound) {
            context.html("Match found");
        } else {
            context.html("Match not found");
        }
    }
}
