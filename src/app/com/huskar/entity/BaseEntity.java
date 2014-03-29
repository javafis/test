package com.huskar.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * 业务Entity的基类
 */
@MappedSuperclass
public class BaseEntity extends IdEntity {
	
}
