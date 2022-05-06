package com.example.iproceed
import Models.Course

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_course_create.*
import kotlinx.android.synthetic.main.activity_course_detail2.*
import kotlinx.android.synthetic.main.activity_course_detail2.et_description
import kotlinx.android.synthetic.main.activity_course_detail2.et_name
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.CourseService
import util.ServiceBuilder

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail2)

        //setSupportActionBar(detail_toolbar)
        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle: Bundle? = intent.extras

        if (bundle?.containsKey(ARG_ITEM_ID)!!) {

            val id = intent.getIntExtra(ARG_ITEM_ID, 0)

            loadDetails(id)

            initUpdateButton(id)

            initDeleteButton(id)
        }
    }

    private fun loadDetails(id: Int) {

        val courseService = ServiceBuilder.buildService(CourseService::class.java)
        val requestCall = courseService.getCourse(id)

        requestCall.enqueue(object : retrofit2.Callback<Course> {

            override fun onResponse(call: Call<Course>, response: Response<Course>) {

                if (response.isSuccessful) {
                    val course = response.body()
                    course?.let {
                        et_name.setText(course.name)
                        et_description.setText(course.description)
                        et_coursetype1.setText(course.coursetype)

                        //collapsing_toolbar.title = course.name
                    }
                } else {
                    Toast.makeText(this@CourseDetailActivity, "Failed to retrieve details", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<Course>, t: Throwable) {
                Toast.makeText(
                    this@CourseDetailActivity,
                    "Failed to retrieve details " + t.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun initUpdateButton(id: Int) {

        btn_update.setOnClickListener {

            val name = et_name.text.toString()
            val description = et_description.text.toString()
            val coursetype = et_coursetype1.text.toString()

            val courseService = ServiceBuilder.buildService(CourseService::class.java)
            val requestCall = courseService.updateCourse(id, name, description, coursetype)

            requestCall.enqueue(object: Callback<Course> {

                override fun onResponse(call: Call<Course>, response: Response<Course>) {
                    if (response.isSuccessful) {
                        finish() // Move back to CourseListActivity
                        var updatedCourse = response.body() // Use it or ignore It
                        Toast.makeText(this@CourseDetailActivity,
                            "Item Updated Successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@CourseDetailActivity,
                            "Failed to update item", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Course>, t: Throwable) {
                    Toast.makeText(this@CourseDetailActivity,
                        "Failed to update item", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun initDeleteButton(id: Int) {

        btn_delete.setOnClickListener {

            val courseService = ServiceBuilder.buildService(CourseService::class.java)
            val requestCall = courseService.deleteCourse(id)

            requestCall.enqueue(object: Callback<Unit> {

                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    if (response.isSuccessful) {
                        finish() // Move back to CourseListActivity
                        Toast.makeText(this@CourseDetailActivity, "Successfully Deleted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@CourseDetailActivity, "Failed to Delete", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Toast.makeText(this@CourseDetailActivity, "Failed to Delete", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, CourseListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        const val ARG_ITEM_ID = "item_id"
    }
}
