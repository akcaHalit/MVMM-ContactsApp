package com.halitakca.mvmmkisileruygulamasi.data.repo

import android.util.Log

class KisilerDaoRepository {


    fun contactEntry(personName: String, personPhoneNumber: String){
        Log.e("Contacts Entry:", "$personName - $personPhoneNumber")
    }
}