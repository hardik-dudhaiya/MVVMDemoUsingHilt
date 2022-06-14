package com.mind.minddemomvvm.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.mind.minddemomvvm.R
import com.mind.minddemomvvm.data.models.data.MemesItem
import com.mind.minddemomvvm.databinding.FragmentDetailBinding
import com.mind.minddemomvvm.databinding.FragmentHomeBinding


class DetailFragment : Fragment() {

    val detailViewModel : DetailViewModel by viewModels()
    lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val detail =  arguments?.getString("detail")

        detail.let {
            detailViewModel.setMemeDetail(Gson().fromJson(it,MemesItem::class.java))
        }
        binding.memesDetail = detailViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}