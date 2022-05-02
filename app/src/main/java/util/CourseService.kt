package util

import Models.Course
import retrofit2.Call
import retrofit2.http.*

interface CourseService {
    @GET("course")
    fun getCourseList(@QueryMap filter: HashMap<String, String>): Call<List<Course>>

    @GET("course/{id}")
    fun getCourse(@Path("id") id: Int): Call<Course>

    @POST("course")
    fun addCourse(@Body newCourse: Course): Call<Course>

    @FormUrlEncoded
    @PUT("course/{id}")
    fun updateCourse(
        @Path("id") id: Int,
        @Field("name") name: String,
        @Field("description") desc: String,

        ): Call<Course>

    @DELETE("course/{id}")
    fun deleteCourse(@Path("id") id: Int): Call<Unit>
}
