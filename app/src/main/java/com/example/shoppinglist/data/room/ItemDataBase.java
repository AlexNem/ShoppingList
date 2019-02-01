package com.example.shoppinglist.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class ItemDataBase extends RoomDatabase {
    public abstract ItemDao itemDao();
}
