package com.ute.mp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.ute.mp.ui.material3.Paso01OfficialScreen
import com.ute.mp.ui.theme.MPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MPTheme {
                Paso01OfficialScreen()
            }
        }
    }
}
