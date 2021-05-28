import com.fasterxml.jackson.annotation.JsonInclude
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object User : Table(){
    val tag:Column<Int> =integer("TAG_USER").autoIncrement()
    val lastName:Column<String> =varchar("Lastname",50)
    val firstName:Column<String> =varchar("Firstname",50)
    val email:Column<String> =varchar("Email",1)
    val gender:Column<String> =  varchar("Gender",1)
    val password:Column<String> =varchar("Password",50)

    override val primaryKey=PrimaryKey(tag,name="User_PK")
}

@Serializable
data class Users(
    val tag:Int?=null,
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    val lastName:String?="",
    val firstName:String?="",
    val email:String?="",
    val gender:String?="",
    val password:String?=""
)

