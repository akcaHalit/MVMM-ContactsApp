package com.halitakca.mvmmkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.halitakca.mvmmkisileruygulamasi.R
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentContactDetailBinding
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentHomePageBinding

class ContactDetailFragment : Fragment() {
    private lateinit var binding: FragmentContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //binding = FragmentContactDetailBinding.inflate(inflater,container,false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_detail,container,false)
        binding.contactDetailFragment = this

        binding.contactDetailToolbarTitle = "Contact Detail"

        //      Args datask bu şekilde çekiliyor.   Ve kullanımı:
        val bundle : ContactDetailFragmentArgs by navArgs()
        val kisi = bundle.kisi

        binding.contactObject = kisi

        return binding.root
    }

    fun buttonUpdate(kisi_id: Int,kisi_ad: String, kisi_tel: String) {
        Log.e("Contact Updated","$kisi_id : $kisi_ad - $kisi_tel")
    }


}

/*      DATA BİNDİNG İLE GEREKSİZ BUNLAR ARTIK.

        binding.toolbarcontactdetail.title = "Contact Detail"


        binding.editTextPersonName.setText(kisi.kisi_ad)
        binding.editTextPersonNumber.setText(kisi.kisi_tel)

        binding.buttonUpdate.setOnClickListener{
            val kisi_ad = kisi.kisi_ad
            val kisi_tel = kisi.kisi_tel

            buttonUpdate(kisi.kisi_id,kisi_ad,kisi_tel)
        }
 */