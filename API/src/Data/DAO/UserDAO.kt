import com.dardev.Data.Interface.IUserDAO
import com.google.gson.Gson
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
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

    override fun removeUser(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getById(tag: Int):String {
        var jason:String=""
        var aUser=Users(null,null,null,null,null,null)
        transaction {
            User.select{User.tag eq tag}.withDistinct().map {
                aUser=Users(it[User.tag],it[User.lastName], it[User.firstName],it[User.email],it[User.gender],it[User.password])
            }

            jason=Gson().toJson(aUser)
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

            jason=Gson().toJson(aUser)
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
            jason=Gson().toJson(listUser)
        }
        return jason
    }
    override fun close() {}
}