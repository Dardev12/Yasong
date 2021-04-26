import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import java.sql.Time
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object Music : Table("Music") {
    val tag = integer("TAG_Music")
    val title = varchar("Title", length = 50)
    val artist = varchar("Artiste", length = 50)
    val duration = varchar("Duaration",length = 50)
    val tagU = integer("TAG_USER")


}
@Serializable
data class Musics(
    val tag:Int,
    val title:String,
    val artist:String,
    val duration: String,
    val tagU:Int
)