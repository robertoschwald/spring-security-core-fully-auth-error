# spring-security-core-fully-auth-error
Sample application showing Grails springsec-core 3.2.3 doesn't work with remember-me on fully secured resources.

# application.groovy
Holds springsecurity access rules containing 'isFullyAuthenticated()'. On a remember-me login, an access to such a resource is expected to show the login page with a relogin message.

Instead, a redirect loop error happens.

# Environment
* Zulu OpenJDK 1.8
* Grails 3.3.8
* OSX



