package com.example.iproceed.helpers

import Models.Course
import java.util.ArrayList

object SampleData {
    val COURSES = ArrayList<Course>()

    private var COUNT = 5

    private var dummy_description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce accumsan quis justo quis hendrerit. Curabitur a ante neque. Fusce nec mauris sodales, auctor sem at, luctus eros. Praesent aliquam nibh neque. Duis ut suscipit justo, id consectetur orci. Curabitur ultricies nunc eu enim dignissim, sed laoreet odio blandit."

    init {
        // Add some sample items
        val newCourse1 = Course()
        newCourse1.id = 1
        newCourse1.name = "Kotlin"
        newCourse1.description = dummy_description
        //newCourse1.country = "India"
        COURSES.add(newCourse1)

        val newCourse2 = Course()
        newCourse2.id = 2
        newCourse2.name = "Syntax"
        newCourse2.description = dummy_description
        //newCourse2.country = "Thailand"
        COURSES.add(newCourse2)

        val newCourse3 = Course()
        newCourse3.id = 3
        newCourse3.name = "New York"
        newCourse3.description = dummy_description
        //newCourse3.country = "USA"
        COURSES.add(newCourse3)

        val newCourse4 = Course()
        newCourse4.id = 4
        newCourse4.name = "London"
        newCourse4.description = dummy_description
        //newCourse4.country = "United Kingdom"
        COURSES.add(newCourse4)

        val newCourse5 = Course()
        newCourse5.id = 5
        newCourse5.name = "Sydney"
        newCourse5.description = dummy_description
        //newCourse5.country = "Australia"
        COURSES.add(newCourse5)

    }

    fun addCourse(item: Course) {
        item.id = COUNT
        COURSES.add(item)
        COUNT += 1
    }

    fun getCourseById(id: Int): Course? {
        for (i in COURSES.indices) {
            if (COURSES[i].id == id) {
                return COURSES[i]
            }
        }

        return null
    }

    fun deleteCourse(id: Int) {
        var courseToRemove: Course? = null

        for (i in COURSES.indices) {
            if (COURSES[i].id == id) {
                courseToRemove = COURSES[i]
            }
        }

        if (courseToRemove != null) {
            COURSES.remove(courseToRemove)
        }
    }

    fun updateCourse(course: Course) {
        for (i in COURSES.indices) {
            if (COURSES[i].id == course.id) {
                val courseToUpdate = COURSES[i]

                courseToUpdate.name = course.name
                courseToUpdate.description = course.description
                //courseToUpdate.country = course.country
            }
        }
    }
}