package com.halitakca.mvmmkisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.halitakca.mvmmkisileruygulamasi.data.repo.KisilerDaoRepository

class ContactDetailViewModel : ViewModel() {
    val krepo = KisilerDaoRepository()

    fun update(kisi_id: Int,kisi_ad: String, kisi_tel: String) {
        krepo.contactUpdate(kisi_id,kisi_ad,kisi_tel)
    }

}