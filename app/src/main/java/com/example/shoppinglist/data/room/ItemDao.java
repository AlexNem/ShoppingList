package com.example.shoppinglist.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM item")
    List<Item> getAll();

    @Query("SELECT * FROM item WHERE id = :id")
    Item getById(long id);

    @Insert
    void insert(Item employee);

    @Update
    void update(Item employee);

    @Delete
    void delete(Item employee);

}
