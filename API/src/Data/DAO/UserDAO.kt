import com.dardev.Data.Interface.IUserDAO

class UserDAO :IUserDAO{
    val listUser= mutableListOf<Users>()

    override fun addUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun updateUser(tag: Int, aUser: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeUser(tag: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getById(tag: Int): User {
        TODO("Not yet implemented")
    }

    override fun getByName(name: String): User {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<User> {
        TODO("Not yet implemented")
    }
}