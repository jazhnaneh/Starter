package com.jazhnaneh.starter.service

import com.jazhnaneh.starter.model.Student
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface GetAllStudentApi {

    @GET("/student/getAll")
    fun getAllStudent(): Call<List<Student>>

}