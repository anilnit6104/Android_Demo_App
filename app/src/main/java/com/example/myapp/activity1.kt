package com.example.myapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_1.*

class activity1 : AppCompatActivity() {

    companion object{
    const val NAME = "NAME"
    const val PHONE = "PHONE"
    const val EMAIL = "EMAIL"
    }

    private lateinit var upload:Button

    private val STORAGE_PERMISSION_CODE=123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val fillNames = intent.getStringExtra(NAME)
        val fillPhones = intent.getStringExtra(PHONE)
        val fillEmails = intent.getStringExtra(EMAIL)

        name.text = fillNames
        phone.text = fillPhones
        email.text = fillEmails

        var action=supportActionBar
        if (action != null)
            action.title="User Profile"


        val contacts : FloatingActionButton = findViewById(R.id.contacts)
        contacts.setOnClickListener {
            val intent1 = Intent(this,RecyclerActivity::class.java)
            startActivity(intent1)
        }

        val edit : FloatingActionButton = findViewById(R.id.edit)
        edit.setOnClickListener {
            val intent1 = Intent(this,UpdateData::class.java)
            startActivity(intent1)
        }


        var upload = findViewById<Button>(R.id.upload)
        upload.setOnClickListener {
            checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE)
        }

        val logout : Button = findViewById(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
    private fun checkPermission(permission: String, requestCode: Int){
        if (ContextCompat.checkSelfPermission(this@activity1,permission)== PackageManager.PERMISSION_DENIED){

            //Takes Permission
            ActivityCompat.requestPermissions(this@activity1, arrayOf(permission),requestCode)

        }else{
            Toast.makeText(this@activity1,"permission granted already", Toast.LENGTH_LONG).show()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==STORAGE_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_DENIED){
                upload.text = "Permission Granted"
                Toast.makeText(this@activity1, "Storage Request Denied", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@activity1,"Storage Request Granted", Toast.LENGTH_SHORT).show()
            }
        }
    }

}