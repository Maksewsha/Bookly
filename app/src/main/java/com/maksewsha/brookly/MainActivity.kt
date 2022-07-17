package com.maksewsha.brookly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.maksewsha.brookly.presentation.fragments.MainFragment
import com.maksewsha.brookly.presentation.viewmodels.MainViewModel
import com.maksewsha.brookly.presentation.viewmodels.factories.MainVMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myFragment: Fragment?

        if(savedInstanceState != null){
            myFragment = supportFragmentManager.getFragment(savedInstanceState, "DetailFragment");
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, myFragment!!)
        }

        mainViewModel = ViewModelProvider(this, MainVMFactory()).get(MainViewModel::class.java)

        mainViewModel.fetchBestList()
        mainViewModel.fetchCarousel()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, MainFragment(), "MainFragment")
            .commit()
    }



    override fun onSaveInstanceState(outState: Bundle) {
        supportFragmentManager.findFragmentByTag("DetailFragment")
            ?.let { supportFragmentManager.putFragment(outState, "DetailFragment", it) }
        super.onSaveInstanceState(outState)
    }
}