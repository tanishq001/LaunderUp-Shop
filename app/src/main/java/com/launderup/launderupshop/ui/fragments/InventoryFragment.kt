package com.launderup.launderupshop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.launderup.launderupshop.R
import com.launderup.launderupshop.ui.adapter.ClothListAdapter
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InventoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InventoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root= inflater.inflate(R.layout.fragment_inventory, container, false)
        val arrayList : ArrayList<String> = getItemsList()
        val recyclerView: RecyclerView =root.findViewById(R.id.inventory_rv)
        val clothListAdapter = context?.let { ClothListAdapter(it,arrayList) }


        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=clothListAdapter

        clothListAdapter!!.setOnItemClickListener(object : ClothListAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
//                val intent=Intent(applicationContext,ClothesListActivity::class.java)
//                startActivity(intent)
            }
        })
        return root
    }

    private fun getItemsList(): ArrayList<String> {
        val list=ArrayList<String>()
        for(i in 1..40){
            list.add("Cloth $i")
        }
        return list
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InventoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InventoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}