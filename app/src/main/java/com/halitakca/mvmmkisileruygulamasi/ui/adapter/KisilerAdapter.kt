package com.halitakca.mvmmkisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.halitakca.mvmmkisileruygulamasi.R
import com.halitakca.mvmmkisileruygulamasi.data.entity.Kisiler
import com.halitakca.mvmmkisileruygulamasi.databinding.CardRowBinding
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentContactEntryBinding
import com.halitakca.mvmmkisileruygulamasi.databinding.RecyclerRowBinding
import com.halitakca.mvmmkisileruygulamasi.ui.fragment.HomePageFragmentDirections
import com.halitakca.mvmmkisileruygulamasi.ui.viewmodel.HomePageViewModel
import com.halitakca.mvmmkisileruygulamasi.util.gecisYap


class KisilerAdapter(val kisilerList: ArrayList<Kisiler>,
                     var viewModel: HomePageViewModel)
    : RecyclerView.Adapter<KisilerAdapter.KisilerHolder>() {

    class KisilerHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisilerHolder {
        //val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding : RecyclerRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recycler_row, parent, false)

        return KisilerHolder(binding)
    }

    override fun getItemCount(): Int {
        return kisilerList.count()
    }

    override fun onBindViewHolder(holder: KisilerHolder, position: Int) {
        //holder.binding.recyclerViewTextView.text = "${kisilerList.get(position).kisi_ad} - ${kisilerList.get(position).kisi_tel}"
        val kisi = kisilerList.get(position)

        holder.binding.contactObject = kisi

        holder.binding.recyclerViewTextView.text = "${kisi.kisi_ad} - ${kisi.kisi_tel}"

        holder.binding.satirCard.setOnClickListener{
            val action = HomePageFragmentDirections.contactDetailNav(kisi)
            Navigation.gecisYap(it,action)
            // Without Extensions: Navigation.findNavController(it).navigate(action)
        }
        holder.binding.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"Are you sure to delete ${kisi.kisi_ad} ?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.delete(kisi.kisi_id)
                }.show()
        }
    }

}


//      BU ŞEKİLDE DE YAZILABİLİR.
/*
class KisilerAdapter(var mContext :Context, var kisilerList: List<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.KisilerHolder>(){
    inner class KisilerHolder(binding: CardRowBinding) : RecyclerView.ViewHolder(binding.root){
        var binding: CardRowBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisilerHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardRowBinding.inflate(layoutInflater,parent,false)
        return KisilerHolder(binding)
    }
    override fun onBindViewHolder(holder: KisilerHolder, position: Int) {
        val kisi = kisilerList.get(position)
        val t = holder.binding

        t.cardViewTextView.text = "${kisi.kisi_ad} - ${kisi.kisi_tel}"
    }

    override fun getItemCount(): Int {
        return kisilerList.size
    }

}
 */





