package capoeira.capoeiraweb.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false) //updatable : 수정시에는 관여안함
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(insertable = false) //insertable : 입력시에는 관여 안함
    private LocalDateTime updatedTime;
}
