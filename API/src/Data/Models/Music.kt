import com.dardev.Configuration.JsonObjectSerializer
import kotlinx.serialization.*
import org.jetbrains.exposed.sql.Table
import com.fasterxml.jackson.annotation.JsonInclude
import io.ktor.client.features.json.*
import kotlinx.serialization.json.JsonObject

import org.jetbrains.exposed.sql.Column


object Music : Table() {

    val tag:Column<Int> = integer("Tag_Music").autoIncrement()
    val title:Column<String> = varchar("Title", length = 50)
    val artist:Column<String> = varchar("Artist", length = 50)
    val duration:Column<String> = varchar("Duration",length = 50)
    val tagU:Column<Int> = integer("TAG_USER").uniqueIndex().references(User.tag)

    override val primaryKey=PrimaryKey(tag,name="Music_PK")

}

@Serializable
data class Musics(
    val tag:Int? =null,
    @JsonInclude(value=JsonInclude.Include.NON_NULL)
    val title:String?="",
    val artist:String?="",
    val duration: String?="",
    val tagU:Int? =null
   /* @Serializable(JsonObjectSerializer::class)
    val unknown: JsonObject? = null*/
)

class WrapperMusic(val ymusic:Musics)

//class aMusic(tag: EntityID<Int>):IntEntity(tag){
//    companion object : IntEntityClass<aMusic>(Music)
//    var tag by Music.tag
//    var title by Music.title
//    var artist by Music.artist
//    var duration by Music.duration
//    var tagU by Music.tagU
//}