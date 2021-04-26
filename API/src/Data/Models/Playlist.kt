
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table


@Serializable
data class Playlists(
    val tagPlaylist:Int,
    val tagUser:Int,
    val tagMusic:Int
)

object Playlist: Table("Playlist"){

    val tagPlaylist = integer("TAG_PLAYLIST").primaryKey()
    val tagUser=integer("TAG_USER").uniqueIndex().references(User.tag)
    val tagMusic=integer("TAG_Music").uniqueIndex().references(Music.tag)
}
