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
@Table(name = "login_device")
public class Device implements Serializable {

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
    private String accessToken;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Integer os;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private String language;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

}
