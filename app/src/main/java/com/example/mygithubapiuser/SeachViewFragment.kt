package com.example.mygithubapiuser

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygithubapiuser.api.ApiConfig
import com.example.mygithubapiuser.databinding.FragmentSeachViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeachViewFragment : Fragment() {
    private var _binding : FragmentSeachViewBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeachViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        (activity as AppCompatActivity).supportActionBar?.title = "Github User Search"

        showLoading(true)

        val searchUser: android.widget.SearchView = view.findViewById(R.id.search_user)
        searchUser.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return if (p0 != null) {
                    showLoading(true)
                    listAllUser(p0)
                    viewModel.username_id = p0
                    searchUser.clearFocus()
                    true
                } else {
                    false
                }
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })

        val layoutManager = LinearLayoutManager(activity)
        binding.userListRv.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.userListRv.addItemDecoration(itemDecoration)

        listAllUser(viewModel.username_id)
    }

    private fun showLoading(isLoading : Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun listAllUser(query : String) {
        val client = ApiConfig.getApiService().searchUser(query)
        client.enqueue(object : Callback<UserSearchResponse>{
            override fun onResponse(
                call: Call<UserSearchResponse>,
                response: Response<UserSearchResponse>
            ) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val listUser: List<ItemsItem> = responseBody.items as List<ItemsItem>
                        val adapter = UserListAdapter(listUser, true)
                        binding.userListRv.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<UserSearchResponse>, t: Throwable) {
                showLoading(false)
                Log.e("MainActivity", "onFailure: ${t.message}")
            }
        })
    }
}