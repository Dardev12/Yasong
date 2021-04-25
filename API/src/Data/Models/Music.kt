import kotlinx.serialization.Serializable
import org.ktorm.schema.*
import java.time.LocalTime

@Serializable
data class Music(
    val tag:Int,
    val title:String,
    val artist:String,
    val duration: LocalTime,
    val tagU:Int
)
object Musics: Table<Nothing>("Music"){
    val tag=int("TAG_Music").primaryKey()
    val title=varchar("Title")
    val artist=varchar("Artiste")
    val duration= time("Duration")
    val tagU=int("TAG_USER")


}