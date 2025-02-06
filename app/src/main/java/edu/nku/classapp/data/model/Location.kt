package edu.nku.classapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = "locations",
    indices = [Index("locationId")]
)
data class Location(
    @PrimaryKey val locationId: Int,
    val name: String,
    val url: String,
    val type: String = "",
    val dimension: String = ""
) : Parcelable 