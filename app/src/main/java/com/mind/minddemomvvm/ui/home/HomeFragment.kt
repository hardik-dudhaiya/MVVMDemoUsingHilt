package com.mind.minddemomvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mind.minddemomvvm.databinding.FragmentHomeBinding
import com.mind.minddemomvvm.ui.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"

    lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var memesAdapter: MemesAdapter

    val viewModel: HomeViewModel by viewModels()

    lateinit var homeActivity: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)

        homeActivity = activity as HomeActivity

        val layoutManager = LinearLayoutManager(context)


        // at last set adapter to recycler view.
        binding.rvMemesList.layoutManager = layoutManager
        binding.rvMemesList.adapter = memesAdapter



        loadMemes()

        return binding.root
    }

    private fun loadMemes() {
        homeActivity.showProgress()

        viewModel.getMemes().observe(viewLifecycleOwner, Observer {
            memesAdapter.submitList(it)

            homeActivity.hideProgress()
           /* when (it) {
                is ResponseHandler.Loading -> {
                    Log.e(TAG, "Loading...")

                }
                is ResponseHandler.Success -> {
                    Log.e(TAG, "Success...")
                    homeActivity.hideProgress()

                    val memesList = it.data?.data?.memesList

                    memesAdapter.submitList(it)
                }
                is ResponseHandler.Error -> {
                    Toast.makeText(activity, it.errorMessage, Toast.LENGTH_SHORT).show()
                    homeActivity.hideProgress()
                    Log.e(TAG, "Error == ${it.errorMessage}")
                }
            }*/


        })
    }
}