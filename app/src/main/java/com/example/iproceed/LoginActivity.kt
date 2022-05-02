package com.example.iproceed

import Models.User
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.ApiClient
import util.UserSession
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()

        val email = findViewById<TextView>(R.id.email_et)
        val pwd = findViewById<TextView>(R.id.pwd_et)
        val login_btn = findViewById<Button>(R.id.login)
        val inscrireId = findViewById<Button>(R.id.signup)


        inscrireId.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
        }

        login_btn.setOnClickListener {

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


            ApiClient.apiService.login(User(email = email.text.toString(), password = pwd.text.toString())).enqueue(
                object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {

                        t.printStackTrace()

                    }
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.isSuccessful && response.body() != null) {
                            val content = response.body()

                            if(response.code() == 200)
                            {
                                val sharedPref = getSharedPreferences(
                                    getString(R.string.user), Context.MODE_PRIVATE)

                                with (sharedPref.edit()) {
                                    putString(getString(R.string.token), content.get("token").asString)
                                    commit()
                                }

                                val user = content.getAsJsonObject("user")

                                UserSession.id =
                                    user.get("_id").asString


                                UserSession.name =
                                    user.get("name").asString

                                UserSession.email =
                                    user.get("email").asString

                                val profilePicture = user.get("idPhoto").asString

                                if(!profilePicture.isEmpty())
                                    UserSession.image = profilePicture


                                val intent = Intent(this@LoginActivity, FreeCoursesActivity::class.java)
                                startActivity(intent)
                                finish()

                            }
                            if(response.code() == 201)
                            {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Error Occurred: ${response.message()}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            if(response.code() == 403)
                            {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Error Occurred: ${response.message()}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }


                        }
                        else {

                            Toast.makeText(
                                this@LoginActivity,
                                "Error Occurred: ${response.message()}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )



        }
    }
}