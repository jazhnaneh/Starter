package com.jazhnaneh.starter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jazhnaneh.starter.model.Student

class StudentAdapter(val allStudent: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_rcv_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allStudent.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        var student = allStudent.get(position)
        holder.txtName.text = student.name
        holder.txtFamily.text = student.family
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var txtName: TextView
        lateinit var txtFamily: TextView

        init {
            txtName = itemView.findViewById<TextView>(R.id.txt_name)
            txtFamily = itemView.findViewById<TextView>(R.id.txt_family)
        }
    }
}