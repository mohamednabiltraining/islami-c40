package com.route.islamic41.ui.home.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.R
import com.route.islamic41.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {
    lateinit var binding: FragmentRadioBinding
    var PauseClick = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRadioBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startRadio()
    }

    private fun startRadio() {
        binding.startButton.setOnClickListener{
            PauseClick =! PauseClick
            if (PauseClick)
            {
                //todo get Api Impl
                binding.startButton.setImageResource(R.drawable.pause_icon)
                binding.startButton.animate().apply {
                    duration = 250
                    rotationBy(360f)
                }

            }else {
                //todo Stop Function
                binding.startButton.setImageResource(R.drawable.start_icon)
                binding.startButton.animate().apply {
                    duration = 250
                    rotationBy(360f)
                }
            }

        }
    }



}
