/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.entity3.service;

import org.springframework.data.domain.Auditable;

import java.io.Serializable;

/**
 * @author viktor
 */
public interface AuditableEntityService<T extends Auditable<?, ID>, ID extends Serializable> extends EntityService<T, ID> {
    public T findLastModified();

}
