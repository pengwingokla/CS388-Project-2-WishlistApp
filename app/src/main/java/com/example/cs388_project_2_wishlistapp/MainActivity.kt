package com.example.cs388_project_2_wishlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cs388_project_2_wishlistapp.databinding.ActivityMainBinding
import WishlistAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val wishList = mutableListOf<WishItem>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var wishListAdapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        wishListAdapter = WishlistAdapter(wishList)
        WishlistRecycleView.adapter = wishListAdapter
        WishlistRecycleView.layoutManager = LinearLayoutManager(this)

        binding.btnAdd.setOnClickListener {
            val itemName = binding.itemNameField.text.toString()
            val itemURL = binding.urlField.text.toString()
            val itemPrice = binding.priceField.text.toString().toDoubleOrNull() ?: 0.0

            if (itemName.isNotEmpty() && itemURL.isNotEmpty()) {
                val wishItem = WishItem(itemName, itemURL, itemPrice)
                wishList.add(wishItem)
                wishListAdapter.notifyItemInserted(wishList.size - 1)
                clearFields()
            }
        }
    }

    private fun clearFields() {
        binding.itemNameField.text.clear()
        binding.urlField.text.clear()
        binding.priceField.text.clear()
    }
}

    }
    }

data class WishItem(val name: String, val url: String, val price: Double)
