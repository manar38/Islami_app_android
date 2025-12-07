package com.example.islami_app.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami_app.databinding.FragmentHadithBinding

class HadithFragment: Fragment() {
    lateinit var viewBinding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentHadithBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}