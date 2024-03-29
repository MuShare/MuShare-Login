package org.mushare.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login_app")
public class App implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long createdAt;

    @Column(nullable = false)
    private Long updatedAt;

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sdkSecret;

    @Column(nullable = false)
    private String apiSecret;

}
