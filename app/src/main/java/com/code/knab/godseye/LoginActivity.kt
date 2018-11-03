package com.code.knab.godseye

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Toast.makeText(this, "tworzę obiekty", Toast.LENGTH_SHORT).show()

        val example = UserData("admin","admin","","") //*sample login data
        val loginEditText = findViewById<EditText>(R.id.login_editText)
        val passwordEditText = findViewById<EditText>(R.id.password_editText)


        log_in.setOnClickListener {
            // Handler code here.

            val directory = this.filesDir
            val file = File(directory, "UsersData.json")
            val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }

            try{
                var json = JSONObject()
            }

            if(loginEditText.text.toString().equals(example.login) && passwordEditText.text.toString().equals(example.password))
            {
                val intent = Intent(this, KlasaRobocza::class.java) //*successful log in will get us to an empty class and empty layout, maybe later we will add something :)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "nie działa", Toast.LENGTH_SHORT).show()
            }

        }

        sign_up.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}
