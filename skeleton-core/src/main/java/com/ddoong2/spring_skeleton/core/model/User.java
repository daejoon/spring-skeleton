package com.ddoong2.spring_skeleton.core.model;

import lombok.*;

import javax.persistence.*;

@Getter
@EqualsAndHashCode(of = {"id"}, callSuper=false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "AGE", nullable = false)
    private int age;

    @Builder
    protected User(final Long id, final String name, final int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
