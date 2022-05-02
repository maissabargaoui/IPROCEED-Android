package util

object UserSession {


    init {
        println("UserSession invoked.")
    }
    var id = ""
    var name = ""
    var image = "default-profile.png"
    var email = ""

    fun fullName ():String{
        return "$name"
    }

    fun reset()
    {
        id = ""
        name = ""
        image = "default-profile.png"
        email = ""

    }

}