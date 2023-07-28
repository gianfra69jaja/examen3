package com.gire.examen3_gianfranco_remaycuna.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gire.examen3_gianfranco_remaycuna.R
import com.gire.examen3_gianfranco_remaycuna.databinding.ItemPersonBinding
import com.gire.examen3_gianfranco_remaycuna.model.Person

class PeopleAdapter : ListAdapter<Person, PeopleAdapter.ViewHolder>(PersonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = getItem(position)
        holder.bind(person)
    }

    class ViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person) {
            binding.name.text = "Alias: " + person.name
            binding.gender.text = "Genero: " + person.gender
            binding.birthYear.text = "Cumpleaños: " + person.birth_year
            Glide.with(binding.root)
                .load(R.drawable.dark)
                .into(binding.imgStarWars)
        }
    }
}

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}
