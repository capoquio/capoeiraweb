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
    @Column(updatable = false) //updatable : 수정한 이후 기존에 저장되어 있던 데이터를 수정할 수 없게끔 막는다.
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(insertable = false) //insertable : 컬럼을 수정한 이후 들어오는 데이터를 막는다.
    private LocalDateTime updatedTime;
}
