package com.mkrdeveloper.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var imageId: Array<Int>
    private lateinit var names: Array<String>
    private lateinit var ingredients: Array<String>

    private lateinit var recView : RecyclerView
    private lateinit var itemArrayList: ArrayList<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6
        )

        names = arrayOf(
            "pizza1",
            "pizza2",
            "pizza3",
            "pizza4",
            "pizza5",
            "pizza6"
        )

        ingredients = arrayOf(
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano",
            "Tomato sos, cheese, oregano"
        )


        recView = findViewById(R.id.recView)
        recView.layoutManager = LinearLayoutManager(this)
        recView.setHasFixedSize(true)


        itemArrayList = arrayListOf()

        getData()

        recView.adapter = RecAadapter(itemArrayList)

    }

    private fun getData() {

        for (i in imageId.indices){
            val pizza = Pizza(imageId[i], names[i], ingredients[i])
            itemArrayList.add(pizza)
        }
    }
}