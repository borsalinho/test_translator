package com.kaspersky.translator.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.kaspersky.domain.model.WordQuerry
import com.kaspersky.translator.app.App
import com.kaspersky.translator.databinding.FragmentHomeBinding
import com.kaspersky.translator.view_model.MyViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var homeViewModel: MyViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
        //---------------------------------------------------------------






        //---------------------------------------------------------------
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textHome
        homeViewModel.text_1.observe(viewLifecycleOwner) {
            textView.text = it
        }
        //---------------------------------------------------------------
        val textEnter = binding.textEnter
        val btnTranslate = binding.btnTranslate
        val textResult = binding.textResult
        val recyclerView = binding.recyclerView


        btnTranslate.setOnClickListener {
            val query = textEnter.text.toString().trim()

            if (!HomeFragmentValidator(query)){
                Toast.makeText(context, "Введите ОДНО английское слово", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                var translte =  homeViewModel.sendWord(WordQuerry(query))
                println("я тест")
                println(translte.responce)
                withContext(Dispatchers.Main) {
                    textResult.text = translte.responce
                }
            }

        }



        //---------------------------------------------------------------
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun HomeFragmentValidator(query : String) : Boolean {
        if (query.isEmpty() || !query.matches(Regex("^[a-zA-Z]+$"))) {
            return false
        }
        return true
    }
}