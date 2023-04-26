package capoeira.capoeiraweb.service;

import capoeira.capoeiraweb.dto.MemberDTO;
import capoeira.capoeiraweb.entity.MemberEntity;
import capoeira.capoeiraweb.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void login_info(MemberDTO memberDTO) {
        // 1. dto -> entity 변환
        // 2. repositoty의 login_info 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //repositoty의 login_info메서드 호출 (조건. entity객체를 넘겨줘야 한다)
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
            1.회원이 입력한 아이디로 DB에서 조회를 함
            2.DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<MemberEntity> byId = memberRepository.findById(memberDTO.getId());
        if (byId.isPresent()) {
            //조회 결과가 있다 (해당 아이디를 가진 회원이 있다)
            MemberEntity memberEntity = byId.get();
            System.out.println("서비스 조회 결과가 있다");
            if (memberEntity.getPassword().equals(memberDTO.getPassword())) {
                //비밀번호 일치
                //entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                System.out.println("서비스 성공");
                return dto;
            }else {
                // 비밀번호 불일치 (로그인 실패)
                System.out.println("서비스 실패");
                return null;
            }
        }else {
            //조회 결과가 없다 (해당 아이디를 가진 회원이 없다)
            System.out.println("서비스 조회결과 없음");
            return null;
        }
    }

    public String idChenk(String id) {
        Optional<MemberEntity> byId = memberRepository.findById(id);
        if (byId.isPresent()) {
            //조회결과가 있다 -> 사용할수 없다.
            return null;
        }else {
            //조회결과가 없다 -> 사용할수 있다.
            return "ok";
        }
    }
}
