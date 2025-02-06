package edu.nku.classapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.room.Embedded
import androidx.room.ForeignKey
import androidx.room.Index
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    tableName = "characters",
    foreignKeys = [
        ForeignKey(
            entity = Location::class,
            parentColumns = ["locationId"],
            childColumns = ["originLocationId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Location::class,
            parentColumns = ["locationId"],
            childColumns = ["currentLocationId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("originLocationId"),
        Index("currentLocationId")
    ]
)
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val originLocationId: Long,
    val currentLocationId: Long,
    val created: String,
    var isFavorite: Boolean = false
) : Parcelable

data class CharacterWithLocations(
    @Embedded
    val character: Character,
    
    @Relation(
        parentColumn = "originLocationId",
        entityColumn = "locationId"
    )
    val origin: Location,
    
    @Relation(
        parentColumn = "currentLocationId",
        entityColumn = "locationId"
    )
    val location: Location
) 