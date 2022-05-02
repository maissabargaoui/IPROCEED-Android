package com.example.iproceed

import android.os.Parcel
import android.os.Parcelable

data class CourseData(
    val id:Int?,
    val title:String?,
    val galaxy:String?,
    val doc:String?,
    val gravity:String?,
    val overview:String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(galaxy)
        parcel.writeString(doc)
        parcel.writeString(gravity)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CourseData> {
        override fun createFromParcel(parcel: Parcel): CourseData {
            return CourseData(parcel)
        }

        override fun newArray(size: Int): Array<CourseData?> {
            return arrayOfNulls(size)
        }
    }

}
