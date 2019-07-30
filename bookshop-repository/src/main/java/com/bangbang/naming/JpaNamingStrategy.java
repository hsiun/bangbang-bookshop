package com.bangbang.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-09 16:08
 */

public class JpaNamingStrategy implements PhysicalNamingStrategy {

    public static final String PERFIX = "BB_";


    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            return Identifier.toIdentifier(PERFIX + identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            return Identifier.toIdentifier(PERFIX + identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            return Identifier.toIdentifier(PERFIX + identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            return Identifier.toIdentifier(PERFIX + identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if (identifier != null) {
            return Identifier.toIdentifier(PERFIX + identifier.toString().toUpperCase());
        }
        return null;
    }
}
