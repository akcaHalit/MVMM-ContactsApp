package com.halitakca.mvmmkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.halitakca.mvmmkisileruygulamasi.R
import com.halitakca.mvmmkisileruygulamasi.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomePageBinding.inflate(inflater,container,false)

        binding.toolbarHomepage.title = "Contacts"
        //  ToolbarHomePage'e sen bir aksiyon bar'sın diyoruz Bu olmazsa Menu ile işlem yapmak zor.
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomepage)

        binding.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.contactEntryNav)
        }


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

    //     SearchView için olan implementation'lar: 2 tane
    override fun onQueryTextSubmit(query: String): Boolean { // Yazdıktan sonra Arama ikonuna basarsan çalışır.
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {  // Bişeyler yazıyorkenki değişimde çalışır.
        search(newText)
        return true
    }
    fun search(searchword: String){
        Log.e("Contact Search",searchword)
    }


}