package com.example.iproceed.helpers

import Models.Course
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iproceed.CourseDetailActivity
import com.example.iproceed.R

class CourseAdapter(private val courseList: List<Course>) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.course = courseList[position]
        holder.txvCourse.text = courseList[position].name

        holder.itemView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, CourseDetailActivity::class.java)
            intent.putExtra(CourseDetailActivity.ARG_ITEM_ID, holder.course!!.id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txvCourse: TextView = itemView.findViewById(R.id.txv_course)
        var course: Course? = null

        override fun toString(): String {
            return """${super.toString()} '${txvCourse.text}'"""
        }
    }
}
