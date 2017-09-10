package com.tips4life.tipsforlife.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/*
* Helper class to encapsulate any convenience methods for common db operations.
* */

public class FirebaseDatabaseHelper {

    private static final DatabaseReference mDbRef = FirebaseDatabase.getInstance().getReference();

    public static DatabaseReference getFirebaseDb(){
        return mDbRef;
    }

}
