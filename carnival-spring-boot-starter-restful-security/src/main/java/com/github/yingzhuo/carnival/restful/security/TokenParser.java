/*
 *  ____    _    ____  _   _ _____     ___    _
 * / ___|  / \  |  _ \| \ | |_ _\ \   / / \  | |
 * | |    / _ \ | |_) |  \| || | \ \ / / _ \ | |
 * | |___/ ___ \|  _ <| |\  || |  \ V / ___ \| |___
 * \____/_/   \_\_| \_\_| \_|___|  \_/_/   \_\_____|
 *
 * https://github.com/yingzhuo/carnival
 */
package com.github.yingzhuo.carnival.restful.security;

import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * 令牌解析器
 *
 * @see com.github.yingzhuo.carnival.restful.security.impl.HttpBasicTokenParser
 */
public interface TokenParser {

    public Optional<Token> parse(NativeWebRequest webRequest);

}
