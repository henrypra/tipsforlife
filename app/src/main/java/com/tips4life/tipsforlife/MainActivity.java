package com.tips4life.tipsforlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

	DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tip = (TextView) findViewById(R.id.testTip);

		DatabaseReference techTip = ref.child("tips").child("Technology").child("1");
		techTip.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				if(dataSnapshot.exists()) // which obviously it does
				{
					Log.i("Point", "Reached");
					tip.setText(dataSnapshot.getValue(String.class));
				} else {
					String no_tips = "No Tips Found!";
					tip.setText(no_tips);
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {}
		});
	}
}
