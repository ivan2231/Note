package com.example.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.note.databinding.NoteListItemBinding
import com.example.note.room.NoteEntity

class NoteEntityListAdapter() : RecyclerView.Adapter<NoteEntityListAdapter.ViewHolder>() {

        var items: List<NoteEntity> = mutableListOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        private var itemClick: (NoteEntity) -> Unit = {}
        fun itemClick(listener: (NoteEntity) -> Unit) {
            itemClick = listener
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.note = items[position]
            holder.itemView.setOnClickListener {
                itemClick(items[position])
            }
        }

        override fun getItemCount(): Int {
            return items.size
        }


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var binding = NoteListItemBinding.bind(view)

        }
    }
