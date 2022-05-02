package com.example.iproceed

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*


class Adapter(var course: List<CourseData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.title
        var courseimg = view.course_img
        var galaxy = view.galaxy
        var doc = view.doc


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,CourseDetail::class.java)
            intent.putExtra("course",course[position])
            intent.putExtra("courseImage",dummyImage)
            holder.itemView.context.startActivity(intent)

        }
        holder.title.text = course[position].title
        holder.galaxy.text = course[position].galaxy
        holder.doc.text = course[position].doc


        when (course[position].title!!.toLowerCase()) {
            "android studio" -> {
                dummyImage = R.drawable.ic_and
            }
            "syntax basics" -> {
                dummyImage = R.drawable.ic_syn
            }
            "introduction" -> {
                dummyImage = R.drawable.ic_intro
            }
            "why kotlin" -> {
                dummyImage = R.drawable.ic_kot
            }
            "layout material design" -> {
                dummyImage = R.drawable.ic_layout
            }
            "threads" -> {
                dummyImage = R.drawable.ic_thr
            }
            "data persistance" -> {
                dummyImage = R.drawable.ic_per
            }
            "android lifecycle" -> {
                dummyImage = R.drawable.ic_life
            }
            "android databases" -> {
                dummyImage = R.drawable.ic_data
            }
            "adapters and recyclers" -> {
                dummyImage = R.drawable.ic_adap
            }
        }
        holder.courseimg.setImageResource(dummyImage!!)


    }

    override fun getItemCount(): Int {
        return course.size
    }
}

