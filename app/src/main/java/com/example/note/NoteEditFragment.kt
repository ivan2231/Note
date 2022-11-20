package com.example.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.note.databinding.FragmentNoteEditBinding
import com.example.note.room.NoteEntity

class NoteEditFragment : Fragment() {

    lateinit var binding: FragmentNoteEditBinding
    lateinit var viewModel: PageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteEditBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[PageViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveNote.setOnClickListener {
            val title = binding.TitleEditText.text.toString()
            val body = binding.bodyEditText.text.toString()
            val note = NoteEntity(title, body)
            viewModel.insert(note)
            Navigation.findNavController(it).navigate(R.id.action_noteEditFragment_to_noteListFragment)
        }
    }
}