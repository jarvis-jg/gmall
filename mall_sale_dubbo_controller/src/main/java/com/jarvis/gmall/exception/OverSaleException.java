package com.jarvis.gmall.exception;

/**
 * gmall : com.jarvis.gmall.exception
 *
 * @author jarvis
 * @create 2019-12-25 20:34
 */
public class OverSaleException extends Exception {

    public OverSaleException(String over_sale) {
        super(over_sale);
    }
}
