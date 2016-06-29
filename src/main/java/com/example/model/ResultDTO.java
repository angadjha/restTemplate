package com.example.model;

/**
 * Created by yongjunjung on 2016. 5. 27..
 */

public class ResultDTO {

    private String resultCode;
    private String resultMessage;

    public ResultDTO() {

    }

    public ResultDTO(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
