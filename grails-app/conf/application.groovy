
// logout by GET allowed
grails.plugin.springsecurity.logout.postOnly = false

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.yourapp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.yourapp.UserRole'
grails.plugin.springsecurity.authority.className = 'com.yourapp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['IS_AUTHENTICATED_REMEMBERED']],
	[pattern: '/secure/**',      access: ['isFullyAuthenticated()']],
	[pattern: '/role/**',        access: ['isFullyAuthenticated()']],
	[pattern: '/user/**',        access: ['isFullyAuthenticated()']],
	[pattern: '/health',         access: ['isFullyAuthenticated()']],
	[pattern: '/health/**',      access: ['isFullyAuthenticated()']],
	[pattern: '/error',          access: ['IS_AUTHENTICATED_REMEMBERED']],
	[pattern: '/index',          access: ['IS_AUTHENTICATED_REMEMBERED']], // welcome page
	[pattern: '/index.gsp',      access: ['IS_AUTHENTICATED_REMEMBERED']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

