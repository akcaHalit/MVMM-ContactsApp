package com.halitakca.mvmmkisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.halitakca.mvmmkisileruygulamasi.data.repo.KisilerDaoRepository

class ContactEntryViewModel : ViewModel() {
    val krepo = KisilerDaoRepository()

    fun entry(personName: String, personPhoneNumber: String){
        krepo.contactEntry(personName,personPhoneNumber)
    }
}