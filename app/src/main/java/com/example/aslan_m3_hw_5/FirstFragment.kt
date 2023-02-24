package com.example.aslan_m3_hw_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aslan_m3_hw_5.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var counter = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPlusMinus()

    }

    private fun btnPlusMinus() {
        var count = binding.tvZero.text.toString().toInt().plus(1)
        binding.btn.setOnClickListener{
            when(counter){
                false->{
                    when(count == 10){
                        false-> {
                            binding.tvZero.text = count++.toString()
                        }
                        true->{
                            counter = true
                            binding.tvZero.text = count--.toString()
                            binding.btn.text = "-1"
                        }
                    }
                }

                true -> {
                    when( count == 0 ){
                        false->
                            binding.tvZero.text = count--.toString()
                        true -> textView()
                    }
                }
            }



        }

    }

    private fun textView() {
        val bundle = Bundle()
        bundle.putString("Key", binding.tvZero.text.toString())
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, secondFragment).commit()    }


}