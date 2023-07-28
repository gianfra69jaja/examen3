package com.gire.examen3_gianfranco_remaycuna.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.gire.examen3_gianfranco_remaycuna.R
import com.gire.examen3_gianfranco_remaycuna.databinding.FragmentFavoritosBinding
import com.gire.examen3_gianfranco_remaycuna.viewmodel.MainViewModel

class FavoritosFragment : Fragment() {
    private var _binding: FragmentFavoritosBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.lukeSkywalker.observe(viewLifecycleOwner) { lukeSkywalker ->
            binding.nombreluke.text = "Pj: " + lukeSkywalker.name
            binding.generoluke.text = "Genero: " + lukeSkywalker.gender
            binding.cumpleLuke.text = "Cumpleaños: " + lukeSkywalker.birth_year
            binding.alturaluke.text = "Altura: " + lukeSkywalker.height
            binding.pesoluke.text = "Peso: " + lukeSkywalker.mass
            Glide.with(this).load(R.drawable.luke).into(binding.imgluke)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
