package edu.nku.classapp.data.remote

import edu.nku.classapp.data.model.Character
import edu.nku.classapp.data.model.Location
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null
    ): PagedResponse<Character>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character

    @GET("location")
    suspend fun getLocations(@Query("page") page: Int): PagedResponse<Location>

    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int): PagedResponse<Episode>
}

data class PagedResponse<T>(
    val info: PageInfo,
    val results: List<T>
)

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class Episode(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
) 