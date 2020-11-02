package com.example.modelpaper1.Database;

import android.provider.BaseColumns;

public class UserProfile {

    private  UserProfile() {

    }

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "Userinfo";
        public static final String COLUMN_1 = "Username";
        public static final String COLUMN_2 = "Date Of birth";
        public static final String COLUMN_3 = "Password";
        public static final String COLUMN_4 = "Gender";
    }
}