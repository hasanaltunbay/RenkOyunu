package com.hasanaltunbay.renkoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.hasanaltunbay.renkoyunu.databinding.FragmentAnaBinding


class AnaFragment : Fragment() {

     lateinit var binding: FragmentAnaBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_ana,container,false)

        binding.baslaButon.setOnClickListener { view:View->

            if (binding.isim.text!!.isNotEmpty()){

                val action=AnaFragmentDirections.actionAnaFragmentToOyunFragment()
                action.isim=binding.isim.text.toString()
                findNavController().navigate(action)


            }else{
                Toast.makeText(context,"Önce isminizi giriniz!",Toast.LENGTH_SHORT).show()
            }

        }





        return binding.root

    }


}