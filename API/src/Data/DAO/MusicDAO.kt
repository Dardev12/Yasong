
import com.dardev.Data.Interface.IMusicDAO
import com.google.gson.Gson
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class MusicDAO:IMusicDAO {
    private var listMusic= ArrayList<Musics>()

    override fun addMusic(music: Music): Music {
        TODO("Not yet implemented")
    }

    override fun updateMusic(tag: Int, music: Music): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeMusic(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByTitle(titre: String): String {
        var json:String=""
        transaction{
            val res= Music.selectAll()
            val c=listMusic
            for(m in res){
                c.add(Musics(tag=m[Music.tag],title=m[Music.title],artist = m[Music.artist],duration=m[Music.duration],tagU = m[Music.tagU]))
            }
            json=Gson().toJson(c)
        }
        return json
    }

    override fun getByArtiste(artiste: String): Music {
        TODO("Not yet implemented")
    }

    override fun getById(tag: Int): Music {
        TODO("Not yet implemented")
    }

    override fun getAll(): ArrayList<Musics> {
        transaction{
            Music.selectAll().map {
                listMusic.add(
                    Musics(
                        tag=it[Music.tag],
                        title=it[Music.title],
                        artist = it[Music.artist],
                        duration=it[Music.duration],
                        tagU = it[Music.tagU]
                    )
                )
            }
        }
        return listMusic
    }
}


