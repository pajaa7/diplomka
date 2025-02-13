package com.example.diplomka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dbHelper = UserDatabaseHelper(this)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.buttonStart)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isNotBlank() && password.isNotBlank()) {
                val isInserted = dbHelper.insertUser(email, password)
                if (isInserted) {
                    Toast.makeText(this, "Účet vytvořen!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Chyba při vytváření účtu", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Vyplňte všechny údaje!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
