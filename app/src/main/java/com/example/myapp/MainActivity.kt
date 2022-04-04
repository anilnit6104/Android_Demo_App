package com.example.myapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var action=supportActionBar
        if (action != null)
            action.title="IndiaMart Users Registration"

        val signin : Button = findViewById(R.id.signin)
        signin.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }


        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS",null)



        var register = findViewById<Button>(R.id.register)

        register.setOnClickListener {
            var cv = ContentValues()
            var editText1 = findViewById<EditText>(R.id.editText1)
            var editText2 = findViewById<EditText>(R.id.editText2)
            var editText3 = findViewById<EditText>(R.id.editText3)
            var editText4 = findViewById<EditText>(R.id.editText4)
            cv.put("UNAME",editText1.text.toString())
            cv.put("EMAIL",editText2.text.toString())
            cv.put("PHONE",editText3.text.toString())
            cv.put("PWD",editText4.text.toString())
            db.insert("USERS",null,cv)
            Toast.makeText(applicationContext, "Registered Successfully", Toast.LENGTH_SHORT).show()
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            editText1.requestFocus()

        }


    }
}