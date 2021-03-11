package by.belinvest.panel.admin.util;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String DATASOURCE_ERROR = "datasourceError";

//TODO:Добавить логер
//    private static final Logger logger = LogManager.getLogger();

//    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public void handleNotFoundException(Exception ex) {
////        logger.error(ex);
//    }

    @ExceptionHandler(value = DataAccessException.class)
    public void handleDataAccessException (Model model) {
        model.addAttribute(DATASOURCE_ERROR);
    }
}
