package com.mnp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mnp.coroutines.ui.theme.CoroutinesTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloWorld()
                }
            }
        }
    }
}

@Composable
fun HelloWorld() = runBlocking {
    launch {
        delay(1000L)
        Log.i("TAG", "World!")
    }
    Log.i("TAG", "Hello,")
    delay(2000L)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesTheme {
        HelloWorld()
    }
}