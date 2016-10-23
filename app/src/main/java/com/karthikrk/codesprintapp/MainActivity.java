package com.karthikrk.codesprintapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tw1,tw2,tw3,tw4;
    private Button btn1, btn2;
    private TrieNode tNode;
    private Random rand = new Random();
    private static final String COMPUTER_TURN="Computer is playing";
    private static final String USER_TURN="User is playing";
    private static final String USER_WINS="User won!!!";
    private static final String COMPUTER_WINS="Computer won!!!";
    private boolean userPlays=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager assetManager = getAssets();
        try{
            InputStream iStream = assetManager.open("words.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            tNode = new TrieNode();
            String line = null;
            while((line=br.readLine())!=null){
                String word = line.trim();
                tNode.add(word);
            }
        }
        catch(IOException e){
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }
        onStart(null);
    }


    public boolean onStart(View view){
        int alpha = rand.nextInt(26);
        String c = Character.toString((char) (97+alpha));
        tw1 = (TextView) findViewById(R.id.textView);
        tw2 = (TextView) findViewById(R.id.textView2);
        tw3 = (TextView) findViewById(R.id.textView3);
        tw1.setText(c);
        tw2.setText(c);
        tw3.setText(USER_TURN);
        userTurn();
        return true;
    }

    public void userTurn(){
        tw4 = (TextView) findViewById(R.id.textView4);
        int turn=1;
        if(turn==1){
            tw4.setText("Please enter one character");
            turn++;
        }
        else{
            tw4.setText("Please enter the word you thought of");
        }
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
