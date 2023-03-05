package com.projek.model.Response;

import org.springframework.http.HttpStatus;

public class SuccessResp<N> extends CommonResp {

    N data;

    public SuccessResp(String message, N data) {
        super.setCode("200");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }

    public N getData() {
        return data;
    }

    public void setData(N data) {
        this.data = data;
    }
}
