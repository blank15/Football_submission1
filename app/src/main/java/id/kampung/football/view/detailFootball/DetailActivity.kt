package id.kampung.football.view.detailFootball

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.bumptech.glide.Glide
import id.kampung.football.storage.model.ClubModel

import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {

        private var data: ClubModel? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        data = intent.getParcelableExtra("data")
        DetailActivityUI().setContentView(this)

    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {

            verticalLayout {
                lparams(matchParent, matchParent)
                val img = imageView().
                        lparams(dip(60),dip(60)){
                            gravity = Gravity.CENTER
                            margin = dip(8)
                        }
                val textNama = textView()
                        .lparams(wrapContent, wrapContent){
                            gravity = Gravity.CENTER
                            margin = dip (8)
                        }
                val textDesc = textView()
                        .lparams(wrapContent, wrapContent){
                            gravity = Gravity.CENTER
                            margin = dip(8)
                        }

                textNama.text = data?.name
                textDesc.text = data?.desc
                Glide.with(context).load(data?.image).into(img)

            }

            }
        }
}
