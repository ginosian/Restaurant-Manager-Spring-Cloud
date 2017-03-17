package com.user.dao;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Martha on 2/27/2017.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(isolation = Isolation.DEFAULT,
               propagation = Propagation.REQUIRED)
@interface WriteUpdateTransactional {}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(isolation = Isolation.DEFAULT,
               propagation = Propagation.REQUIRED)
@interface ReadTransactional {}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(isolation = Isolation.DEFAULT,
        propagation = Propagation.REQUIRED)
@interface DeleteTransactional {}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(isolation = Isolation.DEFAULT,
        propagation = Propagation.REQUIRED)
@interface ReadRowsTransactional {}



