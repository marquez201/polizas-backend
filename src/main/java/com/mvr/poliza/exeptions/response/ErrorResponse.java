package com.mvr.poliza.exeptions.response;

public record ErrorResponse (
    MetaFailure meta,
    Data data
) { }
