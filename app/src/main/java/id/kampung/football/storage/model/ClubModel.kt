package id.kampung.football.storage.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClubModel(val name: String?, val image: Int?, val desc: String?) : Parcelable