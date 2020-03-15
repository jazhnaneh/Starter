package com.jazhnaneh.starter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jazhnaneh.starter.model.Student
import com.jazhnaneh.starter.service.AddStudentApi
import com.jazhnaneh.starter.service.GetAllStudentApi
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    companion object {
        const val URL = "http://192.168.1.154:8082";
    }

    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val okHttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttp)
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val getAllStudent = retrofit.create<GetAllStudentApi>(GetAllStudentApi::class.java)

        var allStudent = getAllStudent.getAllStudent()

        allStudent.enqueue(object : Callback<List<Student>> {
            override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {

                if (response.isSuccessful) {
                    callAdapter(response.body()!!)
                } else {
                    Toast.makeText(this@MainActivity, "Api isn't successful", Toast.LENGTH_LONG)
                        .show()

                }

            }

            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "onFailure", Toast.LENGTH_LONG)
                    .show()
            }
        })



        fab.setOnClickListener {

            startActivity(Intent(this, SaveStudentActivity::class.java))

        }

    }

    fun callAdapter(allStudent: List<Student>) {
        val adapter = StudentAdapter(allStudent)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = adapter
    }

}
