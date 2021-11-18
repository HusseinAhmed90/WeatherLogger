package com.example.weatherlogger.views.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.weatherlogger.databinding.FragmentSplashBinding
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Executors.newSingleThreadScheduledExecutor().schedule({
            findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToListFragment()
            )
        }, 2, TimeUnit.SECONDS)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}