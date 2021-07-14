package com.jamshidbek.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jamshidbek.todolist.Adapter.SpinerAdapter1
import com.jamshidbek.todolist.CashMemory.MySharedPrefarance
import com.jamshidbek.todolist.Models.ToDoPlan
import com.jamshidbek.todolist.Models.User
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTask : AppCompatActivity() {
    lateinit var userArray:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        loadData()

        MySharedPrefarance.init(this)

        val spinerAdapter = SpinerAdapter1(userArray)
        spiner_add_to_do.adapter = spinerAdapter

        btn_save.setOnClickListener {
            val toDoName = edt_name.text.toString().trim()
            val toDoDescription = edt_desc.text.toString().trim()
            val toDoDedline = edt_deadline.text.toString().trim()

            val degree = userArray[spiner_add_to_do.selectedItemPosition]

            if (toDoName!="" && toDoDedline!="" && toDoDescription!=""){
                val myList = MySharedPrefarance.objectString
                myList.add(ToDoPlan(toDoName, toDoDescription, degree, toDoDedline, "Open"))
                println(myList)
                MySharedPrefarance.objectString = myList
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Error because editText is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadData() {
        userArray = ArrayList()
        userArray.add(User(-1, "To do degree"))
        userArray.add(User(R.drawable.ic_flag_red, "Urgent"))
        userArray.add(User(R.drawable.ic_flag_yellow, "High"))
        userArray.add(User(R.drawable.ic_flag_green, "Normal"))
        userArray.add(User(R.drawable.ic_flag_gray, "Low"))
    }
}