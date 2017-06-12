package com.iamdilipkumar.cloudjokes.backend;

import com.jokelib.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private Joke mJoke;

    public MyBean() {
        mJoke = new Joke();
    }

    public String getJoke() {
        return mJoke.getRandomJoke();
    }
}