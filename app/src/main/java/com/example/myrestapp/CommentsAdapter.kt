package com.example.myrestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(private val registrosClimaticos: List<Previsao>) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {
    class CommentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textViewCommentData: TextView = itemView.findViewById(R.id.textViewCommentData)
        val textViewTemperaturaMaxima: TextView = itemView.findViewById(R.id.textViewTemperaturaMaxima)
        val textViewTemperaturaMimima: TextView = itemView.findViewById(R.id.textViewTemperaturaMimima)
        val textViewUmidade: TextView = itemView.findViewById(R.id.textViewUmidade)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentsAdapter.CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item ,parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsAdapter.CommentViewHolder, position: Int) {
        holder.textViewCommentData.text = "Data: "+ registrosClimaticos[position].data
        holder.textViewTemperaturaMaxima.text = registrosClimaticos[position].temperaturaMaxima.toString()
        holder.textViewTemperaturaMimima.text = registrosClimaticos[position].temperaturaMinima.toString()
        holder.textViewUmidade.text = registrosClimaticos[position].umidade.toString()
    }

    override fun getItemCount(): Int {
        return registrosClimaticos.size
    }

}
