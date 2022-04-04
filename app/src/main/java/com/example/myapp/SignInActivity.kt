package com.example.myapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var action = supportActionBar
        if (action != null)
            action.title = "IndiaMart Users Login"

        val regback: Button = findViewById(R.id.regback)
        regback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase

        //setting the login button from signinactivity.kt

        var login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            var email = findViewById<EditText>(R.id.email)
            var password = findViewById<EditText>(R.id.password)
            var args = listOf(email.text.toString(), password.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM USERS WHERE EMAIL = ? AND PWD = ?", args)
            //var bundle: Bundle = Bundle()

            if (rs.moveToNext()) {

                val fillName = rs.getString(1).toString()
                val fillPhone = rs.getString(2).toString()
                val fillEmail = rs.getString(3).toString()

                Toast.makeText(applicationContext, rs.getString(2), Toast.LENGTH_LONG).show()
                val intent = Intent(this, activity1::class.java)
                intent.putExtra(activity1.NAME,fillName)
                intent.putExtra(activity1.PHONE,fillPhone)
                intent.putExtra(activity1.EMAIL,fillEmail)
                startActivity(intent)

            } else
                Toast.makeText(applicationContext, "Invalid Credentials", Toast.LENGTH_LONG).show()
        }
    }
}