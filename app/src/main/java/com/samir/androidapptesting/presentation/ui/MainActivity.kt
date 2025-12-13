package com.samir.androidapptesting.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.internal.EdgeToEdgeUtils
import com.google.android.material.internal.EdgeToEdgeUtils.applyEdgeToEdge
import com.samir.androidapptesting.data.NetworkState
import com.samir.androidapptesting.data.models.User
import com.samir.androidapptesting.databinding.ActivityMainBinding
import com.samir.androidapptesting.presentation.adapters.UserAdapter
import com.samir.androidapptesting.presentation.viewmodels.UserViewModel
import com.samir.androidapptesting.presentation.extensions.hide
import com.samir.androidapptesting.presentation.extensions.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        bind()
        observerData()
    }

    private fun bind() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        title = "User Listing Page"
        ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    private fun observerData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                userViewModel.users.collect { state ->

                    when (state) {
                        is NetworkState.Loading -> {
                            binding.progressBar.show()
                        }

                        is NetworkState.Success -> {
                            binding.progressBar.hide()
                            binding.recyclerView.show()
                            binding.errorText.hide()
                            setData(state.data)
                        }

                        is NetworkState.Error -> {
                            binding.progressBar.hide()
                            binding.errorText.text = state.message
                            binding.errorText.show()
                        }
                    }

                }
            }
        }
    }

    private fun setData(data: List<User?>?) {
        binding.recyclerView.adapter = UserAdapter(data)
    }

}