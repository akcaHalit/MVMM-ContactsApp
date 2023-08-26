package com.halitakca.mvmmkisileruygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.halitakca.mvmmkisileruygulamasi.data.entity.Kisiler

class KisilerDaoRepository {

    var kisilerListesi : MutableLiveData<ArrayList<Kisiler>>
    init {
        kisilerListesi = MutableLiveData()
    }
    fun contactDelete(kisi_id: Int){
        Log.e("Contact Delete: ",kisi_id.toString())
    }
    fun contactSearch(searchword: String){
        Log.e("Contact Search",searchword)
    }
    fun contactUpdate(kisi_id: Int,kisi_ad: String, kisi_tel: String) {
        Log.e("Contact Updated","$kisi_id : $kisi_ad - $kisi_tel")
    }

    fun contactEntry(personName: String, personPhoneNumber: String){
        Log.e("Contacts Entry:", "$personName - $personPhoneNumber")
    }

    fun getAllContacts(){
        val kisilerList = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Halit","2002")
        val k4 = Kisiler(2,"Saime","1974")
        val k2 = Kisiler(3,"Ahmet","1966")
        val k3 = Kisiler(4,"Osman","1997")
        val k9 = Kisiler(1,"Halit","2002")
        val k5 = Kisiler(1,"Halit","2002")
        val k6 = Kisiler(1,"Halit","2002")
        val k7 = Kisiler(1,"Halit","2002")
        val k8 = Kisiler(1,"Halit","2002")
        val k10 = Kisiler(1,"Halit","2002")
        val k11 = Kisiler(1,"Halit","2002")

        kisilerList.add(k1)
        kisilerList.add(k2)
        kisilerList.add(k3)
        kisilerList.add(k4)
        kisilerList.add(k5)
        kisilerList.add(k6)
        kisilerList.add(k7)
        kisilerList.add(k8)
        kisilerList.add(k9)
        kisilerList.add(k10)
        kisilerList.add(k11)

        kisilerListesi.value = kisilerList
    }

    fun getContacts() : MutableLiveData<ArrayList<Kisiler>>{
        return kisilerListesi
    }
}