package com.gire.examen3_gianfranco_remaycuna.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.gire.examen3_gianfranco_remaycuna.R
import com.gire.examen3_gianfranco_remaycuna.adapter.PeopleAdapter
import com.gire.examen3_gianfranco_remaycuna.databinding.FragmentMainBinding
import com.gire.examen3_gianfranco_remaycuna.viewmodel.MainViewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PeopleAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.people.observe(viewLifecycleOwner) { people ->
            adapter.submitList(people)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
