package com.nuongdol.authen.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "role-permissions")
public class RolePermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "permission_id")
    private Long permissionId;
}
