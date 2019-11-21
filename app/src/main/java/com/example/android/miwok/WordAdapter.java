package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    /**Resource ID for the background color for this list of words*/
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId){
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the {@link Word} object located at this position in the last
        Word currentWord = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        //Get the Miwok Translation from the currentWord object and set this text on the mMiwokTranslation
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //Find the TextView in the list_item.xml layout with ID defaultTranslation
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        //Get the Default Translation from the currentWord object and set this on the mDefaultTranslation
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = listItemView.findViewById(R.id.list_item_icon);

        if(currentWord.hasImage()){
            // Get the image resource ID from the current Word object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getmImageResourceId());

            //Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);

        } else {
            //Otherwise hide the ImageView (Set the visibility to GONE)
            iconView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById (R.id.color_text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor (getContext (), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor (color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
