package com.example.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.retrofit.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getData() {
      val result = arguments?.getSerializable("result") as LoveModel
        with(binding){
            tvFirstName.text = result.fistName
            tvSecondName.text = result.secondName
           tvResult.text = result.result
           tvPercentage.text = result.percentage




        }
    }

}