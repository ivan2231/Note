package com.example.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.note.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {

    lateinit var binding: FragmentNoteListBinding
    lateinit var viewModel: PageViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[PageViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = NoteEntityListAdapter()
        viewModel.note.observe(requireActivity()) {
            adapter.items = it
        }

        binding.noteListRv.adapter = adapter
        binding.fab.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_noteListFragment_to_noteEditFragment)
        }


    }
}