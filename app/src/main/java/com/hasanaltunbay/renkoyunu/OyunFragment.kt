package com.hasanaltunbay.renkoyunu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hasanaltunbay.renkoyunu.databinding.FragmentOyunBinding


class OyunFragment : Fragment() {

    lateinit var binding:FragmentOyunBinding

    lateinit var mSoruList:ArrayList<Sorular>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_oyun, container, false)

        mSoruList=Sabitler.getSorular()






        return binding.root
    }


}