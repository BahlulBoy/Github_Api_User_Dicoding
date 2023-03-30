package com.example.mygithubapiuser

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.mygithubapiuser.api.ApiConfig
import com.example.mygithubapiuser.databinding.ActivityDetailUserBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var username: String

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab1,
            R.string.tab2
        )
        const val USERNAME = "username"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showLoading(true)

        supportActionBar?.title = "User Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        username = intent.getStringExtra(USERNAME).toString()

        val sectionPageAdapter = SectionPageAdapter(this, username)
        val viewPager : ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPageAdapter
        val tabs : TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) {
            tab, position -> tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        findUser(username)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = NavUtils.getParentActivityIntent(this)
                intent?.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                NavUtils.navigateUpTo(this, intent ?: return true)
                true
            }
            else -> {
                super.onContextItemSelected(item)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun findUser(username: String) {
        val client = ApiConfig.getApiService().getUser(username)
        client.enqueue(object : Callback<UserDetail>{
            override fun onResponse(call: Call<UserDetail>, response: Response<UserDetail>) {
                if (response.isSuccessful) {
                    showLoading(false)
                    val responseBody = response.body()
                    if (responseBody != null) {
                        binding.tvUsername.text = responseBody.login
                        binding.name.text = responseBody.name
                        binding.followerTv.text = "${responseBody.followers.toString()} Follower"
                        binding.followingTv.text = "${responseBody.following.toString()} Following"
                        Glide.with(this@DetailUserActivity)
                            .load(responseBody.avatarUrl)
                            .into(binding.imageView)
                    }
                }
            }

            override fun onFailure(call: Call<UserDetail>, t: Throwable) {
                showLoading(false)
                Log.e("MainActivity", "onFailure: ${t.message}")
            }
        })
    }
}