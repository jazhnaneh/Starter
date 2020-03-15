package com.jazhnaneh.starter.model

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("studentId")
    val id: Long,

    @SerializedName("studentName")
    val name: String,

    @SerializedName("studentAge")
    val age: String,

    @SerializedName("studentImageName")
    val imageName: String,

    @SerializedName("studentImageType")
    val imageType: String,

    @SerializedName("studentFamily")
    val family: String,

    @SerializedName("studentPhoneNumber")
    val phoneNumber: String,

    @SerializedName("studentNationalCode")
    val nationalCode: String
)