package com.mvr.poliza.dtos.response;

public record ApiResponse<T> (
    T data,
    Meta meta
) 
{ }
