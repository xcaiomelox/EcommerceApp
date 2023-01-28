package dominio.proprio.ecommerceapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dominio.proprio.ecommerceapp.databinding.ItemBinding
import dominio.proprio.ecommerceapp.model.Item

class Adapter (
    itemsList: List<Item>
): RecyclerView.Adapter<Adapter.ItemViewHolder>(){

    private val itemsList = itemsList.toMutableList()

    class ItemViewHolder (val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemsList[position]
        with (holder.binding){
            Glide.with(itemImageView).load(currentItem.image).into(itemImageView)
            textViewTitle.text = currentItem.title
            textViewDescription.text = currentItem.description
            textViewPrice.text = currentItem.price.toString()
        }

    }

    override fun getItemCount() = itemsList.size

}
