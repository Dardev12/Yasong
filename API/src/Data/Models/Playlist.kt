
import org.ktorm.schema.Table
import org.ktorm.schema.int

data class Playlist(
    val tagPlaylist:Int,
    val tagUser:Int,
    val tagMusic:Int
)

object Playlists:Table<Nothing>("Playlist"){

    val tagPlaylist = int("TAG_PLAYLIST").primaryKey()
    val tagUser=int("TAG_USER")
    val tagMusic=int("TAG_Music")
}
