package com.advantech.homework.excption;

import java.util.HashMap;
import java.util.Map;


public enum ControllerErrorCode {
    SUCCESS(0),
    FAILED(1),
    REQ_ERR_BASE(4000),
    REQ_401_BASE(4010),
    TOKEN_LACK(4011),
    TOKEN_INVALID(4012),
    REQ_403_BASE(4030),
    NO_PERMISSION(4031),
    SRV_ERR_BASE(5000),
    USER_NOT_EXIST(5001),
    PASSWORD_ERROR(5002),
    TOKEN_RENEWAL_FAILED(5003),
    TOKEN_CHECK_INVALID(5004),
    PASSWORD_FORMAT_WRONG(5005),
    MAILSERVER_CONN_FAILED(5006),
    LOGGER_CONFIG_ERROR(5007),
    DID_NOT_EXIST(5008),
    PHONE_NOT_EXIST(5009),
    VE_CODE_EXPIRED(5010),
    VE_CODE_ERROR(5011),
    USERID_IS_NULL(5012),
    UNKNOW_ERROR(Integer.MAX_VALUE);

    private static final String INVALID_CODE_MSG = "Invalid code";
    private static final String SUCCESS_MSG = "Success";
    private static final String TOKEN_LACK_MSG = "Http request header lack authentication token";
    private static final String TOKEN_INVALID_MSG = "Token invalid";
    private static final String NO_PERMISSION_MSG = "No permission";
    private static final String USER_NOT_EXIST_MSG = "User not exist";
    private static final String PASSWORD_ERROR_MSG = "Password error";
    private static final String TOKEN_RENEWAL_FAILED_MSG = "Renewal token failed";
    private static final String TOKEN_CHECK_INVALID_MSG = "Token invalid";
    private static final String PASSWORD_FORMAT_WRONG_MSG = "Password length is greater than 6 and less than 128";
    private static final String MAILSERVER_CONN_FAILED_MSG = "Failed to connect to the mail server, please check the parameter";
    private static final String LOGGER_CONFIG_ERROR_MSG = "Log config failed";
    private static final String DID_NOT_EXIST_MSG = "DeviceId not exist";
    private static final String PHONE_NOT_EXIST_MSG = "Phone not exist";
    private static final String VE_CODE_EXPIRED_MSG = "Verification code expired";
    private static final String VE_CODE_ERROR_MSG = "Verification code error";
    private static final String USERID_IS_NULL_MSG = "UserId is null";
    private static final String UNKNOW_ERROR_MSG = "Unknow";

    private int code;
    private ControllerErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    private static final Map<Integer, ControllerErrorCode> integerToEnum = new HashMap<>();
    static {
        for(ControllerErrorCode evtType : values()) {
            integerToEnum.put(evtType.code, evtType);
        }
    }

    public static ControllerErrorCode valueOf(int code){
        return integerToEnum.get(code);
    }

    public static String toString(ControllerErrorCode code){
        String msg = INVALID_CODE_MSG;
        switch(code){
            case SUCCESS:
                msg = SUCCESS_MSG;
                break;
            case USER_NOT_EXIST:
                msg = USER_NOT_EXIST_MSG;
                break;
            case PASSWORD_ERROR:
                msg = PASSWORD_ERROR_MSG;
                break;
            case TOKEN_INVALID:
                msg = TOKEN_INVALID_MSG;
                break;
            case TOKEN_LACK:
                msg = TOKEN_LACK_MSG;
                break;
            case TOKEN_RENEWAL_FAILED:
                msg = TOKEN_RENEWAL_FAILED_MSG;
                break;
            case TOKEN_CHECK_INVALID:
                msg = TOKEN_CHECK_INVALID_MSG;
                break;
            case NO_PERMISSION:
                msg = NO_PERMISSION_MSG;
                break;
            case PASSWORD_FORMAT_WRONG:
                msg = PASSWORD_FORMAT_WRONG_MSG;
                break;
            case MAILSERVER_CONN_FAILED:
                msg = MAILSERVER_CONN_FAILED_MSG;
                break;
            case LOGGER_CONFIG_ERROR:
                msg = LOGGER_CONFIG_ERROR_MSG;
            case DID_NOT_EXIST:
                msg = DID_NOT_EXIST_MSG;
                break;
            case PHONE_NOT_EXIST:
                msg = PHONE_NOT_EXIST_MSG;
                break;
            case VE_CODE_EXPIRED:
                msg = VE_CODE_EXPIRED_MSG;
                break;
            case VE_CODE_ERROR:
                msg = VE_CODE_ERROR_MSG;
                break;
            case USERID_IS_NULL:
                msg = USERID_IS_NULL_MSG;
                break;
            case UNKNOW_ERROR:
                msg = UNKNOW_ERROR_MSG;
                break;
        }
        return msg;
    }
}
