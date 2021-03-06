/*
 *  ____    _    ____  _   _ _____     ___    _
 * / ___|  / \  |  _ \| \ | |_ _\ \   / / \  | |
 * | |    / _ \ | |_) |  \| || | \ \ / / _ \ | |
 * | |___/ ___ \|  _ <| |\  || |  \ V / ___ \| |___
 * \____/_/   \_\_| \_\_| \_|___|  \_/_/   \_\_____|
 *
 * https://github.com/yingzhuo/carnival
 */
package com.github.yingzhuo.carnival.restful.security.listener;

import com.github.yingzhuo.carnival.restful.security.userdetails.UserDetails;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Method;

/**
 * 认证监听器
 * <p>
 * 当认证成功时被回调
 * </p>
 *
 * @author 应卓
 */
public interface AuthenticationListener {

    public void onAuthenticated(WebRequest request, UserDetails userDetails, Method method);

}
