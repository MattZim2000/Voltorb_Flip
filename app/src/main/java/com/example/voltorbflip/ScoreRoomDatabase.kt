package com.example.voltorbflip

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Score::class), version = 1, exportSchema = false)
abstract class ScoreRoomDatabase : RoomDatabase() {

    abstract fun scoreDao(): ScoreDao

    private class ScoreDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var scoreDao = database.scoreDao()
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ScoreRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ScoreRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScoreRoomDatabase::class.java,
                    "word_database"
                )
                    .addCallback(ScoreDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

