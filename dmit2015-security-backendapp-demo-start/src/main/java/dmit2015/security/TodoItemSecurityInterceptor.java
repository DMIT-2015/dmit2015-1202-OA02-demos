package dmit2015.security;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.security.enterprise.SecurityContext;

public class TodoItemSecurityInterceptor {

    @Inject
    private SecurityContext _securityContext;

    @AroundInvoke
    public Object verifyAccess(InvocationContext ic) throws Exception {
        if (_securityContext.getCallerPrincipal() == null) {
            throw new RuntimeException("Access denied. You do not have permission to execute this method.");
        }
        return ic.proceed();
    }
}
