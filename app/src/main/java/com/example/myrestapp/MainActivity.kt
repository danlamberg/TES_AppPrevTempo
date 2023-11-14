package com.example.myrestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewComments)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CommentsAdapter(emptyList())
        recyclerView.adapter = adapter

        loadComments()

    }

    private fun loadComments() {
        lifecycleScope.launch {
            try {
                val comments = RetrofitClient.api.getComments()
                adapter = CommentsAdapter(comments)
                recyclerView.adapter = adapter
            }
            catch (e:java.lang.Exception){
                Toast.makeText(this@MainActivity, "Erro:" + e.message, Toast.LENGTH_LONG).show()
            }

        }
    }
}