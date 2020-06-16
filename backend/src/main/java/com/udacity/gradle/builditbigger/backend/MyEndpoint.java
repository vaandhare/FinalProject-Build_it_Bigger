package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.vaibhavandhare.jokeslib.JokesClass;

import java.util.Random;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJokes")
    public MyBean getJokes() {
        JokesClass jokesClass = new JokesClass();
        MyBean response = new MyBean();
        response.setData(jokesClass.getJokes().get(new Random().nextInt(jokesClass.getJokes().size())));

        return response;
    }

}
