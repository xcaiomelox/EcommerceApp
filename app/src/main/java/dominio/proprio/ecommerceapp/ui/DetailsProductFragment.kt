package dominio.proprio.ecommerceapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dominio.proprio.ecommerceapp.R
import dominio.proprio.ecommerceapp.databinding.FragmentDetailsProductBinding
import dominio.proprio.ecommerceapp.model.Item

class DetailsProductFragment : Fragment() {

    private lateinit var binding: FragmentDetailsProductBinding
    val args: DetailsProductFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsProductBinding.inflate(inflater)
        fillFields(args.itemdata)
        setupGoBackButton()
        return binding.root
    }

    private fun fillFields(loadedProduct: Item){
        with(binding){
            Glide.with(imageViewDetailProduct).load(loadedProduct.image).into(imageViewDetailProduct)
            textViewTitleDetailProduct.text = loadedProduct.title
            textviewDescriptionDetailProduct.text = loadedProduct.description
            textviewPriceDetailProduct.text = loadedProduct.price.toString()

        }
    }

    private fun setupGoBackButton(){
        binding.buttonGoHome.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}