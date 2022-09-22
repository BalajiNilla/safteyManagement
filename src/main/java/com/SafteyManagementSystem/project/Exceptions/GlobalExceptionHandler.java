package com.SafteyManagementSystem.project.Exceptions;
import java.time.LocalDateTime;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String msg=ex.getMessage();
		String details = "The method you requested is not supported by application";
		APIerrors errors = new APIerrors(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}


	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String msg=ex.getMessage();
		String details ="The input you have given is of wrong type";
		APIerrors errors = new APIerrors(msg,details,status,LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}
	@ExceptionHandler(IdnotFoundException.class)
	public ResponseEntity<Object> handleIdnotFoundException(IdnotFoundException ex){
		String msg=ex.getMessage();
		String details ="Id is not  available";
		APIerrors errors = new APIerrors(msg,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}
	@ExceptionHandler(CannotsaveException.class)
	public ResponseEntity<Object> handleCannotsaveException(CannotsaveException ex){
		String msg=ex.getMessage();
		String details ="This Id is already present so cannot save";
		APIerrors errors = new APIerrors(msg,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	@ExceptionHandler(ValuesNotPresent.class)
	public ResponseEntity<Object> ValuesNotPresentException(ValuesNotPresent ex){
		String msg=ex.getMessage();
		String details ="There is no data in the table";
		APIerrors errors = new APIerrors(msg,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception ex){
		String msg=ex.getMessage();
		String details ="Sorry there is an error";
		APIerrors errors = new APIerrors(msg,details,HttpStatus.BAD_REQUEST,LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}
}
