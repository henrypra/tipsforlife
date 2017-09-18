package com.tips4life.tipsforlife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

import static com.tips4life.tipsforlife.utils.FirebaseDatabaseHelper.getFirebaseDb;

public class MainActivity extends AppCompatActivity {

    private TextView mRandomTip;

    // TODO: Implement an enum or something for categories.
    public static final String CATEGORY_TECHNOLOGY = "Technology";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandomTip = (TextView) findViewById(R.id.txt_tip);

        final DatabaseReference tips = getFirebaseDb().child("tips").child(CATEGORY_TECHNOLOGY);
        tips.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.hasChildren()) // which obviously it does
                {
                    // Generate random index bounded by total children in category.
                    Long childrenCount = dataSnapshot.getChildrenCount();
                    String index = randomIndex(childrenCount.intValue());
                    String tip = dataSnapshot.child(index).getValue(String.class);
                    mRandomTip.setText(tip);
                    Log.d("Fetching tip: ", tip);
                } else {
                    mRandomTip.setText(R.string.no_tips_available);
                    Log.e("Database empty: ", "No tips available!");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private String randomIndex(int count) {

        // Generates a random number bounded by count of children in tips category.
        // Need to cast and return as String to be passed as a valid path in Firebase.
        Random rand = new Random();
        Integer randomNumber = rand.nextInt(count + 1);

        if (randomNumber == 0) {
            randomNumber = 1;
        }

        return randomNumber.toString();
    }

}
