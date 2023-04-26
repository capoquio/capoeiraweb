package capoeira.capoeiraweb.entity;

import capoeira.capoeiraweb.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    // no,pk(@Id) id,uk

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(unique = true)
    private String id;

    @Column
    private String password;

    @Column
    private String cagroup;

    @Column
    private String name;

    @Column
    private String nickname;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setCagroup(memberDTO.getCagroup());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setNickname(memberDTO.getNickname());

        return memberEntity;
    }


}