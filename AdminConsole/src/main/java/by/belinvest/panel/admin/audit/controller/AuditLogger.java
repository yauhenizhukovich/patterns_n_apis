package by.belinvest.panel.admin.audit.controller;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLogger {

    @After("execution(* by.belinvest.panel.admin.audit.controller.AuditLog.getLogUserActDirectory(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println("@@@@@@@@@@@@@@@@@" + currentUserName);
        }
    }

    @After("execution(* by.belinvest.panel.admin.nsi.db.NsiRepository.create(..))")
    public void afterCreateAdvice(JoinPoint joinPoint) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getArgs()[0]);
    }

    @After("execution(* by.belinvest.panel.admin.nsi.db.NsiRepository.update(..))")
    public void afterUpdateAdvice(JoinPoint joinPoint) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + joinPoint.getArgs()[0]);
    }


}
