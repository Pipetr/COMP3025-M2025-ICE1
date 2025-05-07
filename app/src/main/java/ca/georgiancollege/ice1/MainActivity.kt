package ca.georgiancollege.ice1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val greetingTextView =  findViewById<TextView>(R.id.greetingTextView)
        val greetingButton = findViewById<Button>(R.id.greetingButton)
        val editTextUserName = findViewById<EditText>(R.id.editTextUserName)

        editTextUserName.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                editTextUserName.text.clear()
            }
        }

        greetingButton.setOnClickListener {
            val name = editTextUserName.text.toString()
            val greeting = "hello, ${name}"
            greetingTextView.text = greeting
            editTextUserName.text.clear()
        }


    }
}