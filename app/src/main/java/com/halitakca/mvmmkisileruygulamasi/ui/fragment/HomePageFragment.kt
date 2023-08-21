package com.halitakca.mvmmkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.halitakca.mvmmkisileruygulamasi.R
import com.halitakca.mvmmkisileruygulamasi.data.entity.Kisiler
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentHomePageBinding
import com.halitakca.mvmmkisileruygulamasi.ui.adapter.KisilerAdapter
import com.halitakca.mvmmkisileruygulamasi.ui.viewmodel.HomePageViewModel
import com.halitakca.mvmmkisileruygulamasi.util.gecisYap


class HomePageFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var adapter: KisilerAdapter
    private lateinit var viewModel : HomePageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //binding = FragmentHomePageBinding.inflate(inflater,container,false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false)
        binding.homePageFragment = this


        binding.homePageToolbarTitle = "Contacts"
        //  ToolbarHomePage'e sen bir aksiyon bar'sın diyoruz Bu olmazsa Menu ile işlem yapmak zor.
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomepage)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())


        viewModel.kisilerList.observe(viewLifecycleOwner){
            adapter = KisilerAdapter(it,viewModel)
            binding.kisilerAdapter = adapter
        }
        // with ViewModel we need to pass the viewModel argument.



        // MAİN'DE Yaptığımız MENU kodlamasının FRAGMENT'taki hali:
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                //  HomePageFragment implementationları ile bağlamış olduk
                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomePageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

            // Menu'nun Yaşam Döngüsü ile doğru bir şekilde çalışması için lazımlar:
        },viewLifecycleOwner,Lifecycle.State.RESUMED)



        return binding.root
    }
    fun fabClicked(it: View){
        Navigation.gecisYap(it,R.id.contactEntryNav)
        // Without Extensions: Navigation.findNavController(it).navigate(R.id.contactEntryNav)
    }

    //     SearchView için olan implementation'lar: 2 tane
    override fun onQueryTextSubmit(query: String): Boolean { // Yazdıktan sonra Arama ikonuna basarsan çalışır.
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {  // Bişeyler yazıyorkenki değişimde çalışır.
        viewModel.search(newText)
        return true
    }
    /*      Not Necessary with ViewModel - Repo Structure now.
    fun search(searchword: String){
        Log.e("Contact Search",searchword)
    }
     */

    override fun onResume() {
        super.onResume()
        // Sürekli loadContacts yapıp datayı yenilicek.
        viewModel.loadContacts()
    }



}


/*

        binding.rv.adapter = adapter

        binding.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.contactEntryNav)
        }

 */