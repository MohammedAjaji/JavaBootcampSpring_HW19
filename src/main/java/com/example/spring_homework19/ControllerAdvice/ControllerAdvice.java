package com.example.spring_homework19.ControllerAdvice;


import com.example.spring_homework19.ApiException.ApiException;
import com.example.spring_homework19.ApiResponse.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

        @ExceptionHandler(value = ApiException.class)
        public ResponseEntity<ApiResponse> ApiException (ApiException e){
                String message = e.getMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        @ExceptionHandler(value = JpaSystemException.class)
        public ResponseEntity<ApiResponse> JpaSystemException (JpaSystemException e){
                String message = e.getMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        @ExceptionHandler(value = DataIntegrityViolationException.class)
        public ResponseEntity<ApiResponse> DataIntegrityViolationException (DataIntegrityViolationException e){
                String message = e.getMessage();
                return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
        public ResponseEntity<ApiResponse> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
                String massage = e.getMessage();
                return ResponseEntity.status(400).body(new ApiResponse(massage));
        }


}
