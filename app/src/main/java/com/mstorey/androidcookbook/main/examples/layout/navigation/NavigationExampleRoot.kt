package com.mstorey.androidcookbook.main.examples.layout.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mstorey.androidcookbook.R
import com.mstorey.androidcookbook.main.BaseFragment



/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NavigationExampleRoot.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NavigationExampleRoot.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NavigationExampleRoot : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_example_root, container, false)
    }

}
