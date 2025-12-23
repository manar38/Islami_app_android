package com.example.islami_app.home.tabs.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islami_app.databinding.FragmentHadithBinding
import com.example.islami_app.model.Hadeth
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.CarouselStrategy
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy

class   HadithFragment: Fragment() {
    lateinit var viewBinding: FragmentHadithBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentHadithBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
    val hadethList: MutableList<Hadeth> = mutableListOf()
    lateinit var adapter: HadethCaroselAdapter
    lateinit var layoutManager: CarouselLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readhadithFile()
        initHadethRecycler()
    }

    private fun initHadethRecycler() {
         adapter= HadethCaroselAdapter(hadethList)
        layoutManager= CarouselLayoutManager(
            FullScreenCarouselStrategy(),
            CarouselLayoutManager.HORIZONTAL,
        )
        layoutManager.carouselAlignment= CarouselLayoutManager.ALIGNMENT_CENTER
        viewBinding.hadithRecyclerView.adapter=adapter
        viewBinding.hadithRecyclerView.layoutManager=layoutManager

        val snapHelper= CarouselSnapHelper()
        snapHelper.attachToRecyclerView(viewBinding.hadithRecyclerView)

    }

    fun readhadithFile(){
        val fileContent=activity?.assets?.open("hadeth/ahadeth.txt")?.bufferedReader()
            .use{it?.readText()}
        if (fileContent==null) return

        val hadethlinesList=fileContent.trim()
            .split("#")
        hadethlinesList.forEach { singleHadeth->
            val lines=singleHadeth.trim().split("\n")
            val title=lines[0]
            val content=lines.takeLast(lines.size-1).joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }



        }
    }
