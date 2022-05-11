package com.example.iproceed

import Models.Course
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_course_create.*
import kotlinx.android.synthetic.main.activity_course_create.et_description
import kotlinx.android.synthetic.main.activity_course_create.et_name
import kotlinx.android.synthetic.main.activity_course_detail2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.CourseService
import util.ServiceBuilder

class CourseCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_create)


        val button1 = findViewById<Button>(R.id.btn_addmedia)
        button1.setOnClickListener{
            val intent = Intent(this, MediaActivity::class.java)
            startActivity(intent)
        }
        val button = findViewById<Button>(R.id.btn_gomap)
        button.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        val context = this

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_add.setOnClickListener {
            val newCourse = Course()
            newCourse.name = et_name.text.toString()
            newCourse.description = et_description.text.toString()
            newCourse.coursetype = et_coursetype.text.toString()

            val courseService = ServiceBuilder.buildService(CourseService::class.java)
            val requestCall = courseService.addCourse(newCourse)
            requestCall.enqueue(object: Callback<Course> {

                override fun onResponse(call: Call<Course>, response: Response<Course>) {
                    if (response.isSuccessful) {
                        finish() // Move back to CourseListActivity
                        var newlyCreatedCourse = response.body() // Use it or ignore it
                        Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Failed to add item", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Course>, t: Throwable) {
                    Toast.makeText(context, "Failed to add item", Toast.LENGTH_SHORT).show()
                }
            })
        }

    }




}
