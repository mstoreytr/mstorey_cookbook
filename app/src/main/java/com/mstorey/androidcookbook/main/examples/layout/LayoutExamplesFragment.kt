package com.mstorey.androidcookbook.main.examples.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mstorey.androidcookbook.R
import com.mstorey.androidcookbook.main.BaseFragment

/**
 * Fragment that holds simple recylerview, adapter, and viewholder
 * Opens layout examples
 */
interface OnItemClickInterface {
    fun onItemClick(item: String?)
}
open class LayoutExamplesFragment: BaseFragment(), OnItemClickInterface {
    override fun onItemClick(item: String?) {
        when(item) {
            resources.getString(R.string.navigation_title) -> {
                val fragmentGraph = NavHostFragment.create(R.navigation.nav_example)
                childFragmentManager.beginTransaction()
                    .replace(R.id.layout_container, fragmentGraph)
                    .setPrimaryNavigationFragment(fragmentGraph)
                    .addToBackStack("nav")
                    .commit()
            }
            else -> return
        }
    }

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: LayoutExampleAdapter
    lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_layout_examples, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerViewLayoutManager = LinearLayoutManager(activity)
        recyclerViewAdapter = LayoutExampleAdapter(getLayoutExamples(), this)

        /*
            the apply function block is used to configure/modify an object and then returning that altered object.
            Instead of
            recyclerView.adapter = foo
            recyclerView.layoutManager  = bar
            I can do the following
         */
        recyclerView = view?.findViewById<RecyclerView>(R.id.layout_example_recylerview)?.apply {
            adapter = recyclerViewAdapter
            layoutManager = recyclerViewLayoutManager
        }!!
    }

    override fun getTitle(): String? {
        //isAdded check unneeded since if activity is null then null is returned.
        return resources.getString(R.string.layout_title)
    }

    override fun getStyle(): Int {
        return R.style.LayoutAppTheme
    }

    private fun getLayoutExamples(): Array<String?> {
        return arrayOf(activity?.resources?.getString(R.string.navigation_title),
            activity?.resources?.getString(R.string.recyclerview_title),
            activity?.resources?.getString(R.string.viewpager_title),
            activity?.resources?.getString(R.string.view_title))
    }

    // In kotlin you can create and assign fields inside of their primary constructor
    class LayoutExampleAdapter(private val myDataset: Array<String?>, var itemClickInterface: OnItemClickInterface) :
        RecyclerView.Adapter<LayoutExampleAdapter.LayoutExampleViewHolder>() {

        class LayoutExampleViewHolder(view: View, val textView: TextView) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): LayoutExampleAdapter.LayoutExampleViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_layout_examples_viewholder, parent, false) as View
            val textView = view.findViewById<TextView>(R.id.layout_example_item)
            return LayoutExampleAdapter.LayoutExampleViewHolder(view, textView)
        }

        override fun onBindViewHolder(holder: LayoutExampleViewHolder, position: Int) {
            with(holder) {
                textView.text = myDataset[position]
                itemView.setOnClickListener {itemClickInterface.onItemClick(myDataset[position])}
            }
        }

        override fun getItemCount() = myDataset.size
    }
}