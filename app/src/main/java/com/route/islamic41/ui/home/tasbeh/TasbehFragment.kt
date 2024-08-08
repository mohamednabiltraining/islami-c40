package com.route.islamic41.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.route.islamic41.R
import com.route.islamic41.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var binding: FragmentTasbehBinding
    var rotateAnimation: RotateAnimation? = null
    lateinit var listOfAzkar: MutableList<String>
    var counter = 1
    var index = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        binding = FragmentTasbehBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sebhaBody.setOnClickListener {
            roatate()
        }
    }

    private fun roatate() {
        binding.counter.text = counter.toString()
        listOfAzkar = resources.getStringArray(R.array.azkar).toMutableList()
        binding.azkar.text = listOfAzkar[index]
        rotateAnimation()
        isMoreThan33()
    }

    private fun isMoreThan33() {
        if (counter < 33) {
            ++counter
        } else {
            counter = 0
            index = if (index < listOfAzkar.size - 1) ++index else 0
        }
    }

    private fun rotateAnimation() {
        rotateAnimation = RotateAnimation(
            0f,
            10f,
            Animation.RELATIVE_TO_SELF,
            .5f,
            Animation.RELATIVE_TO_SELF,
            .5f
        )
        rotateAnimation!!.setDuration(500)
        binding.sebhaBody.startAnimation(rotateAnimation)
    }
}



