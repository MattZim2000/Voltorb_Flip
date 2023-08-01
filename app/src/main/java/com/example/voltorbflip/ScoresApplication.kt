package com.example.voltorbflip

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ScoresApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { ScoreRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ScoreRepository(database.scoreDao()) }
    }