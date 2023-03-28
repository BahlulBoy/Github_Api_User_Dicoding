package com.example.mygithubapiuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.mygithubapiuser.databinding.FragmentSeachViewBinding

class SeachViewFragment : Fragment() {
    private var _binding : FragmentSeachViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSeachViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Github User Search"

        val searchUser: SearchView = view.findViewById(R.id.search_user)
        searchUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }
        })
    }

    companion object {

    }
}