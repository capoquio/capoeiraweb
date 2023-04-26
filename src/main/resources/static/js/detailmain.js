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
          //$('#commentWriter').val(''); //작성자 입력칸을 초기화하는 js문법
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
  location.href = "/capoeiraweb/delete/" + id;
}