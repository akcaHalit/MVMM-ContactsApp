package com.halitakca.mvmmkisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halitakca.mvmmkisileruygulamasi.data.entity.Kisiler
import com.halitakca.mvmmkisileruygulamasi.data.repo.KisilerDaoRepository

class HomePageViewModel  : ViewModel(){
    val krepo = KisilerDaoRepository()
    var kisilerList = MutableLiveData<ArrayList<Kisiler>>()
    init {
        loadContacts()
        kisilerList = krepo.getContacts()
    }


    fun search(searchword: String){
        krepo.contactSearch(searchword)
    }
    fun delete(kisi_id: Int){
        krepo.contactDelete(kisi_id)
    }

    fun loadContacts(){
        krepo.getAllContacts()
    }

}