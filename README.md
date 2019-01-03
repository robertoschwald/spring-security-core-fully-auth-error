# spring-security-core-fully-auth-error
Sample application showing Grails springsec-core 3.2.3 doesn't work with remember-me on fully secured resources.

See [Grails Spring Sec Core Issue #566](https://github.com/grails-plugins/grails-spring-security-core/issues/566)

On a remember-me login, an access to such a resource is expected to show the login page with a relogin message.

Instead, a browser redirect loop error happens. No indication of an AuthenticationException in the logs.

Not sure if this is an issue, or a config problem.

# Running the application
```
./grailsw run-app
```

1. Login with: admin / password (tick the remember-me checkbox)
2. Access http://localhost:8080/role/index after login (works).
3. Now restart your browser, and access http://localhost:8080/role/index again. 

A Re-Login should occur, but a redirect-loop happens.

# application.groovy
Holds springsecurity access rules containing 'isFullyAuthenticated()'. 

# Alternate tests
Also tested with these rules (same effect):
```
[pattern: '/role/**', access:["isFullyAuthenticated() and hasRole('ROLE_ADMIN')"]]
```

```
[pattern: '/role/**', access:["ROLE_ADMIN", "IS_AUTHENTICATED_FULLY"]]
```

Tested using persistent- and non-persistent tokens. 

Tested with Annotation driven security rule as well. Same result.

# Environment
* Zulu OpenJDK 1.8
* Grails 3.3.8
* OSX



