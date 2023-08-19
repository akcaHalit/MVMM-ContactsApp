package com.halitakca.mvmmkisileruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.halitakca.mvmmkisileruygulamasi.data.entity.Kisiler
import com.halitakca.mvmmkisileruygulamasi.databinding.CardRowBinding
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentContactEntryBinding
import com.halitakca.mvmmkisileruygulamasi.databinding.RecyclerRowBinding


class KisilerAdapter(val kisilerList: ArrayList<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.KisilerHolder>() {

    class KisilerHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisilerHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KisilerHolder(binding)
    }

    override fun getItemCount(): Int {
        return kisilerList.count()
    }

    override fun onBindViewHolder(holder: KisilerHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = "${kisilerList.get(position).kisi_ad} - ${kisilerList.get(position).kisi_tel}"

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





