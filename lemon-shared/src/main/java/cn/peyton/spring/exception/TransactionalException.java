package cn.peyton.spring.exception;

/**
 * <h3>事务异常类</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.exception.TransactionalException.java
 * @createDate: 2018-10-10 21:07
 * @version: 1.0.0
 * </pre>
 */
public class TransactionalException extends RuntimeException{

    public TransactionalException() {
    }

    public TransactionalException(String message) {
        super(message);
    }

    public TransactionalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionalException(Throwable cause) {
        super(cause);
    }

    public TransactionalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
