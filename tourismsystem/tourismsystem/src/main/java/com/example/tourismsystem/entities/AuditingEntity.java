package com.example.tourismsystem.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class AuditingEntity extends BasicEntity{

   @Column(name = "created_at",unique = false)
    private Date created_at=new Date();
   @Column(name = "updated_at")
    private Date updated_at=new Date();

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
