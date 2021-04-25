import com.dardev.Data.Interface.IMusicDAO

class MusicDAO:IMusicDAO {
    val listMusic=mutableListOf<Musics>()

    override fun addMusic(music: Music): Music {
        TODO("Not yet implemented")
    }

    override fun updateMusic(tag: Int, music: Music): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeMusic(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByTitle(titre: String): Music {
        TODO("Not yet implemented")
    }

    override fun getByArtiste(artiste: String): Music {
        TODO("Not yet implemented")
    }

    override fun getById(tag: Int): Music {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Music> {
        TODO("Not yet implemented")
    }
}