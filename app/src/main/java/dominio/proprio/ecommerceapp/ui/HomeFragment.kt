package dominio.proprio.ecommerceapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dominio.proprio.ecommerceapp.database.ItemsDao
import dominio.proprio.ecommerceapp.R
import dominio.proprio.ecommerceapp.adapter.Adapter
import dominio.proprio.ecommerceapp.databinding.FragmentHomeBinding
import dominio.proprio.ecommerceapp.model.Item

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        setupRecyclerView(itemList = ItemsDao.items)
        setFloattingActionButton()
        return binding.root
    }

    private fun setupRecyclerView(itemList: List<Item>) {

        val recyclerView = binding.homeRecyclerView
        recyclerView.adapter = Adapter(itemList)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun getMockedItemList() = listOf(
        Item("Geladeira   ", "Ta maluca, apitando aleatóriamente", 15.69, ""),
        Item("Armario", "Gaveta fodida, porém estético", 56.59, ""),
        Item("Armário de cozinha", "Ta com cupim", 80.70, "")
    )

    private fun setFloattingActionButton() {
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
        }
    }

}