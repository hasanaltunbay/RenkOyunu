package com.hasanaltunbay.renkoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.hasanaltunbay.renkoyunu.databinding.FragmentSkorBinding


class SkorFragment : Fragment() {

    lateinit var binding:FragmentSkorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_skor,container,false)

        val skorArgs by navArgs<SkorFragmentArgs>()
        binding.SonucGoster.text="${skorArgs.isim}! senin skorun 10 üzerinden ${skorArgs.skor} puan "

        binding.tekrarOyna.setOnClickListener {view:View->
            view.findNavController().navigate(R.id.action_skorFragment_to_anaFragment)

        }






        return binding.root
    }


}