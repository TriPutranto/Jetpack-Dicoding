package com.triputranto.jetpackdicoding.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadAnimation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.utils.Utils.Companion.IMAGE_URL
import com.triputranto.jetpackdicoding.utils.createCircularProgressDrawable
import com.triputranto.jetpackdicoding.utils.inflate
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class HomeAdapter(private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val results = ArrayList<Entity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.item_list))

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(results[position], listener)

    fun setContentList(data: List<Entity>?) {
        data?.let {
            this.results.apply {
                clear()
                addAll(it)
            }
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Entity, listener: (Int) -> Unit) = with(itemView) {
            if (item.title != null) movies_title.text = item.title
            else movies_title.text = item.name

            Glide.with(context)
                .load(IMAGE_URL + item.poster_path)
                .thumbnail(0.2f)
                .placeholder(createCircularProgressDrawable(context))
                .transition(withCrossFade())
                .error(R.drawable.ic_broken_image_green)
                .into(movies_poster)

            val rating = item.vote_average?.div(2)
            if (rating != null) movies_rating.rating = rating.toFloat()

            setAnimation(itemView, context)
            setOnClickListener { listener(item.id ?: 0) }
        }

        private fun setAnimation(viewToAnimate: View, context: Context) {
            val animation = loadAnimation(context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
        }
    }
}