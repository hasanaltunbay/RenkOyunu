package com.hasanaltunbay.renkoyunu

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hasanaltunbay.renkoyunu.databinding.FragmentOyunBinding


class OyunFragment : Fragment(),View.OnClickListener{

    lateinit var binding:FragmentOyunBinding

    lateinit var mSoruList:ArrayList<Sorular>

    private var SecilenPozisyon:Int=0
    private var DogruCevap:Int=0
    private var SuAnKiPozisyon:Int=1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_oyun, container, false)

        mSoruList=Sabitler.getSorular()

        binding.CevapBir.setOnClickListener (this)
        binding.CevapIki.setOnClickListener (this)
        binding.CevapUc.setOnClickListener (this)
        binding.CevapDort.setOnClickListener (this)
        binding.ButonGonder.setOnClickListener (this)



        setSorular()





        return binding.root
    }

    private fun setSorular() {

        var soru:Sorular=mSoruList[SuAnKiPozisyon-1]

        binding.soru.text=soru.soru
        binding.imageView.setImageResource(soru.resim)
        binding.CevapBir.text=soru.cevapBir
        binding.CevapIki.text=soru.cevapIki
        binding.CevapUc.text=soru.cevapUc
        binding.CevapDort.text=soru.cevapDort

        binding.pb.progress=SuAnKiPozisyon
        binding.textViewProgress.text="$SuAnKiPozisyon" + "/" + binding.pb.max

        defaultApperance()

        if (SuAnKiPozisyon==mSoruList.size){
            binding.ButonGonder.text="Sorular Bitti"
        }else{
            binding.ButonGonder.text="Gönder"
        }


    }

    private fun defaultApperance() {

        val options=ArrayList<TextView>()
        options.add(0,binding.CevapBir)
        options.add(1,binding.CevapIki)
        options.add(2,binding.CevapUc)
        options.add(3,binding.CevapDort)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=context?.let { ContextCompat.getDrawable(it,R.drawable.varsayilan_cevap_rengi) }


        }






    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.CevapBir->{
                SecilenSecenek(binding.CevapBir,1)

            }
            R.id.CevapIki->{
                SecilenSecenek(binding.CevapIki,2)

            }
            R.id.CevapUc->{
                SecilenSecenek(binding.CevapUc,3)

            }
            R.id.CevapDort->{
                SecilenSecenek(binding.CevapDort,4)

            }
            R.id.ButonGonder->{
                if(SecilenPozisyon==0){
                    SuAnKiPozisyon++

                    when{
                        SuAnKiPozisyon<=mSoruList.size->{
                            setSorular()

                        }else->{

                            val action=OyunFragmentDirections.actionOyunFragmentToSkorFragment()
                            val oyuncuIsmi by navArgs<OyunFragmentArgs>()
                            action.skor=DogruCevap
                            action.isim=oyuncuIsmi.isim
                            findNavController().navigate(action)

                        }
                    }

                }else{

                    val soru=mSoruList[SuAnKiPozisyon-1]

                    if(soru!!.dogruCevap!=SecilenPozisyon){
                        answerView(SecilenPozisyon,R.drawable.yanlis_cevap_rengi)
                    }else{
                        DogruCevap++

                        answerView(soru.dogruCevap,R.drawable.dogru_cevap_rengi)

                        if(SuAnKiPozisyon==mSoruList.size){
                            binding.ButonGonder.text="Bitti"
                        }else{
                            binding.ButonGonder.text="Bir Sonraki Soruya Geç"
                        }
                    }

                    SecilenPozisyon=0
                }
            }

        }
    }

    private fun answerView(secilenPozisyon: Int, drawableView: Int) {
        when (secilenPozisyon) {
            1 -> {
                binding.CevapBir.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }

            2 -> {
                binding.CevapIki.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }

            }

            3 -> {
                binding.CevapUc.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }

            4 -> {
                binding.CevapDort.background =
                    context?.let { ContextCompat.getDrawable(it, drawableView) }
            }

        }
    }

    private fun SecilenSecenek(cevap: TextView, secilenPozisyon: Int) {

        defaultApperance()

        SecilenPozisyon = secilenPozisyon

        cevap.setTextColor(Color.parseColor("#363A43"))
        //default appearance
        cevap.setTypeface(cevap.typeface, Typeface.BOLD)
        cevap.background = context?.let {
            ContextCompat.getDrawable(it, R.drawable.secilen_cevap_rengi)


        }

    }
}


