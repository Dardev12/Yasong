import kotlinx.serialization.Serializable
import org.ktorm.schema.*

@Serializable
data class User(
    val tag:Int,
    val lastName:String,
    val firstName:String,
    val email:String,
    val gender:String,
    val password:String
)

object Users : Table<Nothing>("User"){
    val tag=int("").primaryKey()
    val lastName=varchar("")
    val firstName=varchar("")
    val email=varchar("")
    val gender=  varchar("")
}