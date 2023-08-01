package com.example.voltorbflip

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "high_scores")
class Score(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="score") val score: Int
)
