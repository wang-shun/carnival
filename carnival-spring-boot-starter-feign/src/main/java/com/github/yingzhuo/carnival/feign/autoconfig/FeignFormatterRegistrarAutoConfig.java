/*
 *  ____    _    ____  _   _ _____     ___    _
 * / ___|  / \  |  _ \| \ | |_ _\ \   / / \  | |
 * | |    / _ \ | |_) |  \| || | \ \ / / _ \ | |
 * | |___/ ___ \|  _ <| |\  || |  \ V / ___ \| |___
 * \____/_/   \_\_| \_\_| \_|___|  \_/_/   \_\_____|
 *
 * https://github.com/yingzhuo/carnival
 */
package com.github.yingzhuo.carnival.feign.autoconfig;

import com.github.yingzhuo.carnival.feign.formatter.FeignCalendar2StringConverter;
import com.github.yingzhuo.carnival.feign.formatter.FeignDate2StringConverter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * @author 应卓
 */
@EnableConfigurationProperties({
        FeignFormatterRegistrarAutoConfig.DateProps.class,
        FeignFormatterRegistrarAutoConfig.CalendarProps.class
})
public class FeignFormatterRegistrarAutoConfig implements FeignFormatterRegistrar {

    @Autowired
    private DateProps dateProps;

    @Autowired
    private CalendarProps calendarProps;

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addConverter(new FeignCalendar2StringConverter(calendarProps.getPattern()));
        registry.addConverter(new FeignDate2StringConverter(dateProps.getPattern()));
    }

    // -------------------------------------------------------------------------------------

    @Getter
    @Setter
    @ConfigurationProperties(prefix = "carnival.feign.date-formatter")
    public static class DateProps {
        private String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
    }

    @Getter
    @Setter
    @ConfigurationProperties(prefix = "carnival.feign.calendar-formatter")
    public static class CalendarProps {
        private String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
    }

}
