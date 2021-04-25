import com.dardev.Data.Interface.IPlaylistDAO

class PlaylistDAO:IPlaylistDAO {
    val listPlaylist= mutableListOf<Playlists>()

    override fun addPlaylist(playlist: Playlist): Playlist {
        TODO("Not yet implemented")
    }
    override fun removePlaylist(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeMusicP(tagM: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByString(title: String): Playlist {
        TODO("Not yet implemented")
    }
    override fun getById(tag: Int): Playlist {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Playlist> {
        TODO("Not yet implemented")
    }

}