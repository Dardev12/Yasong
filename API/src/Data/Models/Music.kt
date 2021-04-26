
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import java.sql.Time
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object Music : Table("music") {
    val tag = integer("Tag_Music").primaryKey().autoIncrement()
    val title = varchar("Title", length = 50)
    val artist = varchar("Artist", length = 50)
    val duration = varchar("Duration",length = 50)
    val tagU = integer("TAG_USER").uniqueIndex().references(User.tag)


}
data class Musics(
    val tag:Int,
    val title:String,
    val artist:String,
    val duration: String,
    val tagU:Int
)