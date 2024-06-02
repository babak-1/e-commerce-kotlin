package com.babak.ecommerceproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babak.ecommerceproject.databinding.CardItemBinding
import com.babak.ecommerceproject.model.ProductsResponseItem
import com.babak.ecommerceproject.utils.imageLoad

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.CardViewHolder>(){
    private val list = arrayListOf<ProductsResponseItem>()
    lateinit var onClickProduct:(String)->Unit

    inner class CardViewHolder(var cardItemBinding: CardItemBinding):RecyclerView.ViewHolder(cardItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view=CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        var item=list[position]
        holder.cardItemBinding.productTitle.text=item.title
        holder.cardItemBinding.productImage.imageLoad(item.images?.get(0) ?:"")
        holder.cardItemBinding.productsPrice.text ="${item.price.toString()}$"
        holder.cardItemBinding.productsCategory.text=item.category?.name
        holder.cardItemBinding.cardView.setOnClickListener {
            onClickProduct(item.id.toString())
        }
    }


    fun updateList(newList:List<ProductsResponseItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}