package com.vaibhavandhare.jokeslib;

import java.util.ArrayList;
import java.util.List;

public class JokesClass {
    public List<String> getJokes() {
        List<String> joke = new ArrayList<>();
        //Jokes are taken from https://www.rd.com/jokes/one-liners/
        joke.add("I ate a clock yesterday, it was very time-consuming/");
        joke.add("A fire hydrant has H-2-O on the inside and K-9-P on the outside.");
        joke.add("Did you hear about the semi-colon that broke the law? He was given two consecutive sentences.");
        joke.add("Q. What's the difference between ignorance and apathy? A. I don’t know and I don’t care.");
        joke.add("I own the world's worst thesaurus. Not only is it awful, it's awful.");
        joke.add("So what if I don't know what \"Armageddon\" means? It's not the end of the world.");
        joke.add("Don't you hate it when someone answers their own questions? I do.");
        joke.add("250 lbs here on Earth is 94.5 lbs on Mercury. No, I'm not fat. I’m just not on the right planet.");
        return joke;
    }
}

