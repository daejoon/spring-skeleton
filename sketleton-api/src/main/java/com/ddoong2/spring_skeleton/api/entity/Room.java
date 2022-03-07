package com.ddoong2.spring_skeleton.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Room {

    @Id
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<Student> students = new ArrayList<>();
}
