package dominio.proprio.ecommerceapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dominio.proprio.ecommerceapp.R
import dominio.proprio.ecommerceapp.adapter.Adapter
import dominio.proprio.ecommerceapp.database.AppDataBase
import dominio.proprio.ecommerceapp.databinding.FragmentHomeBinding
import dominio.proprio.ecommerceapp.model.Item

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val dao by lazy {
        AppDataBase.instance(context).itemsDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        setupRecyclerView(dao.getAll())
        setFloattingActionButton()

        return binding.root
    }

    private fun setupRecyclerView(itemList: List<Item>) {
        val recyclerView = binding.homeRecyclerView
        var itemAdapter = Adapter(
            itemsList = itemList,
            onItemClicked = {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsProductFragment(it)
                findNavController().navigate(action)
            }
            )
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setFloattingActionButton() {
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
        }
    }

}