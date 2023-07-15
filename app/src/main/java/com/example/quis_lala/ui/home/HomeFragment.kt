package com.example.quis_lala.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quis_lala.R
import com.example.quis_lala.adapter.AdapterObat
import com.example.quis_lala.app.ApiConfig
import com.example.quis_lala.databinding.FragmentHomeBinding
import com.example.quis_lala.model.ObatModel
import com.example.quis_lala.model.ResponModel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var rvobat: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getObat()
        return view
    }

    private var listObat: ArrayList<ObatModel> = ArrayList()

    fun getObat(){
        ApiConfig.instanceRetrofit.getObat().enqueue(object :
            retrofit2.Callback<ResponModel> {

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                listObat = res.obat
                displayObat()
            }
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayObat() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvobat.adapter = AdapterObat(requireActivity(), listObat)
        rvobat.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvobat=view.findViewById(R.id.recyler_view)
    }

}
