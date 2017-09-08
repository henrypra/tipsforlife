package com.tips4life.tipsforlife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDbRef = FirebaseDatabase.getInstance().getReference();
    TextView mRandomTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRandomTip = (TextView) findViewById(R.id.txt_tip);

        DatabaseReference techTip = mDbRef.child("tips").child("Technology").child("1");
        techTip.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) // which obviously it does
                {
                    Log.i("Point", "Reached");
                    mRandomTip.setText(dataSnapshot.getValue(String.class));
                } else {
                    String no_tips = "No Tips Found!";
                    mRandomTip.setText(no_tips);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
