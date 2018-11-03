package com.code.knab.godseye

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.Writer
import java.nio.file.Files.createFile

class SignUpActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val loginEditText = findViewById<EditText>(R.id.login_editText)
        val passwordEditText = findViewById<EditText>(R.id.password_editText)
        val repeatPasswordEditText = findViewById<EditText>(R.id.repeat_password_editText)


        confirm.setOnClickListener {

            if (passwordEditText.text.toString().equals(repeatPasswordEditText.text.toString())) {
                createJsonData(loginEditText.text.toString(), passwordEditText.text.toString())

            } else {
                Toast.makeText(this, "Podane hasła są różne", Toast.LENGTH_LONG).show()
            }


        }

    }

    private fun createJsonData(login: String, password: String) {
        var json = JSONObject()
        val userData = UserData(login, password, "", "")
        json.put("account", userData)
        saveJson(json.toString())
    }

    private fun saveJson(jsonString: String) {
        val output: Writer
        val fileName = "UsersData.json"

        val file = File(this.filesDir, fileName)
        this.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(jsonString.toByteArray())
        }
    }
}



