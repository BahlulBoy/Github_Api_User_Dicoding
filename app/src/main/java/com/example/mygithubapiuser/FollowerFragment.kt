package com.example.mygithubapiuser

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygithubapiuser.api.ApiConfig
import com.example.mygithubapiuser.databinding.FragmentFollowerBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerFragment : Fragment() {
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    private lateinit var username : String

    companion object {
        const val USER_ID = "username"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)

        arguments?.let {
            username = it.getString(USER_ID).toString()
        }

        val layoutManager = LinearLayoutManager(activity)
        binding.RcFollower.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.RcFollower.addItemDecoration(itemDecoration)
        findFollower(username)

    }

    private fun findFollower(username: String) {
        val client = ApiConfig.getApiService().getFollower(username)
        client.enqueue(object : Callback<List<ItemsItem>> {
            override fun onResponse(
                call: Call<List<ItemsItem>>,
                response: Response<List<ItemsItem>>
            ) {
                if(response.isSuccessful) {
                    showLoading(false)
                    val responseBode = response.body()
                    if (response.body() != null) {
                        val listUser: List<ItemsItem> = responseBode as List<ItemsItem>
                        val adapter = UserListAdapter(listUser, false)
                        binding.RcFollower.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<List<ItemsItem>>, t: Throwable) {
                showLoading(false)
                Log.e("DetailUserActivity", "onFailure: ${t.message}")
            }
        })
    }

    private fun showLoading(isLoading : Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}