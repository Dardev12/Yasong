
import com.dardev.Data.Interface.IMusicDAO
import com.google.gson.Gson
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class MusicDAO(private val db:Database):IMusicDAO {
    override fun init() = transaction(db){
            SchemaUtils.create(Music,User)
    }

    override fun addMusic(music: Musics){
            transaction {
                Music.insert {
                    it[title]= music.title ?:""
                    it[artist]=music.artist?:""
                    it[duration]=music.duration?:""
                    it[tagU]=music.tagU?:0

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
        var aMusic=Musics(null,null,null,null,null)
          transaction{
              val res= Music.select {Music.title eq titre}
                  .withDistinct().map{
                  aMusic=Musics(it[Music.tag],it[Music.title],it[Music.artist],it[Music.duration],it[Music.tagU])
              }
              json=Gson().toJson(aMusic)
          }
        return json

    }

    override fun getByArtiste(artiste: String): String {
        var json:String=""
        var aMusic=Musics(null,null,null,null,null)
        transaction {
            Music.select{Music.artist eq artiste}
                .withDistinct().map {
                    aMusic=Musics(it[Music.tag],it[Music.title],it[Music.artist],it[Music.duration],it[Music.tagU])
            }
            json=Gson().toJson(aMusic)
        }
        return json
    }

    override fun getById(tag: Int): String {
        var json:String=""
        var aMusic=Musics(null,null,null,null,null)
        transaction {
            val res=Music.select{Music.tag eq tag}.withDistinct().map {
                aMusic=Musics(it[Music.tag],it[Music.title],it[Music.artist],it[Music.duration],it[Music.tagU])

            }
            json=Gson().toJson(aMusic)
        }
        return json
    }

    override fun getAll(): String {
        var listjson:String=""
        transaction{
            val listmusic = ArrayList<Musics>()
            for(aMusic in Music.selectAll()){
                listmusic.add(Musics( tag = aMusic[Music.tag],title = aMusic[Music.title],artist =aMusic[Music.artist],duration =aMusic[Music.duration],tagU = aMusic[Music.tagU] ))
            }
            listjson=Gson().toJson(listmusic)
        }
       return listjson
    }



    override fun close() {}
}


