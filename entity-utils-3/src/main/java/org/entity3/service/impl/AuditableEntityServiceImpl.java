/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entity3.service.impl;

import org.entity3.service.AuditableEntityService;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.io.Serializable;

/**
 * @param <T>
 * @author viktor
 */
public abstract class AuditableEntityServiceImpl<T extends Auditable<?, ID>, ID extends Serializable> extends EntityServiceImpl<T, ID> implements AuditableEntityService<T, ID> {


    protected AuditableEntityServiceImpl() {
        super();
    }


    public AuditableEntityServiceImpl(Class<T> entityClass, String... maskedProperty) {
        super(entityClass, maskedProperty);
    }

    public T findLastModified() {
        return getRepository().findOne(createLastModifiedSpecification());
    }

    protected Specification<T> createLastModifiedSpecification() {
        return new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Expression e = root.get("lastModifiedDate");
                Expression e2 = root.get("createdDate");
                query.orderBy(cb.desc(e), cb.desc(e2));
                return query.getRestriction();
            }
        };
    }
}
