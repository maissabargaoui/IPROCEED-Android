package util

import Models.User
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap

interface ApiService {


    //User
    @POST("user/login")
    fun login(@Body post: User): Call<JsonObject>
    @POST("user/signup")
    fun register(@Body post: User): Call<JsonObject>
    @POST("user/by-id")
    fun getUserById(@Body post: User): Call<JsonObject>
    @FormUrlEncoded
    @PUT("user/editProfile")
    fun editProfile(@FieldMap params: HashMap<String?, String?>): Call<JsonObject>


    @FormUrlEncoded
    @POST("user/getUserFromToken")
    fun getUserByToken(@FieldMap params: HashMap<String?, String?>): Call<JsonObject>

}