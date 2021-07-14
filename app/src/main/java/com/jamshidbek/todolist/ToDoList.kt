package com.jamshidbek.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jamshidbek.todolist.Adapter.ExpandedAdapter
import com.jamshidbek.todolist.CashMemory.MySharedPrefarance
import com.jamshidbek.todolist.Models.ToDoPlan
import kotlinx.android.synthetic.main.activity_to_do_list.*

class ToDoList : AppCompatActivity(){
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var titleList:ArrayList<String>

    lateinit var openArray:ArrayList<String>
    lateinit var developmentArray:ArrayList<String>
    lateinit var uploadingArray:ArrayList<String>
    lateinit var rejectArray:ArrayList<String>
    lateinit var closedArray:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        expanded_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this, Property::class.java)
            intent.putExtra("name", map[titleList[groupPosition]]?.get(childPosition))
            startActivity(intent)
            true
        }
    }


    private fun fromCashToArray() {
        map = HashMap()
        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

        var planArray = ArrayList<ToDoPlan>()
        planArray = MySharedPrefarance.objectString
        println(planArray)
        var nameArray = ArrayList<ToDoPlan>()
        for (todoPlan in planArray) {
            if (todoPlan.level == "Open"){
                openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Development"){
                developmentArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Uploading"){
                uploadingArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Reject"){
                rejectArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Close"){
                closedArray.add(todoPlan.name)
            }
        }

        map[titleList[0]] = openArray
        map[titleList[1]] = developmentArray
        map[titleList[2]] = uploadingArray
        map[titleList[3]] = rejectArray
        map[titleList[4]] = closedArray

    }


    override fun onStart() {
        super.onStart()
        MySharedPrefarance.init(this)
        fromCashToArray()
        Log.i("information", "onStart method")
        val spinerAdapter1 = ExpandedAdapter(titleList, map)
        expanded_menu.setAdapter(spinerAdapter1)

    }
}