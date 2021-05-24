import com.dardev.Data.Interface.IPlaylistDAO

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class PlaylistDAO(private val db:Database):IPlaylistDAO {
    override fun init() = transaction(db){
        SchemaUtils.create(User,Playlist,Music)
    }

    override fun addPlaylist(playlist: Playlist) {
        TODO("Not yet implemented")
    }
    override fun removePlaylist(tag: Int){
        transaction {
            Playlist.deleteWhere { Playlist.tagPlaylist eq tag }
        }
    }

    override fun removeMusicP(tagP:Int,tagM: Int) {
        transaction {
            Playlist.deleteWhere { Playlist.tagPlaylist eq tagP and (Playlist.tagMusic eq tagM) }
        }
    }

    override fun getByString(title: String): String {
        var json:String=""
        var playlists:Playlists
        transaction {

        }
        return json
    }
    override fun getById(tag: Int,tagM:Int): String {
        var json:String=""
        var playlists=Playlists(null,null,null)
        transaction {
            Playlist.select { Playlist.tagPlaylist eq tag }.andWhere { Playlist.tagUser eq tagM }
                .withDistinct().map {
                    playlists=Playlists(it[Playlist.tagPlaylist],it[Playlist.tagUser],it[Playlist.tagMusic])
                }
            json= Json.encodeToString(playlists)
        }
        return json
    }

    override fun getAll(): String {
        var jason:String=""
        transaction {
            val listPlaylists=ArrayList<Playlists>()
            for (aPlaylists in Playlist.selectAll()){
                listPlaylists.add(Playlists(aPlaylists[Playlist.tagPlaylist],aPlaylists[Playlist.tagUser],aPlaylists[Playlist.tagMusic]))
            }
            jason=Json.encodeToString(listPlaylists)
        }
        return jason
    }
    override fun close() {}
}