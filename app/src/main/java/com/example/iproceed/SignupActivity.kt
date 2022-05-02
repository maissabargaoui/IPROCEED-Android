package com.example.iproceed

import Models.User
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.ApiClient

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()


        val username = findViewById<EditText>(R.id.username_et)
        val email = findViewById<EditText>(R.id.email_et)
        val pwd = findViewById<EditText>(R.id.pwd_et)

        val inscriptionBtn = findViewById<Button>(R.id.signup)

        val loginBtn = this@SignupActivity.findViewById<Button>(R.id.login)

        loginBtn.setOnClickListener {
            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        inscriptionBtn.setOnClickListener{

            if(username.text.isNullOrBlank())
            {
                username.error = getString(R.string.champ_vide)

                return@setOnClickListener
            }
            if(email.text.isNullOrBlank())
            {
                email.error = getString(R.string.champ_vide)

                return@setOnClickListener
            }
            if(pwd.text.isNullOrBlank())
            {
                pwd.error = getString(R.string.champ_vide)

                return@setOnClickListener
            }
            ApiClient.apiService.register(User("",username.text.toString(), email.text.toString(),"", pwd.text.toString(),"","Avatar.png")).enqueue(
                object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                        t.printStackTrace()

                    }
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.isSuccessful && response.body() != null) {
                            val content = response.body()

                            if(response.code() == 201)
                            {
                                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }

                            if(response.code() == 403)
                            {
                                Toast.makeText(
                                    this@SignupActivity,
                                    "Error Occurred: ${response.message()}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }


                        }
                        else {

                            Toast.makeText(
                                this@SignupActivity,
                                "Error Occurred: ${response.message()}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )

            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}