package com.example.set

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var seedMode : Boolean = false
    private var timedMode : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seedToggle = findViewById<Switch>(R.id.seed_mode)
        val seedModeValue : TextView = findViewById(R.id.seed_mode_value)
        seedToggle.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                seedMode = true
                seedModeValue.text = getString(R.string.on)
            }
            else{
                seedMode = false
                seedModeValue.text = getString(R.string.off)
            }
        }

        val timedModeValue : TextView = findViewById(R.id.timed_mode_value)
        val timedToggle = findViewById<Switch>(R.id.timed_mode)
        timedToggle.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                timedMode = true
                timedModeValue.text = getString(R.string.on)
            }
            else{
                timedMode = false
                timedModeValue.text = getString(R.string.off)
            }
        }

        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener{ startGame() }
    }

    private fun startGame(){
        val intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("SeedMode", seedMode)
        intent.putExtra("TimedMode", timedMode)
        startActivity(intent)
    }
}
