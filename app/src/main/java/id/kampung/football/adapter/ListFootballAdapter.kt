package id.kampung.football.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import id.kampung.football.R
import id.kampung.football.storage.model.ClubModel
import id.kampung.football.view.detailFootball.DetailActivity
import kotlinx.android.synthetic.main.club_list.view.*
import org.jetbrains.anko.startActivity

class ListFootballAdapter(val context: Context, private val list: List<ClubModel>) : RecyclerView.Adapter<ListFootballAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.club_list,p0, false))

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {

        val item  = list[i]
        holder.name.text = item.name
        Glide.with(context).load(item.image).into(holder.image)

        holder.itemView.setOnClickListener {
            context.startActivity<DetailActivity>("data" to item)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       var name: TextView = itemView.name
        var image: ImageView = itemView.image

    }

}