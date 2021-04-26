
import com.dardev.Data.Interface.IMusicDAO
import com.google.gson.Gson
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class MusicDAO(private val db:Database):IMusicDAO {
    override fun init() = transaction(db){
            SchemaUtils.create(Music,User)
    }

    override fun addMusic(music: Musics){
        transaction {
            Music.insert {
                it[this.title]=music.title
                it[this.artist]=music.artist

            }
        }
        Unit
    }

    override fun updateMusic(tag: Int, music: Music): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeMusic(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByTitle(titre: String): String {
//        var json:String=""
//        transaction{
//            val res= Music.selectAll()
//            val c=listMusic
//            for(m in res){
//                c.add(Musics(tag=m[Music.tag],title=m[Music.title],artist = m[Music.artist],duration=m[Music.duration],tagU = m[Music.tagU]))
//            }
//            json=Gson().toJson(c)
//        }
        return "json"

    }

    override fun getByArtiste(artiste: String): Music {
        TODO("Not yet implemented")
    }

    override fun getById(tag: Int): Music {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Musics> = transaction(db){
        Music.selectAll().map {
                Musics(
                    it[Music.tag],
                    it[Music.title],
                    it[Music.artist],
                    it[Music.duration],
                    it[Music.tagU]
                )
        }
    }



    override fun close() {}
}


