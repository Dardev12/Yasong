import com.dardev.Data.Interface.IUserDAO

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserDAO(private val db:Database) :IUserDAO{
    override fun init() = transaction(db){
        SchemaUtils.create(User)
    }

    override fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun updateUser(tag: Int, aUser: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeUser(tag: Int) {
        transaction {
            User.deleteWhere { User.tag eq tag }
        }
    }

    override fun getById(tag: Int):String {
        var jason:String=""
        var aUser=Users(null,null,null,null,null,null)
        transaction {
            User.select{User.tag eq tag}.withDistinct().map {
                aUser=Users(it[User.tag],it[User.lastName], it[User.firstName],it[User.email],it[User.gender],it[User.password])
            }

            jason= Json.encodeToString(aUser)
        }
        return jason
    }

    override fun getByName(name: String): String {
        var jason:String=""
        var aUser=Users(null,null,null,null,null,null)
        transaction {
            User.select{User.firstName eq name}.withDistinct().map {
                aUser=Users(it[User.tag],it[User.lastName], it[User.firstName],it[User.email],it[User.gender],it[User.password])
            }

            jason= Json.encodeToString(aUser)
        }
        return jason
    }

    override fun getAll(): String {
        var jason:String=""
        transaction {
            val listUser=ArrayList<Users>()
            for (user in  User.selectAll()){
                listUser.add(Users(tag = user[User.tag],lastName = user[User.lastName],firstName = user[User.firstName],email = user[User.email],gender = user[User.gender],password = user[User.password]))
            }
            jason= Json.encodeToString(listUser)
        }
        return jason
    }
    override fun close() {}
}