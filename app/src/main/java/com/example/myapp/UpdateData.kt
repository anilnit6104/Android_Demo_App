package com.example.myapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS",null)
        var update = findViewById<Button>(R.id.update)
        update.setOnClickListener {
            var cv = ContentValues()
            var editText1 = findViewById<EditText>(R.id.editText1)
            var editText2 = findViewById<EditText>(R.id.editText2)
            var editText3 = findViewById<EditText>(R.id.editText3)
            var editText4 = findViewById<EditText>(R.id.editText4)

            var args1 = listOf<String>(editText2.text.toString()).toTypedArray()

            cv.put("UNAME",editText1.text.toString())
            cv.put("EMAIL",editText2.text.toString())
            cv.put("PHONE",editText3.text.toString())
            cv.put("PWD",editText4.text.toString())
            db.update("USERS",cv,"EMAIL=?", args1)
            Toast.makeText(applicationContext, "Updated Successfully", Toast.LENGTH_SHORT).show()
            val intent12 = Intent(this,MainActivity::class.java)
            startActivity(intent12)

            var email = findViewById<EditText>(R.id.email)
            var password = findViewById<EditText>(R.id.password)
            var args = listOf<String>(email.text.toString(), password.text.toString()).toTypedArray()
            var rs = db.rawQuery("SELECT * FROM USERS WHERE EMAIL = ? AND PWD = ?", args)


        }
    }
}