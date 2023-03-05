package com.projek.model.Response;

public class ErrorResponse extends CommonResp{
    public ErrorResponse(String code, String message) {
        super.setCode(code);
        super.setMessage(message);
        super.setStatus("FAILED");
    }
}
