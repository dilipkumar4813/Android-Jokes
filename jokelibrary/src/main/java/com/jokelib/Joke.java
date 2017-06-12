package com.jokelib;

import java.util.ArrayList;
import java.util.Random;

public class Joke {

    private ArrayList<String> jokes;

    public Joke() {
        jokes = new ArrayList<>();
        jokes.add("Semicolon has been the hide and seek champion since 1958");
        jokes.add("Now hiring, read the classified ad. Cemetery superintendent. The ideal candidate must be able to supervise in a fast-paced environment.");
        jokes.add("Stolen Prosthetic Arm Discovered in a Secondhand Shop");
        jokes.add("Marshall County Sheriff’s Candidate Disputes Report of Own Death");
        jokes.add("An amnesiac walks into a bar. He goes up to a beautiful blonde and says, So, do I come here often?");
        jokes.add("A horse walks into a bar. The bartender says, Hey. The horse says, You read my mind, buddy.");
        jokes.add("The past, present, and future walk into a bar. It was tense.");
        jokes.add("If you understand English, press 1. If you do not understand English, press 2.");
        jokes.add("The closest I’ve been to a diet this year is erasing food searches from my browser history.");
        jokes.add("I put so much more effort into naming my first Wi-Fi than my first child.");
        jokes.add("The cool part about naming your kid is you don’t have to add numbers to make sure the name is available.");
        jokes.add("You’re sending me something via fax? What is it, an important document from 1993?");
        jokes.add("I told the kids I never want to live in a vegetative state, dependent on some machine and fluids from a bottle. So they unplugged my computer and threw out my wine.");
        jokes.add("Before LinkedIn, I didn’t know any strangers.");
        jokes.add("I wish people were like Internet videos and you could tap them lightly to see a clock of how much longer they’re going to be talking.");
        jokes.add("I Renamed my iPod The Titanic, so when I plug it in, it says, The Titanic is syncing.");
        jokes.add("I hide photos on my computer of me petting animals at the zoo in a file named Fireworks and vacuums so my dog won’t find them.");
        jokes.add("Not Waldo, Not Waldo, Not Waldo, Not Waldo, Not Waldo, Not Waldo, Not Waldo, Not Waldo, Waldo, Not Waldo. — Where’s Waldo audiobook");
        jokes.add("Client to designer: It doesn’t really look purple. It looks more like a mixture of red and blue.");
    }

    public String getRandomJoke() {
        Random rand = new Random();
        return jokes.get(rand.nextInt(jokes.size()));
    }
}
