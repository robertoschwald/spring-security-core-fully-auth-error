package grails338

import com.yourapp.Role
import com.yourapp.User
import com.yourapp.UserRole

class BootStrap {

    def init = { servletContext ->

        println "Creating user and roles"
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def testUser = new User(username: 'admin', password: 'password').save()
        UserRole.create testUser, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1

    }
    def destroy = {
    }
}
