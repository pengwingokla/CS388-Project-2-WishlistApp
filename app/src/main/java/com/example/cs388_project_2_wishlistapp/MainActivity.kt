package com.example.cs388_project_2_wishlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import WishlistAdapter
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var itemList: ArrayList<WishlistAdapter.WishlistItem>
    private lateinit var adapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.WishlistRecyclerView)
        itemList = ArrayList()

        // Initialize the adapter and set it to the RecyclerView
        adapter = WishlistAdapter(itemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            // Get user input from EditText fields
            val itemName = findViewById<EditText>(R.id.itemNameField).text.toString()
            val itemUrl = findViewById<EditText>(R.id.urlField).text.toString()
            val itemPrice = findViewById<EditText>(R.id.priceField).text.toString()

            // Create a new WishlistItem and add it to the itemList
            val newItem = WishlistAdapter.WishlistItem(
                itemName,
                itemUrl,
                itemPrice,
                R.drawable.chobani
            )
            itemList.add(newItem)

            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged()

            // Clear the input fields
            findViewById<EditText>(R.id.itemNameField).text.clear()
            findViewById<EditText>(R.id.urlField).text.clear()
            findViewById<EditText>(R.id.priceField).text.clear()
        }
    }
}
