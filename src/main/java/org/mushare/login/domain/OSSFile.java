package org.mushare.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login_oss_file")
public class OSSFile implements Serializable {

    public static final String[] units = {"B", "KB", "MB", "GB", "TB"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long createdAt;

    @Column(nullable = false)
    private String pathname;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private Boolean uploaded;

    @Column
    private Long uploadAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OSSFile ossFile = (OSSFile) o;
        return Objects.equals(id, ossFile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getSizeString() {
        long size = this.size;
        int unit = 0;
        while (size >= 1024) {
            size /= 1024;
            unit++;
        }
        return size + " " + units[unit];
    }

}
