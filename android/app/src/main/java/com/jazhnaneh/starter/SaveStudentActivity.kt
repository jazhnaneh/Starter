package com.jazhnaneh.starter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.ExifInterface
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.esafirm.imagepicker.features.ImagePicker
import com.jazhnaneh.starter.service.AddStudentApi
import kotlinx.android.synthetic.main.activity_save_student.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

class SaveStudentActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var image: ImageView
    lateinit var pickedBitmapBack: Bitmap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_student)

        image = findViewById(R.id.img_selected)

        image.setOnClickListener {
            selectImageBack()
        }


        val okHttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttp)
            .baseUrl(MainActivity.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val addStudentApi = retrofit.create<AddStudentApi>(AddStudentApi::class.java)


        btn_submit.setOnClickListener {

            val phoneNumber: String = edt_phone_number.text.toString()
            val nationalCode: String = edt_nationalCode.text.toString()
            val name: String = edt_name.text.toString()
            val family: String = edt_family.text.toString()
            val age: String = edt_age.text.toString()

            addStudentApi.addStudent(
                convertStringToRequestBody(phoneNumber),
                convertStringToRequestBody(nationalCode),
                convertStringToRequestBody(name),
                convertStringToRequestBody(family),
                convertStringToRequestBody(age),
                convertByteArrayToRequestBody(
                    convertDrawableToBytearray(image.drawable, pickedBitmapBack, 0)
                )
            ).enqueue(object : Callback<Void> {

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.e("MainActivity", "Retrofit Response ${response.code()}")

                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@SaveStudentActivity,
                            "Student Saved",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    } else {
                        Toast.makeText(
                            this@SaveStudentActivity,
                            "Student can not Saved",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@SaveStudentActivity, "onFailure", Toast.LENGTH_LONG)
                        .show()
                }


            })
        }

    }

    private fun selectImageBack() {
        ImagePicker.create(this)
            .limit(1)
            .single()
            .toolbarImageTitle("عکس خود را انتخاب نمایید")
            .toolbarDoneButtonText("انتخاب")
            .start()
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            val image = ImagePicker.getFirstImageOrNull(data)
            setImageBack(image.path)
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


    private fun setImageBack(path: String) {
        val imgFile = File(path)
        if (imgFile.exists()) {
            pickedBitmapBack = BitmapFactory.decodeFile(imgFile.absolutePath)
            var ei: ExifInterface? = null
            try {
                ei = ExifInterface(path)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            //todo setImage to imageView
            image.setImageBitmap(pickedBitmapBack)
        }
    }

    private fun convertDrawableToBytearray(
        d: Drawable,
        pickedBitmap: Bitmap?,
        count: Int
    ): ByteArray {
        val maxSize = 300 - 10 * count
        val resizedBitmap: Bitmap
        resizedBitmap = if (pickedBitmap != null) {
            getResizedBitmap(pickedBitmap, maxSize)
        } else {
            (d as BitmapDrawable).bitmap
        }
        val stream = ByteArrayOutputStream()
        resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }

    fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
        var width = image.width
        var height = image.height
        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 1) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }

    fun convertStringToRequestBody(text: String): RequestBody {
        return text.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    fun convertByteArrayToRequestBody(image: ByteArray): MultipartBody.Part {
        var toRequestBody = image.toRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("student_image", "alipic", toRequestBody)
    }
}
