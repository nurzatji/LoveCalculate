package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

import androidx.navigation.fragment.findNavController
import com.example.retrofit.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response



class FirstFragment : Fragment() {
lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
      with(binding){
          btnCalculate.setOnClickListener {
              LoveService().api.getPercentage(
                 etFirstName.text.toString(),
                 etSecondName.text.toString()

                  ).enqueue(object :retrofit2.Callback <LoveModel> {
                  override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                     if (response.isSuccessful){
                         Log.e("ololo","onResponse(:${response.body()}")
                         findNavController().navigate(R.id.secondFragment, bundleOf("result" to response.body())
                         )


                     }

                  }

                  override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                      Log.e("ololo", "onResponse: ${t.message}")
                  }

              })
          }
      }
    }
}












