package com.cg.pecunia.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNameStrategy extends PhysicalNamingStrategyStandardImpl {


    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        // TODO Auto-generated method stub
        String table_name = name.getText().concat("_tbl");
        Identifier identifier = new Identifier(table_name, name.isQuoted());
        return super.toPhysicalTableName(identifier, context);
    }
    
    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
    	// TODO Auto-generated method stub
    	
    	return super.toPhysicalColumnName(convertToSnakeCase(name), context);
    }
    
    private Identifier convertToSnakeCase(final Identifier identifier) {
        final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        final String newName = identifier.getText()
          .replaceAll(regex, replacement)
          .toLowerCase();
        return Identifier.toIdentifier(newName);
    }
    
}
 



