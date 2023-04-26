package capoeira.capoeiraweb.dto;

import capoeira.capoeiraweb.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long no;
    private String id;
    private String password;
    private String cagroup;
    private String name;
    private String nickname;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setCagroup(memberEntity.getCagroup());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setNickname(memberEntity.getNickname());
        return memberDTO;
    }
}
