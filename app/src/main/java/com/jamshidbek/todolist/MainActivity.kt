package com.jamshidbek.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_goToAdd.setOnClickListener{
            startActivity(Intent(this, AddTask::class.java))
        }

        btn_goToDo.setOnClickListener{
            startActivity(Intent(this, ToDoList::class.java))
        }
    }
}