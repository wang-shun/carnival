/*
 *  ____    _    ____  _   _ _____     ___    _
 * / ___|  / \  |  _ \| \ | |_ _\ \   / / \  | |
 * | |    / _ \ | |_) |  \| || | \ \ / / _ \ | |
 * | |___/ ___ \|  _ <| |\  || |  \ V / ___ \| |___
 * \____/_/   \_\_| \_\_| \_|___|  \_/_/   \_\_____|
 *
 * https://github.com/yingzhuo/carnival
 */
package com.github.yingzhuo.carnival.restful.security.exception;

/**
 * @author 应卓
 */
public class LimitedAdultContentException extends AuthorizationException {

    private static final long serialVersionUID = 8746181628579979929L;

    public LimitedAdultContentException() {
    }

    public LimitedAdultContentException(String message) {
        super(message);
    }
}
