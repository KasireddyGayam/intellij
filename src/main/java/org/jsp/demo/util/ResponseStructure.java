package org.jsp.demo.util;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
    private T data;
    private String message;
    private int status;
}
