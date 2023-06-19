package com.hasanaltunbay.renkoyunu

object Sabitler {

    fun getSorular():ArrayList<Sorular>{

        val soruList=ArrayList<Sorular>()

        val soru1=Sorular(1,"Bu ne renk?",R.drawable.elma,"yeşil","kırmızı","sarı","mavi",1)
        val soru2=Sorular(2,"Bu ne renk?",R.drawable.beyaz,"yeşil","turuncu","siyah","beyaz",4)
        val soru3=Sorular(3,"Bu ne renk?",R.drawable.kirmizi,"pembe","kırmızı","sarı","yesil",2)
        val soru4=Sorular(4,"Bu ne renk?",R.drawable.mavi,"siyah","turuncu","sarı","mavi",4)
        val soru5=Sorular(5,"Bu ne renk?",R.drawable.pembe,"pembe","beyaz","sarı","turuncu",1)
        val soru6=Sorular(6,"Bu ne renk?",R.drawable.sari,"beyaz","turuncu","sari","siyah",3)
        val soru7=Sorular(7,"Bu ne renk?",R.drawable.siyah,"mavi","siyah","kırmızı","beyaz",2)
        val soru8=Sorular(8,"Bu ne renk?",R.drawable.turuncu,"beyaz","mavi","turuncu","kırmızı",3)
        val soru9=Sorular(9,"Bu ne renk?",R.drawable.turkuaz,"yeşil","turkuaz","sarı","siyah",2)
        val soru10=Sorular(10,"Bu ne renk?",R.drawable.kahverengi,"pembe","siyah","kahverengi","kırmızı",3)

        soruList.add(soru1)
        soruList.add(soru2)
        soruList.add(soru3)
        soruList.add(soru4)
        soruList.add(soru5)
        soruList.add(soru6)
        soruList.add(soru7)
        soruList.add(soru8)
        soruList.add(soru9)
        soruList.add(soru10)

        return soruList
    }
}