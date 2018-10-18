package id.kampung.football.view.main

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.kampung.football.R
import id.kampung.football.adapter.ListFootballAdapter
import id.kampung.football.storage.model.ClubModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private var items: MutableList<ClubModel> = mutableListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        initData()
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            relativeLayout{
                lparams(matchParent, matchParent)
                recyclerView {
                    layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                    adapter = ListFootballAdapter(context, items)
                }.lparams(matchParent, wrapContent)

            }
        }
    }
    @SuppressLint("Recycle")
    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.image_club)
        val desc = resources.getStringArray(R.array.desc_club)
        items.clear()
        for (i in name.indices) {
            items.add(ClubModel(name[i],
                    image.getResourceId(i, 0),desc[i]))
        }
    }
}
