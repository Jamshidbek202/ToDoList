package com.jamshidbek.todolist.Models

class ToDoPlan {
    var name: String = ""
    var description: String = ""
    var deadLine = ""
    var degree:User? = null
    var level: String = ""

    constructor(name: String, description: String, degree: User?, deadline: String, level: String) {
        this.name = name
        this.description = description
        this.degree = degree
        this.deadLine = deadline
        this.level = level
    }
    constructor()

    override fun toString(): String {
        return "TodoPlan(name='$name', description='$description', degree='$degree', deadline='$deadLine', level='$level')"
    }
}

object PlanObject{
    var toDoPlanList = ArrayList<ToDoPlan>()
}
