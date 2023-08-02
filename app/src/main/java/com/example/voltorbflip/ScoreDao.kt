package com.example.voltorbflip

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {
    @Query("SELECT * FROM high_scores ORDER BY score DESC")
    fun getSortedScores(): Flow<List<Score>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score: Score)

    @Query("DELETE FROM high_scores")
    suspend fun deleteAll()
}