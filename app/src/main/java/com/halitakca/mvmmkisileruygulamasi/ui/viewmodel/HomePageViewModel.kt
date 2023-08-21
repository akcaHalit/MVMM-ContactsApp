package com.halitakca.mvmmkisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.halitakca.mvmmkisileruygulamasi.data.repo.KisilerDaoRepository

class HomePageViewModel  : ViewModel(){
    val krepo = KisilerDaoRepository()


}