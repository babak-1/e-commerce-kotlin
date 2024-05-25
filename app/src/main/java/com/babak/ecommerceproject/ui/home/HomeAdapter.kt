package com.babak.ecommerceproject.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babak.ecommerceproject.databinding.CardItemBinding
import com.babak.ecommerceproject.model.ProductsResponseItem

class HomeAdapter:RecyclerView.Adapter<HomeAdapter.CardViewHolder>(){
    private val list = arrayListOf<ProductsResponseItem>()

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

    }


    fun updateList(newList:List<ProductsResponseItem>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}