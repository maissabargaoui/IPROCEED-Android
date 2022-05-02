package com.example.iproceed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.activity_free_courses.*

class CourseDetail : AppCompatActivity() {
    private lateinit var obj:CourseData
    private var courseImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }

        obj= intent.getParcelableExtra("course")!!
        courseImg=intent.getIntExtra("courseImage",-1)
        setData(obj, courseImg!!)

        button_info.setOnClickListener{
            val intent=Intent(this,finalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(obj:CourseData, courseImg:Int)
    {
        title_info.text=obj.title
        doc_info.text=obj.doc
        gravity_info.text=obj.gravity
        overview_info.text=obj.overview
        galaxy_info.text=obj.galaxy
        course_img_info.setImageResource(courseImg)


    }
}


