package dominio.proprio.ecommerceapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import dominio.proprio.ecommerceapp.database.ItemsDao
import dominio.proprio.ecommerceapp.R
import dominio.proprio.ecommerceapp.databinding.FragmentRegisterBinding
import dominio.proprio.ecommerceapp.model.Item

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater)
        setupButtonSave()
        setupButtonBackToHome()
        return binding.root
    }

    private fun setupButtonSave() {
        binding.buttonSave.setOnClickListener {
            ItemsDao.items.add(getItem())
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }
    }

    private fun setupButtonBackToHome() {
        binding.buttonBackHome.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }
    }

    private fun getItem(): Item = with(binding) {
        Item(
            title = editTextTitle.text.toString(),
            description = editTextDescription.text.toString(),
            price = editTextPrice.getDouble(),
            image = editTextImageUrl.text.toString()
        )
    }

    fun EditText.getDouble(): Double = this.text.toString().toDouble()

}