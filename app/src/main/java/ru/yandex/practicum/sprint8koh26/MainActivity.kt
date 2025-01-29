package ru.yandex.practicum.sprint8koh26

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children

class MainActivity : AppCompatActivity() {


    private var lastStopTimestamp: Long = 0
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resources.displayMetrics.widthPixels

        val main = findViewById<LinearLayout>(R.id.main)

        fun ViewGroup.changeColor() {
            children.forEach { view ->
                if (view is TextView) {
                    view.setTextColor(Color.MAGENTA)
                } else if (view is ViewGroup) {
                    view.changeColor()
                }
            }
        }
        main.changeColor()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val counterView = findViewById<TextView>(R.id.counter)

        findViewById<LinearLayout>(R.id.item_share).setOnClickListener {
            // todo
        }
        findViewById<TextView>(R.id.item_share_2).setOnClickListener {
            // todo
            counter++
            counterView.text = counter.toString()
        }
        Log.d("SPRINT_8", "onCreate $this")
    }


    override fun onStart() {
        super.onStart()
        Log.d("SPRINT_8", "onStart $this")
        if (System.currentTimeMillis() > lastStopTimestamp + 10_000){
            // show pin code
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("SPRINT_8", "onResume $this")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SPRINT_8", "onPause $this")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }

    override fun onStop() {
        super.onStop()
        Log.d("SPRINT_8", "onStop $this")
        lastStopTimestamp = System.currentTimeMillis()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SPRINT_8", "onDestroy $this")
    }
}