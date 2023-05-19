  $(document).ready(function() {
    // 댓글작성 버튼 클릭 이벤트
    $('#comment-write-btn').click(function() {
      // 작성자와 내용을 가져옴
      const writer = $('#commentWriter').val();
      const contents = $('#commentContents').val();
      console.log("작성자: ", writer);
      console.log("내용: ", contents);

      // 게시글 번호 가져옴
      const boardId = Number($('#board-id').val());

      // 로그인 여부 확인
      const nickname = $('#nickname').val();
      if (!nickname || writer.trim() === '') {
        // 작성자가 비어있거나 로그인되어 있지 않으면 댓글 작성 막기
        // 필요한 경우 메시지를 출력하거나 원하는 동작을 수행할 수 있습니다.
        console.log('댓글 작성을 막습니다. 작성자를 입력해주세요.');
        return;
      }

      // 댓글작성 요청 보냄
      $.ajax({
        type: 'POST',
        url: '/comment/save',
        data: {
          commentWriter: writer,
          commentContents: contents,
          boardId: boardId
        },
        success: function(res) {
          console.log('요청성공', res);
          $('#comment-list').load(' #comment-list > *');

          // 작성자와 내용 입력칸 초기화
          $('#commentWriter').val('');
          $('#commentContents').val('');
        },
        error: function(err) {
          console.log('요청실패', err);
        }
      });
    });
  });



const listReq = () => {
  console.log("목록 요청");
  const page = Number($('#page').val());

  location.href = "/capoeiraweb/paging?page=" + page;
}

const updateReq = () => {
  console.log("수정 요청");
  const id = Number($('#board-id').val());

  location.href = "/capoeiraweb/update/" + id;
}

const deleteReq = () => {
  console.log("삭제 요청");
  const id = Number($('#board-id').val());

  // 세션에서 닉네임 가져오기 05-05수정
  const nickname = $("#nickname").val();

  if (nickname) {
      // 세션에 닉네임이 저장되어 있으면 글삭제 요청 보내기
      location.href = "/capoeiraweb/delete/" + id;
      console.log("nickname" , nickname);
  } else {
    // 세션에 닉네임이 저장되어 있지 않으면 메시지 띄우기
    alert("로그인이 필요합니다");
    location.href = "/capoeiraweb/login";

  }
}
