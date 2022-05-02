package com.example.iproceed

import Models.Course
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.iproceed.helpers.CourseAdapter
import kotlinx.android.synthetic.main.activity_course_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.CourseService
import util.ServiceBuilder

class CourseListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)

        fab.setOnClickListener {
            val intent = Intent(this@CourseListActivity, CourseCreateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        loadCourses()
    }

    private fun loadCourses() {

        val courseService = ServiceBuilder.buildService(CourseService::class.java)

        val filter = HashMap<String, String>()
//        filter["country"] = "India"
//        filter["count"] = "1"

        val requestCall = courseService.getCourseList(filter)

        requestCall.enqueue(object: Callback<List<Course>> {

            // If you receive a HTTP Response, then this method is executed
            // Your STATUS Code will decide if your Http Response is a Success or Error
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                if (response.isSuccessful) {
                    // Your status code is in the range of 200's
                    val courseList = response.body()!!
                    my_recycler.adapter = CourseAdapter(courseList)
                } else if(response.code() == 401) {
                    Toast.makeText(this@CourseListActivity,
                        "Your session has expired. Please Login again.", Toast.LENGTH_LONG).show()
                } else { // Application-level failure
                    // Your status code is in the range of 300's, 400's and 500's
                    Toast.makeText(this@CourseListActivity, "Failed to retrieve items", Toast.LENGTH_LONG).show()
                }
            }

            // Invoked in case of Network Error or Establishing connection with Server
            // or Error Creating Http Request or Error Processing Http Response
            override fun onFailure(call: Call<List<Course>>, t: Throwable) {

                Toast.makeText(this@CourseListActivity, "Error Occurred" + t.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}









