
import com.dardev.Data.Interface.IMusicDAO
import com.google.gson.Gson
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.lang.Exception

class MusicDAO(private val db:Database):IMusicDAO {
    override fun init() = transaction(db){
            SchemaUtils.create(Music,User)
    }

    override fun addMusic(music: Musics){

            transaction {
                Music.insert {
                    it[title]=music.title
                    it[artist]=music.artist
                    it[duration]=music.duration
                    it[tagU]=music.tagU

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
            var json:String=""
          transaction{
              val res= Music.select {Music.title eq titre}.single()[Music.title]
              json=Gson().toJson(res)
          }
        return json

    }

    override fun getByArtiste(artiste: String): String {
        TODO("Not yet implemented")
    }

    override fun getById(tag: Int): String {
        TODO("Not yet implemented")
    }

    override fun getAll(): String {
        var listjson:String=""
        transaction{
            val listmusic = ArrayList<Musics>()
            for(aMusic in Music.selectAll()){
                listmusic.add(Musics( tag = aMusic[Music.tag],title = aMusic[Music.title],artist =aMusic[Music.artist],duration =aMusic[Music.duration],tagU = aMusic[Music.tagU]  ))
            }
            listjson=Gson().toJson(listmusic)
        }
       return listjson

    }



    override fun close() {}
}


