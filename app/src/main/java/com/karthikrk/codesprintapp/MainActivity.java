package com.karthikrk.codesprintapp;

import java.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected String GuessWord()
    {
        String userEntered = "abcreviation";
        String smallest = "anbreviation";
        String smallest1 = "accreviation";
        String largest = "anthropologist";
        String[] wordsList = {smallest, smallest1, largest};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(26, Collections.reverseOrder());

        pq.add(12);
        pq.add(14);


        HashMap<Integer, ArrayList<String>> wordMap = new HashMap<>();
        for(String word: wordsList)
        {
            if(!wordMap.containsKey(word.length()))
            {
                ArrayList<String> sameLengthWords = new ArrayList<>();
                sameLengthWords.add(word);
                wordMap.put(word.length(), sameLengthWords);

            }
            else
            {
                wordMap.get(word.length()).add(word);

            }

        }
        String chosen = wordMap.get(pq.peek()).get(0);
        return chosen;
    }
}
