package com.example.firebaseexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

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

        val book = mapOf("Title" to "WIl", "Year" to 2030)

        val db = Firebase.firestore

        db.collection("books").add(book)

        val author = findViewById<EditText>(R.id.author)
        val title1 = findViewById<EditText>(R.id.title1)
        val year = findViewById<EditText>(R.id.year)
        val results =findViewById<TextView>(R.id.books)
        val btnAdd = findViewById< Button>(R.id.add)

      btnAdd.setOnClickListener {
          val book = Book (author.text.toString(), title1.text.toString(), 2023)
          db.collection("books").add(book)
      }


     db.collection("books").get().addOnSuccessListener { data -> Log.v("OPSC6312", data.documents.toString()) }
    }
}