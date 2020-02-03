package com.triputranto.jetpackdicoding.ui.home.favorite

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.utils.Utils.Companion.IMAGE_URL
import com.triputranto.jetpackdicoding.utils.createCircularProgressDrawable
import com.triputranto.jetpackdicoding.utils.inflate
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class FavoriteAdapter(private val listener: (Int) -> Unit) :
    PagedListAdapter<Entity, FavoriteAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_list))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position), listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Entity?, listener: (Int) -> Unit) = with(itemView) {
            if (item?.title != null) movies_title.text = item.title
            else movies_title.text = item?.name

            Glide.with(context)
                .load(IMAGE_URL + item?.poster_path)
                .thumbnail(0.2f)
                .placeholder(createCircularProgressDrawable(context))
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_broken_image_green)
                .into(movies_poster)

            val rating = item?.vote_average?.div(2)
            if (rating != null) movies_rating.rating = rating.toFloat()

            setAnimation(itemView, context)
            setOnClickListener { listener(item?.id ?: 0) }
        }

        private fun setAnimation(viewToAnimate: View, context: Context) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Entity>() {
            override fun areItemsTheSame(oldFavorite: Entity, newFavorite: Entity) =
                oldFavorite.idMovie == newFavorite.idMovie

            override fun areContentsTheSame(oldFavorite: Entity, newFavorite: Entity) =
                oldFavorite == newFavorite
        }
    }
}