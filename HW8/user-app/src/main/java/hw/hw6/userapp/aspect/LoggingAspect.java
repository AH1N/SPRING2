package hw.hw6.userapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(hw.hw6.userapp.controller.UserController+)")// указывает класс методы которого будут перехвачены
    public void anyUserControllerMethod() {}

    @Before("anyUserControllerMethod()")
    public void beforeAnyTaskManagerMethod(){
        LOGGER.info(">>> BEFORE ----Используется метод контроллера user-app-->UserController  <<<");
    }

    @Pointcut("execution(* hw.hw6.userapp.controller.UserController.getUser())")// указывает класс методы которого будут перехвачены
    public void anyControllerMethod() {}

    @Before("anyControllerMethod()")
    public void beforeAnyControllerMethod(){
        LOGGER.info(">>> BEFORE ----Используется метод контроллера user-app-->UserController-->getUser() <<<");
    }

    @Pointcut("within(hw.hw6.userapp.controller.UserController+) && @annotation(hw.hw6.userapp.controller.TrackUserAction)")
    public void TrackUserActionControllerMethod() {}

    @Before("TrackUserActionControllerMethod()")
    public void beforeTrackUserActionControllerMethod(){
        LOGGER.info(">>> BEFORE ----Используется метод контроллера user-app-->UserController-->c аннотацией @TrackUserAction <<<");
    }
}
