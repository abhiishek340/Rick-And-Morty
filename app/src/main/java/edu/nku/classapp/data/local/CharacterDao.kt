package edu.nku.classapp.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import edu.nku.classapp.data.model.Character
import edu.nku.classapp.data.model.CharacterWithLocations
import edu.nku.classapp.data.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Transaction
    @Query("SELECT * FROM characters ORDER BY name ASC")
    fun getAllCharactersPaged(): PagingSource<Int, CharacterWithLocations>

    @Transaction
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<CharacterWithLocations>>

    @Transaction
    @Query("SELECT * FROM characters WHERE isFavorite = 1")
    fun getFavoriteCharacters(): Flow<List<CharacterWithLocations>>

    @Transaction
    @Query("SELECT * FROM characters WHERE id = :id")
    fun getCharacterById(id: Int): Flow<CharacterWithLocations>

    @Transaction
    @Query("SELECT * FROM characters WHERE name LIKE '%' || :query || '%'")
    fun searchCharacters(query: String): Flow<List<CharacterWithLocations>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<Character>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(locations: List<Location>)

    @Update
    suspend fun updateCharacter(character: Character)

    @Query("UPDATE characters SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean)

    @Query("DELETE FROM characters")
    suspend fun clearAllCharacters()

    @Query("DELETE FROM locations")
    suspend fun clearAllLocations()

    @Transaction
    suspend fun refreshCharacters(characters: List<Character>, locations: List<Location>) {
        clearAllCharacters()
        clearAllLocations()
        insertLocations(locations)
        insertCharacters(characters)
    }

    @Query("SELECT COUNT(*) FROM characters")
    suspend fun getCharacterCount(): Int
} 