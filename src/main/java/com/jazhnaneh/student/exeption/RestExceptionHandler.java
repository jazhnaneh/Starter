package com.jazhnaneh.student.exeption;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    protected Logger logger = LoggerFactory.getLogger(getClass());


//    @ExceptionHandler({ConflictException.class,DataIntegrityViolationException.class})
//    protected ResponseEntity<Object> handleConflictException(ConflictException e) {
//        ApiError apiError = new ApiError(CONFLICT);
//        apiError.setMessage(e.getMessage());
//        return buildResponseEntity(apiError);
//    }
//





    /**
     * Handle MissingServletRequestParameterException. Triggered when a 'required' request parameter is missing.
     *
     * @param ex      MissingServletRequestParameterException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
//    @Override
//    protected ResponseEntity<Object> handleMissingServletRequestParameter(
//            MissingServletRequestParameterException ex, HttpHeaders headers,
//            HttpStatus status, WebRequest request) {
//        String error = ex.getParameterName() + " parameter is missing";
//        return buildResponseEntity(new ApiError(BAD_REQUEST, error, ex));
//    }


    /**
     * Handle HttpMediaTypeNotSupportedException. This one triggers when JSON is invalid as well.
     *
     * @param ex      HttpMediaTypeNotSupportedException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
//    @Override
//    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
//            HttpMediaTypeNotSupportedException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(ex.getContentType());
//        builder.append(" media type is not supported. Supported media types are ");
//        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
//        return buildResponseEntity(new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, builder.substring(0, builder.length() - 2), ex));
//    }

    /**
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
     *
     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
//        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
//        return buildResponseEntity(apiError);
//    }

    /**
     * Handles javax.validation.ConstraintViolationException. Thrown when @Validated fails.
     *
     *
     * @return the ApiError object
     */
//    @ExceptionHandler(TooManyRequestException.class)
//    protected ResponseEntity<Object> handleTooManyRequestInLimitTime(TooManyRequestException tooManyRequestException) {
//        ApiError apiError = new ApiError(HttpStatus.TOO_MANY_REQUESTS);
//        apiError.setMessage(tooManyRequestException.getMessage());
//        return buildResponseEntity(apiError);
//    }

//     @ExceptionHandler(MinioException.class)
//    protected ResponseEntity<Object> handleTooMinoException(MinioException minoException) {
//        ApiError apiError = new ApiError(PROCESSING);
//        apiError.setMessage(minoException.getMessage());
//        return buildResponseEntity(apiError);
//    }
//









    //429 Too Many Requests
    //The user has sent too many requests in a given amount of time. Intended for use with rate limiting schemes. This code has been accepted in RFC 6585 Additional HTTP Status Codes.
    //
    //http://i.stack.imgur.com/Y84Lj.jpg
    //
    //   The 429 status code indicates that the user has sent too many
    //   requests in a given amount of time ("rate limiting").
//     @ExceptionHandler(javax.validation.ConstraintViolationException.class)
//    protected ResponseEntity<Object> handleConstraintViolationException(
//            javax.validation.ConstraintViolationException ex) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getConstraintViolations());
//        return buildResponseEntity(apiError);
//    }



    /**
     * Handles EntityNotFoundException. Created to encapsulate errors with more detail than javax.persistence.EntityNotFoundException.
     *
     * @param ex the EntityNotFoundException
     * @return the ApiError object
     */
//    @ExceptionHandler({EntityNotFoundException.class})
//    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
//        ApiError apiError = new ApiError(NOT_FOUND);
//        apiError.setMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }



    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(notFoundException.getMessage());
        return buildResponseEntity(apiError);
    }


//
//
//  @ExceptionHandler({BlockedException.class})
//    protected ResponseEntity<Object> handleBlocked(BlockedException  blockedException) {
//        ApiError apiError = new ApiError(FORBIDDEN);
//        apiError.setMessage(blockedException.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//
//
//
//  @ExceptionHandler({OtpExpireException.class})
//    protected ResponseEntity<Object> handleOtpExpireException(OtpExpireException  blockedException) {
//        ApiError apiError = new ApiError(FORBIDDEN);
//        apiError.setMessage(blockedException.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//
//@ExceptionHandler({UserFoundException.class})
//    protected ResponseEntity<Object> handleUserFoundException(UserFoundException  userFoundException) {
//        ApiError apiError = new ApiError(FOUND);
//        apiError.setMessage(userFoundException.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//    /**
//     * Handle HttpMessageNotReadableException. Happens when request JSON is malformed.
//     *
//     * @param ex      HttpMessageNotReadableException
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
//        //log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
//        String error = "Malformed JSON request";
//        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
//    }
//
//    /**
//     * Handle HttpMessageNotWritableException.
//     *
//     * @param ex      HttpMessageNotWritableException
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String error = "Error writing JSON output";
//        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex));
//    }
//
//    /**
//     * Handle NoHandlerFoundException.
//     *
//     * @param ex
//     * @param headers
//     * @param status
//     * @param request
//     * @return
//     */
//    @Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(
//            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));
//        apiError.setDebugMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    /**
//     * Handle javax.persistence.EntityNotFoundException
//     */
///*    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
//    protected ResponseEntity<Object> handleEntityNotFound(javax.persistence.EntityNotFoundException ex) {
//        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, ex));
//    }*/
//
//    /**
//     * Handle DataIntegrityViolationException, inspects the cause for different DB causes.
//     *
//     * @param ex the DataIntegrityViolationException
//     * @return the ApiError object
//     */
//
//
//
//
//
//    @ExceptionHandler({SqlException.class,SQLException.class, DataAccessException.class})
//    public ResponseEntity<Object> databaseError(Exception ex) {
//        System.out.println("in global call sql Error");
//        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"Database error" ,ex));
//
//        // Nothing to do.  Returns the logical view name of an error page, passed
//        // to the view-resolver(s) in usual way.
//        // Note that the exception is NOT available to this view (it is not added
//        // to the model) but see "Extending ExceptionHandlerExceptionResolver"
//        // below.
//    }
//
//
//
//
//
//
//
//
//
//    /**
//     * Handle Exception, handle generic Exception.class
//     *
//     * @param ex the Exception
//     * @return the ApiError object
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
//                                                                      WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
//        apiError.setDebugMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//
//
//    @ExceptionHandler({AlreadyExistsException.class})
//    protected ResponseEntity<Object> handleAlreadyExistsEception(AlreadyExistsException e){
//        ApiError apiError = new ApiError(CONFLICT);
//        apiError.setMessage("Already Exists Exception");
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler({RestServiceException.class})
//    protected ResponseEntity<Object> handleRestServiceException(RestServiceException e){
//        ApiError apiError = new ApiError(BAD_GATEWAY);
//        apiError.setMessage("Http Server Error Exception");
//        return buildResponseEntity(apiError);
//    }
//
//
//
//
//
//
//
//
//
//

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
