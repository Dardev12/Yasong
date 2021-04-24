import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

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