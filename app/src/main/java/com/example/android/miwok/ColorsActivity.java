package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "wetetti", R.drawable.color_red));
        words.add(new Word("green", "chokokki",  R.drawable.color_green));
        words.add(new Word("brown", "takaakki",  R.drawable.color_brown));
        words.add(new Word("gray", "topoppi",  R.drawable.color_gray));
        words.add(new Word("black", "kululli",  R.drawable.color_black));
        words.add(new Word("white", "kelelli",  R.drawable.color_white));
        words.add(new Word("dusty yellow", "topiisae",  R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiitae",  R.drawable.color_mustard_yellow));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
