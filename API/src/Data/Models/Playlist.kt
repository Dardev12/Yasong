
import com.fasterxml.jackson.annotation.JsonInclude
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table


@Serializable
data class Playlists(
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    val tagPlaylist:Int?,
    val tagUser:Int?,
    val tagMusic:Int?
)

object Playlist: Table(){

    val tagPlaylist:Column<Int> = integer("TAG_PLAYLIST").autoIncrement()
    val tagUser: Column<Int> =integer("TAG_USER").uniqueIndex().references(User.tag)
    val tagMusic:Column<Int> =integer("TAG_Music").uniqueIndex().references(Music.tag)

    override val primaryKey=PrimaryKey(tagPlaylist,name="Playlist_PK ")
}
