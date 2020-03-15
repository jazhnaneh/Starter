package com.jazhnaneh.starter.service

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AddStudentApi {

    @Multipart
    @POST("/student/addStudent")
    fun addStudent(
        @Part("studentPhoneNumber") phoneNumber: RequestBody,
        @Part("studentNationalCode") nationalCode: RequestBody,
        @Part("studentName") name: RequestBody,
        @Part("studentFamily") family: RequestBody,
        @Part("studentAge") age: RequestBody,
        @Part image: MultipartBody.Part
    ): Call<Void>

}