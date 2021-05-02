import com.dardev.Data.Interface.IPlaylistDAO
import com.google.gson.Gson
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class PlaylistDAO(private val db:Database):IPlaylistDAO {
    override fun init() = transaction(db){
        SchemaUtils.create(User,Playlist,Music)
    }

    override fun addPlaylist(playlist: Playlist) {
        TODO("Not yet implemented")
    }
    override fun removePlaylist(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeMusicP(tagM: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByString(title: String): String {
        var jason:String=""
        var playlists:Playlists
        transaction {

        }
        return jason
    }
    override fun getById(tag: Int,tagM:Int): String {
        var jason:String=""
        var playlists=Playlists(null,null,null)
        transaction {
            Playlist.select { Playlist.tagPlaylist eq tag }.andWhere { Playlist.tagUser eq tagM }
                .withDistinct().map {
                    playlists=Playlists(it[Playlist.tagPlaylist],it[Playlist.tagUser],it[Playlist.tagMusic])
                }
            jason=Gson().toJson(playlists)
        }
        return jason
    }

    override fun getAll(): String {
        var jason:String=""
        transaction {
            val listPlaylists=ArrayList<Playlists>()
            for (aPlaylists in Playlist.selectAll()){
                listPlaylists.add(Playlists(aPlaylists[Playlist.tagPlaylist],aPlaylists[Playlist.tagUser],aPlaylists[Playlist.tagMusic]))
            }
            jason=Gson().toJson(listPlaylists)
        }
        return jason
    }
    override fun close() {}
}