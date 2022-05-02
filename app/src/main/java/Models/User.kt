package Models

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id") val id: String?="",
    @SerializedName("name") val name: String?="",
    @SerializedName("email") val email: String?="",
    @SerializedName("address") val address: String?="",
    @SerializedName("password") val password: String?="",
    @SerializedName("phone") val phone: String?="",
    @SerializedName("idPhoto") val idPhoto: String?="",
    @SerializedName("role") val role: String?="",
    @SerializedName("prixParCour") val prixParCour: String?="",
    @SerializedName("neverNotified") val neverNotified: String?=""

) {
    override fun toString(): String {
        return "User(id=$id, name=$name, email=$email, address=$address, password=$password, phone=$phone, password=$password, idPhoto=$idPhoto, role=$role, prixParCour=$prixParCour, neverNotified=$neverNotified)"
    }
}
