import com.fasterxml.jackson.annotation.JsonInclude
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Users(
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    val tag:Int?,
    val lastName:String?,
    val firstName:String?,
    val email:String?,
    val gender:String?,
    val password:String?
)

object User : Table("user"){
    val tag=integer("TAG_USER").primaryKey().autoIncrement()
    val lastName=varchar("Lastname",50)
    val firstName=varchar("Firstname",50)
    val email=varchar("Email",1)
    val gender=  varchar("Gender",1)
    val password=varchar("Password",50)
}