package dmit2015.security;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.security.enterprise.SecurityContext;

public class MovieSecurityInterceptor {

    @Inject
    private SecurityContext _securityContext;

    @AroundInvoke
    public Object verifyAccess(InvocationContext ic) throws Exception {
        String methodName = ic.getMethod().getName();
        if (methodName.toLowerCase().startsWith("add") || methodName.toLowerCase().startsWith("update")) {
            boolean havePermission = _securityContext.isCallerInRole("ROLE_USER") || _securityContext.isCallerInRole("Sales");
            if (!havePermission) {
                throw new RuntimeException("Access denied. You do not have permission to execute this method.");
            }
        } else if (methodName.toLowerCase().startsWith("delete")) {
            boolean havePermission = _securityContext.isCallerInRole("ROLE_ADMIN")
                    || _securityContext.isCallerInRole("Administration")
                    || _securityContext.isCallerInRole("IT");
            if (!havePermission) {
                throw new RuntimeException("Access denied. You do not have permission to execute this method.");
            }
        }
        return ic.proceed();
    }
}
