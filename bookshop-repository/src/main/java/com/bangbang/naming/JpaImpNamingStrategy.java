package com.bangbang.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

/**
 * @author gaoxiong@asiainfo.com
 * @date 2019-07-09 22:17
 */

public class JpaImpNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {


    private static final long serialVersionUID = -6710314110215072353L;


    private static final String PERFIX = "bangb_";


    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        return super.toIdentifier(PERFIX + stringForm, buildingContext);
    }
}
