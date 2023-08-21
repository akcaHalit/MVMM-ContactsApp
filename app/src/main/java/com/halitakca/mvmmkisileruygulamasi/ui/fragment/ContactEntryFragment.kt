package com.halitakca.mvmmkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.halitakca.mvmmkisileruygulamasi.R
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentContactEntryBinding
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentHomePageBinding
import com.halitakca.mvmmkisileruygulamasi.ui.viewmodel.ContactDetailViewModel
import com.halitakca.mvmmkisileruygulamasi.ui.viewmodel.ContactEntryViewModel
import com.halitakca.mvmmkisileruygulamasi.ui.viewmodel.HomePageViewModel


class ContactEntryFragment : Fragment() {
    private lateinit var binding: FragmentContactEntryBinding
    private lateinit var viewModel : ContactEntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : ContactEntryViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //binding = FragmentContactEntryBinding.inflate(inflater,container,false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_entry,container,false)
        binding.contactEntryFragment = this
        
        binding.contactEntryToolbarTitle = "Contacts Entry"


        return binding.root
    }
    fun buttonSave(personName: String, personPhoneNumber: String){
       viewModel.entry(personName,personPhoneNumber)
    }

}


/*      DATA BİNDİNG İLE GEREK YOK ARTIK BUNA.
        binding.toolbarContactentry.title = "Contacts Entry"

 binding.buttonSave.setOnClickListener{
            val personName = binding.editTextPersonName.text.toString()
            val personPhoneNumber = binding.editTextPersonNumber.text.toString()

            buttonSave(personName,personPhoneNumber)
  }
 */