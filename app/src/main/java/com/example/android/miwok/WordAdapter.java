package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class WordAdapter extends ArrayAdapter<Word> {

    //Resource ID for background color for the various activities.
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());


        // Find the ImageView in the list_item.xml layout with the ID "item_icon_imageview".
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // Get the image resource ID from the current Word object and set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());

            //Make sure the view is visible.
            iconView.setVisibility(View.VISIBLE);

        } else {
            //Otherwise hide the image (set visibility to GONE).
            iconView.setVisibility(View.GONE);
        }

        // Set the colour themes for the various list items.
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID links to.
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background colour of the text container.
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

