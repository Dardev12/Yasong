
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
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
@Serializable
data class Musics(
    val tag:Int?,
    @JsonInclude(value=JsonInclude.Include.NON_NULL)
    val title:String?,
    val artist:String?,
    val duration: String?,
    val tagU:Int?
)