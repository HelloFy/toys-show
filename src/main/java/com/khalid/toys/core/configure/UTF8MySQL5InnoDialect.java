package com.khalid.toys.core.configure;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by 费玥 on 2016/12/12.
 */
public class UTF8MySQL5InnoDialect extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
